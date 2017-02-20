package helloworld;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] hallo= new int[5];
		for (int i=0; i<5 ;i++){
			hallo[i]=i;
		}
		output(hallo);
		turn(hallo);
				
		
		
		
	}
	public static void turned(int []array){
		
		int []arrayturned=new int [array.length];
		
		
	}
	
	
	
	
	public static void turn (int [] array){
		int l=array.length-1;
		int[] arrayturned = new int[array.length];
		
		for (int i=0; i < l && l>0;i++){
			arrayturned[i]=array[l];
			l=l-1;
		}
		
		System.out.println("Sortiert andersherum");
		output(arrayturned);
	}
	
	
	
	
public static void output(int[] array){  //output methode
			for (int c=0; c<array.length; c++){
				System.out.print("["+array[c]+"]"); //output complete Arrays
			}
			System.out.print("\n");
		}

}
