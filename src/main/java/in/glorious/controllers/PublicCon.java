package in.glorious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.glorious.services.StudentService;

@RestController
@RequestMapping("/ok")
public class PublicCon {
    @Autowired
    private StudentService service;

    @GetMapping
    public String check(){
        return "Server is Ok" ;
    }
     @GetMapping("/student")
    public ResponseEntity<?> check1(){
        return ResponseEntity.ok().body(service.getAllStudent()) ;
    }
}
