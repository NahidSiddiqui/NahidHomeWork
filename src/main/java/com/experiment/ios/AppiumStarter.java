package com.experiment.ios;

public class AppiumStarter {
	
	public CommandLine cmd = new CommandLine();
	
	public void startAppium(){
	
    System.out.print("Running appium start command");
	String Output = cmd.runCommand("/usr/local/bin/appium");
	
	System.out.print(Output);
	}

}
