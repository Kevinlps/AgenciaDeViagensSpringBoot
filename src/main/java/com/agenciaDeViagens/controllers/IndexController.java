package com.agenciaDeViagens.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	 @GetMapping("/")
	    public String index() {
	        return "index";
	    }
	   
	   @GetMapping("/contato")
	    public String contato() {
	        return "contato";
	    }
	   
	   @GetMapping("/destino")
	    public String destino() {
	        return "destino";
	    }
	   
	   @GetMapping("/promocoes")
	    public String promocoes() {
	        return "promocoes";
	    }
}
