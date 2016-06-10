package a2adept;

import java.util.Scanner;

import a2.Picture;
import a2.Pixel;

public class A2Adept {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Picture p = readPictureFromScanner(s);
		Picture fin=remove_col(remove_row(p));
		printPicture(fin);
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

	public static Picture remove_col(Picture p){
		boolean [ ] check_col = new boolean [p.getWidth()];
		int width=p.getWidth();
		int height=p.getHeight();
		int new_width=0;
		// the width of new array
		for(int i=0; i<width;i++){
			int count=0;
			for(int j=0;j<height;j++){
				char space=' ';
				Pixel org=p.getPixel(i,j);
				char com =org.asChar();
				if(com ==space){
					count ++;
				}
			}
			if(count != height){
				check_col[i]=true;
				new_width++;
			}

		}

		// entire space --> false
		Picture newPic = new Picture(new_width,height);
		for(int i=0,curr_index=0;i<width;i++){
			if(check_col[i]){
				for(int j=0;j<height;j++){
					newPic.setPixel(curr_index, j, p.getPixel(i, j));
				}
				curr_index++;			
			}
		}
		return newPic;
	}

	public static Picture remove_row(Picture w){
		boolean [ ] check_row = new boolean [w.getHeight()];
		int width=w.getWidth();
		int height=w.getHeight();
		// the height of new array
		int new_height=0;
		for(int i=0; i<height;i++){
			int count=0;
			for(int j=0;j<width;j++){
				char space=' ';
				Pixel org=w.getPixel(j,i);
				char com =org.asChar();
				if(com ==space){
					count ++;
				}
			}
			if(count != width){
				check_row[i]=true;
				new_height++;
			}

		}

		Picture newPic = new Picture(width,new_height);
		for(int i=0,curr_index=0;i<height;i++){
			if(check_row[i]){
				for(int j=0;j<width;j++){
					newPic.setPixel(j, curr_index, w.getPixel(j, i));
				}
				curr_index++;			
			}
		}
		return newPic;
	}


	public static void printPicture(Picture fin) {
		for(int i=0; i<fin.getHeight();i++){
			for(int j=0; j<fin.getWidth();j++){
				Pixel a=fin.getPixel(j,i);
				System.out.print(a.asChar());

			}
			System.out.println();
		}
	}
}



