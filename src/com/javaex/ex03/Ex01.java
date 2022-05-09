package com.javaex.ex03;

public class Ex01 {

	public static void main(String[] args) {

		Thread thread = new Thread(new DigitImpl());
		//Runnable digit = new DigitImpl();
		//Thread thread = new Thread();
		thread.start();
		
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
