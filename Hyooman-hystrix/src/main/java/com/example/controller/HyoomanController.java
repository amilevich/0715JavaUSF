package com.example.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Hyooman;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/api")
public class HyoomanController {

	RestTemplate restTemp = new RestTemplate();
	
	@HystrixCommand(fallbackMethod = "hystrixDefault")
	@GetMapping(value="/fetchhyoomans")
	public List<Hyooman> fetchHyoomans(){
		URI uri = URI.create("http://localhost:9019/api/allhyoomans/");
		List<Hyooman> hList = restTemp.getForObject(uri, List.class);
		return hList;
	}
	
	public List<Hyooman> hystrixDefault(){
		List<Hyooman> hList = new ArrayList<>();
		hList.add(new Hyooman("Mort", "Four"));
		return hList;
	}
	
}
