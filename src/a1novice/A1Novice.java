package a1novice;
import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	static int width;
	static int height;
	public static void process(Scanner s) {	

		width = s.nextInt();
		height = s.nextInt();
		//scan the first two numbers 
		int i = 0,j = 0,h;
		int Min = 99;
		int Max = 0;
		double Sum = 0.0;
		for(h=0; h<height; h++){
			//return after each line 
			//? why the fifth line count backwards
			// is an empty line
			// sum is the sum of each row
			// min is the min of each row
			// max is the max of each row
			double sum=0.0;
			int min=99;
			int max=0;
			for (i=0; i<width; i++){
				//loop through each row 
				j=s.nextInt();
				if(j>=0 & j<=9){
					System.out.print("#");
				}
				if(j>=10 & j<=19){
					System.out.print("E");
				}
				if(j>=20 & j<=29){
					System.out.print("X");
				}
				if(j>=30 & j<=39){
					System.out.print("O");
				}

				if(j>=40 & j<=49){
					System.out.print("\\");

				}
				if(j>=50 & j<=59){
					System.out.print("/");
				}
				if(j>=60 & j<=69){
					System.out.print("+");
				}
				if(j>=70 & j<=79){
					System.out.print("-");
				}
				if(j>=80 & j<=89){
					System.out.print("|");
				}
				if(j>=90 & j<=99){
					System.out.print(" ");
				}
				if (j<min){
					min=j;
				}
				if(j>max){
					max=j;
				}
				//compare the nums on the same row
				sum+=j;
			}

			if(min<Min){
				Min=min;
			}
			if(max>Max){
				Max=max;
			}
			//compare the min/max among rows
			Sum+=sum;
			// add the sums of each row
			System.out.println();
		}
		System.out.println ("Min value = " + Min);
		System.out.println ("Max value = " + Max);
		System.out.println ("Average value = "+ Sum/(height*width));
	}
}