package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hyooman;

@RestController
@RequestMapping("/api")
public class HyoomanController {
	
	@GetMapping("/allhyoomans")
	public List<Hyooman> allHyoomans(){
		List<Hyooman> hList = new ArrayList<>();
		hList.add(new Hyooman("Jerry","Mouse"));
		hList.add(new Hyooman("Tom","Cat"));
		hList.add(new Hyooman("Tweety","Birb"));
		hList.add(new Hyooman("FogHorn","LegHorn"));
		return hList;
	}

}
