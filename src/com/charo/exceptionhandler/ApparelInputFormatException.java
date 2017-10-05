package com.charo.exceptionhandler;

public class ApparelInputFormatException extends Exception{
	
	public ApparelInputFormatException(Exception e)
	{
		System.out.println("Please check your input Format");
		e.printStackTrace();
		
	}

}
