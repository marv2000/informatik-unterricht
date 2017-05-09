package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quersumme {

	public static void main(String[] args) throws IOException {
		while(true){
		System.out.println("Quersumme: 1 / Fakultät: 2 / Multiplizieren: 3 / Dividieren: 4");
		int x=tastatureingabe();
		int anzahl=4;
		if ( x==1){
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
		if(x==2){
			System.out.println("Wähle eine Zahl");
			int Zahl =tastatureingabe();
			System.out.println(Zahl+"!= "+fakultät(Zahl));
		}
		if(x==3){
			System.out.println("Wähle eine Zahl a");
			int Zahl1 =tastatureingabe();
			System.out.println("Wähle eine Zahl b");
			int Zahl2 =tastatureingabe();
			System.out.println(Zahl1 +"*"+Zahl2+"= "+multiplikation(Zahl1, Zahl2));
			
		}
		if(x==4){
			System.out.println("Wähle eine Zahl a");
			int Zahl1 =tastatureingabe();
			System.out.println("Wähle eine Zahl b");
			int Zahl2 =tastatureingabe();
			System.out.println(Zahl1 +"/"+Zahl2+"= "+division(Zahl1, Zahl2));
			
		}
		if (x>anzahl||x<1){
			System.out.println("hasch es nid gecheckt, oder?");
		}
	
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
	public static double fakultät(int n){
		double e=1;
		for (int i=1; i<=n;i++){
			e=e*i;
		}
		return e;
	}
	
	public static int multiplikation (int q ,int p){
		int ergebnis=p;
		for (int i=1; i<q; i++){
			ergebnis=ergebnis +p;
		}
		return ergebnis;	
	}
	public static int division(int q, int p){
		int ergebnis=q;
		int Anzahl=0;
		int Rest=0;
		while(ergebnis>0){
			ergebnis= ergebnis-p;
			Anzahl++;
		}
		if (ergebnis<0){
			Anzahl--;
			ergebnis=ergebnis+p;
			
			while (Rest<ergebnis){
				Rest++;
			}
			System.out.println("Rest: "+Rest);
		}
		
		return Anzahl;
		
	}
	
}
