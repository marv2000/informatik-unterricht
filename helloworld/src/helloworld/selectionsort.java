package helloworld;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
//import java.io.*;

public class selectionsort {
static int berechnungen;
static int speicherzugriffe;
static int x;



public static void main(String[] args) throws IOException {
	System.out.print("Stellen den Arrays: ");				//text eingabe für Stellen des Arrays + grenzen der zufälligen werte
	int n= tastatureingabe();
	
	System.out.print("Anfang der Zufallszahlen: ");			//anfang von random
	int l= tastatureingabe();
	
	System.out.print("Ende der Zufallszahlen: ");			//ende von random
	int m=tastatureingabe();
	
	System.out.print("Array durchsuchen nach der Zahl: ");	//search
	int k=tastatureingabe();
			
	int[] list = new int[n];  	 										//array definieren
	fill(list, l, m);													//array füllen
	System.out.print("Das unsortierte Array: \n");output(list);    		//array anzeigen		
	System.out.print("Stellen den Arrays: " + list.length + "\n");	 	//anzeigen der Stellen
	search(list,k);														//durchsuchen des unsortierten arrays
	System.out.println();
	Auswahl(list);
	
}






public static void Auswahl(int []list) throws IOException{       //auswahl des Algorythmuses
	
	System.out.println("Welcher Sortieralgorythmus?");				
	System.out.println("1.Selectionsort 2.Bubblesort 3.Shakersort");
	int Sort = tastatureingabe();
	
	if (Sort ==1){
		selectionSortMethode(list);
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n zum Vergleich:");
		bubblesort(list);
	}
	else if (Sort==2){
		selectionsort2(list);				//bug
		bubblesort(list);
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n zum Vergleich:");
		selectionSortMethode(list);
	}
	else if(Sort==3){
		shakersort(list);
	}
	else if (Sort<1||Sort>3){
		System.out.println("Auswahl zwischen 1 und 3!");
	}
	else{
		//blupp
	}
}				

public static void selectionSortMethode(int[] array){  //SelectionSort Methode
	
	for (int i=0; i<array.length;i++){									//tauscht erste position mit gefundenem minimum; zählt erste Stelle hoch
//		output(array);													//ausgabe des array nach jedem schritt
		int minimum =findMinimum(array,i,array.length);					//suchen vom Minimum
		if(i!=minimum)													//tauschen falls wert kleiner als position i
			swap(array,i,minimum);										//tauschen
	}
	System.out.println("sortiert mit Selektionsort:");
	output(array);														//ausgabe des arrays nach selection sort
	if(isSorted(array)){												//prüfen ob array sotiert ist
		System.out.print("Das Array ist sortiert!" + "\n");  			//ausgabe wenn sortiert
	} else {
		System.out.print("Das Array ist noch nicht sortiert!" + "\n"); 	//ausgabe wenn nichtsortiert
	}
	System.out.print("Speicherzugriffe: "+speicherzugriffe + "\n");			//ausgabe der Speicherzugriffe
	System.out.print("Berechnungen: " + berechnungen + "\n");			//ausgabe der Berechnungen
//	turn(array);														//drehen des sortiertem array
}
public static void selectionsort2 (int[]array){
	for (int i=0; i<array.length;i++){					//tauscht erste position mit gefundenem minimum; zählt erste Stelle hoch
//		output(array);									//ausgabe des array nach jedem schritt
		int minimum =findMinimum(array,i,array.length);	//suchen vom Minimum
		if(i!=minimum)									//tauschen falls wert kleiner als position i
			swap(array,i,minimum);
	}
}

public static void bubblesort(int [] array){			//bubblesort
		int length=array.length-2;
		for (int i=0; i<length;i++){						
			if (array[i]> array[i+1]){						//vergleichen von zwei stellen
				swap(array,array[i],array[i+1]);			//tauschen wenn i größer ist als i+1
			}
			length=length-1;
		}
		System.out.println("sortiert mit bubblesort:");
		output(array);
	}
public static void swap (int[] array, int position1, int position2){  //Swap methode
	int zwischenspeicher=array[position1];			// speicher der ersten position in zwischenspeicher
	array[position1]=array[position2];				// position 1 wird mit position 2 überschrieben
	array[position2]=zwischenspeicher;				//position 2 wird mit dem zwischenspeicher (position 1)überschrieben	
	speicherzugriffe++;								//anzahl aller Speicherzugriffe
}	

public static int findMinimum(int[] array, int startIndex, int endIndex) { //find minimum
	int currentMinimum = array[startIndex];		//aller erste minimum ist startwert
	int position = startIndex;
	for (int i=startIndex;i<(endIndex);i++){	//"schritt für schritt" durch das Array
		if(array[i]<currentMinimum){			//vergleich von der stelle mit aktuellem minimum
			position=i;							//position der neuen kleinsten Stelle
			currentMinimum = array[i];			//neue kleinste Stelle
			berechnungen++;						//Anzahl der Rechenschritte
		}
	}
	return position;							//return position of minimums
}	
public static int findeMaximum(int[] array, int startIndex, int endIndex) { //find maximum
	int currentMaximum = array[startIndex];		//aller erste maximum ist startwert
	int position = startIndex;
	for (int i=startIndex;i<(endIndex);i++){	//"schritt für schritt" durch das Array
		if(array[i]>currentMaximum){			//vergleich von der stelle mit aktuellem maximum
			position=i;							//position der neuen größten Stelle
			currentMaximum = array[i];			//neue größten Stelle
		}
	}
	return position;							//return position of minimums
}	

public static void output(int[] array){  //output methode
	for (int c=0; c<array.length; c++){
		System.out.print("["+array[c]+"]"); //output complete Arrays
	}
	System.out.print("\n");
}

public static void fill(int[] array,int start,int ende){  //fill array with random numbers
	for (int c=0; c<array.length; c++){
		Random rand = new Random(); 
		array[c] = rand.nextInt(ende+1-start) + start;
	}
	System.out.print("\n");
}	

public static boolean isSorted(int[] array){    // Sorted(prüfen)
	boolean sorted=true;					// erstellen der boolean Variable
	int i=0;
	int endIndex=array.length;
	//for (int i=0; sorted && i<endIndex; i++){
	while(sorted && i<endIndex-1){			//solange es sortier ist und i kleiner ist als das array lang ist	
		if(array[i]>array[i+1]){			// falls die stelle i größer als i+1 ist
			sorted=false;					// dann nicht sortiert
		}
		i++;								//nächste stelle
	}
	return sorted;							//rückgabe ob sortiert oder nicht
}

public static void turn (int [] array){					//array umdrehen
	int l=x-1;											//position altes array
	int[] arrayturned = new int[l];						//neues array erstellen
	
	for (int i=0; i < l;i++){
		arrayturned[i]=array[l];						// neues array füllen
		l=l-1;
	}
	
	System.out.println("Sortiert andersherum");
	output(arrayturned);
}

public static void search (int [] array, int zahl){					//durchsuchen des Array
	int anzahl =0;										//vorkommen der Zahl
	System.out.println("Suche nach "+ zahl);
	for (int i=0;i<array.length-1;i++ ){
		if (array[i]== zahl){
			System.out.print(i+ " ");				
		anzahl=anzahl+1;
		}
	}	
	System.out.println();
	if (anzahl == 0){								//fals die Zahl nicht vorkommt
		System.out.println("Nicht vorhanden");
	}
	else{
		System.out.println("Anzahl von "+zahl+" in Array: "+anzahl);  //wie oft die Zahl vorkommt
	}		
}		
public static int tastatureingabe() throws IOException{
	BufferedReader c;
	c=new BufferedReader(new InputStreamReader(System.in));
	String bLine=c.readLine();
	int l=Integer.parseInt(bLine);

	return l;		
}	
public static void shakersort(int[] array){
	int untereGrenze=0;
	int obereGrenze=array.length-1;
	for (int i=0;untereGrenze<=obereGrenze;i++){
		if ((i%2)!=0){
			swap(array,findeMaximum(array,untereGrenze,obereGrenze),obereGrenze);
			obereGrenze=obereGrenze-1;
		}
		if ((i%2)==0){
			swap (array,findMinimum(array,untereGrenze,obereGrenze),untereGrenze);
			untereGrenze++;
		}		
	}
	output(array);
	
	
	
}
public static void gnomsort(int []array){
	int i=0;
	while(isSorted(array)!=true && i<array.length-2){
		if (array[i]<array[i+1]){
			i++;
		}
		else{
			
		}
	}
	
}
}