package com.example.myapp;

import org.springframework.stereotype.Component;

@Component("appProxy")
public class MyAppProxy {

	public int drawCartoon() {
		System.out.println("--- drawing a cartoon! 0_0 ---");
		return 3;
	}
	
	public void drawNature() {
		System.out.println("--- drawing some nature! ); ---");
	}
	
	public void sculptPottery() {
		System.out.println("--- pot sculpting! XD ---");
	}
	
	public int drawMiniCartoon(int a) {
		System.out.println("--- drawing some mini cartoons! (╯°Д°）╯︵/ ---");
		return 4;
	}
}
