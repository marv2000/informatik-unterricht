package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quersumme {

	public static void main(String[] args) throws IOException {
		System.out.println("Quersumme: 1 / Fakult�t: 2");
		int x=tastatureingabe();
		if ( x==1){
			System.out.println("W�hle eine Zahl zwischen 10 und 99");
			int Zahl= tastatureingabe();
			if (Zahl<10){
				System.out.println(Zahl);
			}
			else{
				int l=quersumme(Zahl);
				System.out.println(l);
			}
		}
		if(x==2){
			System.out.println("W�hle eine Zahl");
			int Zahl =tastatureingabe();
			System.out.println(Zahl+"!= "+fakult�t(Zahl));
		}
		if (x>2||x<1){
			System.out.println("hasch es nid gecheckt, oder?");
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
	public static double fakult�t(int n){
		double e=1;
		for (int i=1; i<=n;i++){
			e=e*i;
		}
		return e;
	}
}
