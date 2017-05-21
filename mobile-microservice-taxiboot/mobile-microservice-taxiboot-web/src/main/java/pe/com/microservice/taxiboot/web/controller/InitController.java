package pe.com.microservice.taxiboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
	 
	 @RequestMapping("/")
	 @ResponseBody
	 String home() {
	 return "version1.0";
	 }
	}