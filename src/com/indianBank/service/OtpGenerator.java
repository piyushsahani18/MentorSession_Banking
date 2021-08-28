package com.indianBank.service;

public class OtpGenerator {

	    public int generateOTP(){
	        int otp = (int)(Math.random()*9000)+1000;
	        return otp;
	    }
}
