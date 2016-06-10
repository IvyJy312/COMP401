package a1jedi;

import java.util.Scanner;

public class A1Jedi {


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
		int max=0;
		//the biggest percent

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
		for(int j=0; j<total;j++){
			if(max<num[j]*100/total){
				max=num[j]*100/total;
			}
		}
		//find the biggest percent 
		for(int k=max-1;k>=0;k--){	
			for(int i=0; i<rownum;i++){
				if((int)((double)num[i]*100/total+0.5)>k){
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		//reverse loop 

		for(int j=0;j<rownum;j++){
			System.out.print("-");
		}
		System.out.println();
        // print "-"
		for(int h=0;h<rownum;h++){
			if(h*binwidth/10==0){
				System.out.print(" ");
			}
			else{
				System.out.print(h*binwidth/10);
			}
		}
		System.out.println();
		// divide by 10 get the integer of the binwidth

		for(int i=0;i<rownum;i++ ){
			System.out.print(i*binwidth%10);
		}
       // divide by 10 get the remainder of the binwidth 
	}
		
}




