package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Primzahlen {

	
	public static void main(String[] args) throws IOException {
		System.out.println("Berechnen von Primzahlen von null bis:");
		int n= tastatureingabe();
		if (n<10){
			ausnahme(n);
		}
		else{
		int [ ] array = new int[n] ; 
		fill(array,n);
		primzahl(array);
		System.out.print("2, 3, 5, 7, ");
		Auslesen(array);
		}
	}
		public static void fill (int [] list,int n){
			for(int i=0; i<n;i++){
				list[i]=i;
			}			
		}
		public static void primzahl(int []list){
			for(int i=2;i<10;i++){
				for (int j=1;j<=list.length-1;j++){
					if (list[j]%i==0){
						list[j]=0;
					}
				}
			}
		}
		public static void Auslesen(int[] list){
			for (int i=2;i<=list.length-1;i++){
				if (list[i]!=0){
					System.out.print(list[i]+", ");
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
		public static void ausnahme(int n ){
			if (n>=7){
				System.out.println("2, 3, 5, 7, ");	
			}
			else if(n<7&&n>=5){
				System.out.println("2, 3, 5, ");	
			}
			else if (n<5&&n>=3){
				System.out.println("2, 3, ");	

			}
			else if (n<3&&n>=2){
				System.out.println("2");	

			}
			else if(n<=2){
				System.out.println("keine Primzahl gefunden");	
			}
		}
}