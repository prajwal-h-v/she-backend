package lti.she.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lti.she.entity.Greeting;

@RestController
@CrossOrigin(origins = {"*"})
public class MainController {
    
    @RequestMapping(value = "/greet")
    public Greeting greet(){
        return new Greeting();
    }
}
