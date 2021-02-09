package com.test.service;

import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DrawController {
    @PostMapping("/download")
    public ResponseEntity<byte[]> download(@RequestBody Map<String, Object> args){

        return null;
    }
}
