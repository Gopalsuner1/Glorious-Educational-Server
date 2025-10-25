package in.glorious.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicCon {
    @GetMapping
    public String check(){
        return "Server is Ok" ;
    }
}
