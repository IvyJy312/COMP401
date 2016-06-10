package a2jedi;

import java.util.Scanner;

import a2.Picture;
import a2.Pixel;

public class A2Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Picture p = readPictureFromScanner(s);
		Picture w = new_Pic(p);
		printPicture(w);
	}

	public static Picture readPictureFromScanner(Scanner s) {
		int width=s.nextInt();
		int height=s.nextInt();
		Picture a = new Picture (width,height);
		for(int i=0; i<height;i++){
			for(int j=0; j<width;j++){
				Pixel p=new Pixel(s.nextInt());
				a.setPixel(j, i, p);
			}

		}
		return a;
	}

	public static Picture new_Pic(Picture p){
		int width=p.getWidth();
		int height=p.getHeight();
		Picture new_p= new Picture(width,height);
		for(int i=0; i<height;i++){
			for(int j=0; j<width;j++){
				int sum=0;
				int count=0;
				if(i+1<height){
					sum=sum+(p.getPixel(j, i+1)).getIntensity();
					count++;
				}
				if(i-1>=0){
					sum=sum+(p.getPixel(j, i-1)).getIntensity();
					count++;
				}
				if(j-1>=0 & i+1<height){
					sum=sum+(p.getPixel(j-1, i+1)).getIntensity();
					count++;
				}
				if(j+1<width & i+1<height){
					sum=sum+(p.getPixel(j+1, i+1)).getIntensity();
					count++;
				}
				if(j-1>=0 & i-1>=0){
					sum=sum+(p.getPixel(j-1, i-1)).getIntensity();
					count++;
				}
				if(i-1>=0 & j+1<width){
					sum=sum+(p.getPixel(j+1, i-1)).getIntensity();
					count++;
				}
				if(j+1<width){
					sum=sum+(p.getPixel(j+1, i)).getIntensity();
					count++;
				}
				if(j-1>=0 ){
					sum=sum+(p.getPixel(j-1, i)).getIntensity();
					count++;
				}
				/*
				Pixel a=p.getPixel(j, i);
				Pixel a1=p.getPixel(j, i+1);
				Pixel a2=p.getPixel(j, i-1);
				Pixel a3=p.getPixel(j-1, i-1);
				Pixel a4=p.getPixel(j-1, i+1);
				Pixel a5=p.getPixel(j-1, i);
				Pixel a6=p.getPixel(j+1, i+1);
				Pixel a7=p.getPixel(j+1, i-1);
				Pixel a8=p.getPixel(j+1, i);
				 */
				Pixel temp_p=new Pixel(sum/count);
				new_p.setPixel(j, i, temp_p);
			}
		}
		return new_p;
	}


	public static void printPicture(Picture w) {
		for(int i=0; i<w.getHeight();i++){
			for(int j=0; j<w.getWidth();j++){
				Pixel a=w.getPixel(j,i);
				System.out.print(a.asChar());


			}
			System.out.println();
		}

	}

}
