package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Primzahlen {
static int AnzahlderPrimzahlen=4;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Berechnen von Primzahlen von null bis:");
		int n= tastatureingabe();									//Grenze für Primzahlen per Tastatureingabe
		
		
		int [ ] array = new int[n] ; 								//Array deffinieren mit n
		fill(array,n);												//Array füllen mit Zahlen von null bis n
		primzahl(array, n);											//Primzahlen ermitteln
		System.out.print("2, 3, 5, 7, ");							//Primzahlen bis 10
		Auslesen(array);											//restliche Primzahlen ausdlesen
		System.out.println("\nEs sind "+ AnzahlderPrimzahlen+" Primzahlen gefunden worden");			//anzahl der Primzahlen ausgeben
		
	}
		public static void fill (int [] list,int n){				//Zahlen ins array eintragen
			for(int i=0; i<n;i++){								
				list[i]=i;
			}			
		}
		public static void primzahl(int []list,int n){					//Primzahhlen berechenen
			for(int i=2;i<n/2;i++){									//Divisor definieren
				for (int j=1;j<=list.length-1;j++){					//durch das array gehen
					if (list[j]%i==0 && j!=i){								// fallsteilbar "null" ins Array eintragen
						list[j]=0;	
					}
				}
			}
		}
		public static void Auslesen(int[] list){
			for (int i=2;i<=list.length-1;i++){						//das array durchsuchen
				if (list[i]!=0){									//falls nicht null dann Primzahl
					System.out.print(list[i]+", ");					//Primzahken ausgeben
					AnzahlderPrimzahlen++;
					tester(i);
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
		public static void tester (int i){
			for (int j=2;j<i/2;j++){
				if (i%j==0){
					System.out.println("false"+j);
				}
			}
		}
		
}