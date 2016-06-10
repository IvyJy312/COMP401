package a2novice;
import java.util.Scanner;

import a2.Picture;
import a2.Pixel;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Picture p = readPictureFromScanner(s);
		printPicture(p);
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
	
	public static void printPicture(Picture p) {
		for(int i=0; i<p.getHeight();i++){
			for(int j=0; j<p.getWidth();j++){
				Pixel a=p.getPixel(j,i);
				System.out.print(a.asChar());


			}
			System.out.println();
		}

	}

	}
