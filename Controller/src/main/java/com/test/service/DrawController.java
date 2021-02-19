package com.test.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DrawController {
    @PostMapping("/download")
    public ResponseEntity<byte[]> download(@RequestBody Map<String, Object> args){
        JsonReader orgsReader = Json.createReader(new StringReader((String) args.get("jsonOrgs")));
        JsonReader channelsReader = Json.createReader(new StringReader((String) args.get("jsonChannels")));
        JsonObject orgJson = orgsReader.readObject();
        JsonObject chnJson = channelsReader.readObject();
        String[] tempPath = DrawController.class.getResource("/").getPath().split("/");
        StringBuilder BASE = new StringBuilder();
        for(int i=0; i<tempPath.length-4; i++) {
            BASE.append("/").append(tempPath[i]);
        }
        BASE.append("/resources/templates/");

        List<String> fileList = new ArrayList<String>();
        fileList.add(BASE + "configtx.yaml");
        fileList.add(BASE + "crypto-config.yaml");

    }
}
