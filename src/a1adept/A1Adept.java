package a1adept;

import java.util.Scanner;

public class A1Adept {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		process(s);

	}

	public static void process(Scanner s) {
		int binwidth = s.nextInt();
		//the size of the bin
		int width = s.nextInt() ;
		int height= s.nextInt();
		// width * height is the number of tokens
		int rownum=99/binwidth+1;
		//row number 
		int total=width*height;
		//total input nums
		int [ ] num = new int[rownum];
		//array to classify the input
		for(int i=0; i<total;i++){
			int j=s.nextInt();
			for(int h=0;h<rownum;h++){
				if(j>=h*binwidth & j<(h+1)*binwidth){
					num[h]++;
				}
			}
		}
		//add total num of input to each bin
		for(int h=0;h<rownum;h++){
			if(h*binwidth<10){
				System.out.print(" "+h*binwidth+":");
			}
			//pattern
			else{
				System.out.print(h*binwidth+":");
			}
			for(int k=0; k<(int)((double)num[h]*100/total+0.5);k++){
				System.out.print("*");
			}
			//print "*"
			System.out.println();
		}
	}
}



