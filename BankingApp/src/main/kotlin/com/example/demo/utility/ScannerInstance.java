package com.example.demo.utility;

import java.util.Scanner;

public class ScannerInstance
{
	private static ScannerInstance instance;
	
	private Scanner scanner;
	
	private ScannerInstance()
	{
		this.scanner = new Scanner(System.in);
	}
	
	public static ScannerInstance getInstance()
	{
		if (instance == null)
		{
			instance = new ScannerInstance();
		}
		return instance;
	}
	
	public Scanner getScanner()
	{
		return this.scanner;
	}
}
