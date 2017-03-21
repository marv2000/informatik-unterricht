package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quersumme {

	public static void main(String[] args) throws IOException {
		System.out.println("Wähle eine Zahl zwischen 10 und 99");
		int Zahl= tastatureingabe();
		if (Zahl<10){
			System.out.println(Zahl);
		}
		else{
			int l=quersumme(Zahl);
			System.out.println(l);
		}
		
		
	}
	public static int tastatureingabe() throws IOException{				//Tastatur eingsbe
		BufferedReader c;
		c=new BufferedReader(new InputStreamReader(System.in));
		String bLine=c.readLine();
		int l=Integer.parseInt(bLine);

		return l;		
	}
	
	public static int quersumme(int zahl){
			int summand1=zahl%10;
			int summand2 = (zahl-summand1)/10;
			int quersumme=summand1+summand2;
			return quersumme;
		
	}
}
