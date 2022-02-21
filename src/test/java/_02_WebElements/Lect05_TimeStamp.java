package _02_WebElements;

import java.util.Date;

public class Lect05_TimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		System.out.println(date.toString().replace(":", "_").replace(" ", "_")+".jpg");
	}

}
