package com.test.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DrawController {
    @PostMapping("/download")
    public ResponseEntity<byte[]> download(@RequestBody Map<String, Object> args){
        System.out.println(Arrays.toString(DrawController.class.getResource("/").getPath().split("/")));
        JsonReader orgsReader = Json.createReader(new StringReader((String) args.get("jsonOrgs")));
        JsonReader channelsReader = Json.createReader(new StringReader((String) args.get("jsonChannels")));
        System.out.println("进入后端");
        System.out.println((String)args.get("jsonOrgs"));
        JsonObject orgJson = orgsReader.readObject();
        JsonObject chnJson = channelsReader.readObject();
        String[] tempPath = DrawController.class.getResource("/").getPath().split("/");
        StringBuilder BASE = new StringBuilder();
        for(int i=0; i<tempPath.length-2; i++) {
            BASE.append("/").append(tempPath[i]);
        }
        BASE.append("/src/main/resources/templates/");

        List<String> fileList = new ArrayList<String>();
        fileList.add(BASE + "configtx.yaml");
        // fileList.add(BASE + "crypto-config.yaml");
        fileList.add(BASE + "build_env.sh");
        fileList.add(BASE + "docker-compose-cli.yaml");
        fileList.add(BASE + "setup.sh");
        fileList.add(BASE + "docker-compose-ca.yaml");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ZipOutputStream out = new ZipOutputStream(bos);
            String createCommand = "";

            // 遍历所有文件
            for (int i = 0; i < fileList.size(); i++) {
                File file = new File(fileList.get(i));
                FileInputStream in = new FileInputStream(file);
                Long filelength = file.length();
                byte[] fileContent = new byte[filelength.intValue()];
                in.read(fileContent);
                out.putNextEntry(new ZipEntry(file.getName()));
                String strContent = new String(fileContent, "utf-8");

                // 配置docker-compose-ca.yaml
                if (fileList.get(i).endsWith("docker-compose-ca.yaml")) {
                    File caFile = new File(BASE + "/template/ca-template.yaml");
                    FileInputStream caIn = new FileInputStream(caFile);
                    filelength = caFile.length();
                    byte[] caContent = new byte[filelength.intValue()];
                    caIn.read(caContent);
                    String caStrContent = new String(caContent, "utf-8");
                    strContent = strContent.replace("{{DOMAIN_NETWORK}}", "test");
                    int port = 7;
                    // 遍历所有组织
                    for (int index = 0; index < orgJson.size(); index++, port++) {
                        JsonObject org = orgJson.getJsonObject(String.valueOf(index));
                        String partStrContent = caStrContent.replace("{{DOMAIN_NAME}}", org.getString("id"));
                        partStrContent = partStrContent.replace("{{DOMAIN_NETWORK}}", "test");
                        partStrContent = partStrContent.replace("{{ORG_NAME}}", org.getString("name"));
                        partStrContent = partStrContent.replace("{{OUT_PORT}}", port + "054");
                        strContent += partStrContent;
                    }
                    out.write(strContent.getBytes());
                    caIn.close();
                }

                // 配置docker-compose-cli.yaml
                else if (file.getName().equals("docker-compose-cli.yaml")) {
                    File ordererFile = new File(BASE + "/template/orderer-template.yaml");
                    filelength = ordererFile.length();
                    byte[] ordererContent = new byte[filelength.intValue()];
                    FileInputStream ordererIn = new FileInputStream(ordererFile);
                    ordererIn.read(ordererContent);
                    String ordererStrContent = new String(ordererContent, "utf-8");
                    strContent = strContent.replace("{{DOMAIN_NETWORK}}", "test");
                    int index = 0;
                    JsonObject org = orgJson.getJsonObject(String.valueOf(index));
                    String partStrContent = "";
                    int port = 7;
                    // 创建排序节点
                    createCommand += "create_orderer_org " + org.getString("name") + " " + org.getString("id") + " 7054\r\n";
                    // 遍历所有节点
                    for (String key : org.getJsonObject("orderers").keySet()) {
                        partStrContent = ordererStrContent.replace("{{DOMAIN_NAME}}", org.getString("id"));
                        partStrContent = partStrContent.replace("{{DOMAIN_NETWORK}}", "test");
                        partStrContent = partStrContent.replace("{{ORG_MSP}}", toUpperCaseFirstOne(org.getString("name")) + "MSP");
                        partStrContent = partStrContent.replace("{{PEER_NAME}}", org.getJsonObject("orderers").getString(key));
                        partStrContent = partStrContent.replace("{{OUT_PORT}}", port + "050");
                        port++;
                        strContent += partStrContent;
                        createCommand += "create_orderer " + org.getJsonObject("orderers").getString(key) + " " + org.getString("id") + " 7054\r\n";
                    }
                    // 创建peer
                    File peerFile = new File(BASE + "/template/peer-template.yaml");
                    filelength = peerFile.length();
                    byte[] peerContent = new byte[filelength.intValue()];
                    FileInputStream peerIn = new FileInputStream(peerFile);
                    peerIn.read(peerContent);
                    String peerStrContent = new String(peerContent, "utf-8");
                    port = 7;
                    for (index = 1; index < orgJson.size(); index++) {
                        createCommand += "create_org " + org.getString("name") + " " + org.getString("id") + " " + (7 + index) + "054\r\n";
                        org = orgJson.getJsonObject(String.valueOf(index));
                        for (String key : org.getJsonObject("peers").keySet()) {
                            partStrContent = peerStrContent.replace("{{DOMAIN_NAME}}", org.getString("id"));
                            partStrContent = partStrContent.replace("{{DOMAIN_NETWORK}}", "test");
                            partStrContent = partStrContent.replace("{{ORG_MSP}}", toUpperCaseFirstOne(org.getString("name")) + "MSP");
                            partStrContent = partStrContent.replace("{{ORG_NAME}}", org.getString("name"));
                            partStrContent = partStrContent.replace("{{PEER_NAME}}", org.getJsonObject("peers").getString(key));
                            partStrContent = partStrContent.replace("{{OUT_PORT}}", port + "051");
                            port++;
                            strContent += partStrContent;
                            createCommand += "create_peer " + org.getString("name") + " " + org.getJsonObject("peers").getString(key) + " " + org.getString("domain") + " " + (7 + index) + "054\r\n";
                        }
                    }
                    // 创建cli
                    File cliFile = new File(BASE + "/template/cli-template.yaml");
                    filelength = cliFile.length();
                    byte[] cliContent = new byte[filelength.intValue()];
                    FileInputStream cliIn = new FileInputStream(cliFile);
                    cliIn.read(cliContent);
                    String cliStrContent = new String(cliContent, "utf-8");
                    strContent += cliStrContent.replace("{{DOMAIN_NETWORK}}", "test");
                    out.write(strContent.getBytes());
                    ordererIn.close();
                    peerIn.close();
                    cliIn.close();
                }

                // 配置setup.sh
                else if (file.getName().equals("setup.sh")) {
                    createCommand += "\r\n" + "docker-compose -f docker-compose-cli.yaml up -d\r\n";
                    strContent += createCommand;
                    out.write(strContent.getBytes());
                }

                // 配置其他文件
                else {
                    out.write(strContent.getBytes());
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;filename=fabbric.zip");
        return new ResponseEntity<byte[]>(bos.toByteArray(), header, HttpStatus.CREATED);
    }

    public static String toUpperCaseFirstOne (String s){
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
