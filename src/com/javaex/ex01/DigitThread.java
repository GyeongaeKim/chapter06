package com.javaex.ex01;

//생성자 출장기능....

public class DigitThread extends Thread{

	
	
	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); 	//작업속도를 좀 느리게하고 싶을때, 이런식으로 sleep을 넣어줄수있음
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
