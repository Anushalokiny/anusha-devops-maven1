package com.devops.anushadevopsmaven;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
  
  @RequestMapping("/")
  public String index() {
      return "Greetings from Python Life DevOPS Lab assignment ";
  }

}