package com.sct.qa.util;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerTest {
	
	public static void logSetup() throws FileNotFoundException {
		DOMConfigurator.configure("C:\\Users\\myusuf\\git\\MYGitRepo\\SCTestAutomationTNG\\LoggerContainer\\log4j.xml");
}
}