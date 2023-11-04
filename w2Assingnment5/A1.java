package w2Assingnment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int countCh=0, countW=0, countl=0;
		File myfile=new File("D:\\eclipse-workspace\\Assignment Neebal\\src\\w2Assingnment5\\input.txt");
		try {

			Scanner sc=new Scanner(myfile);
			while(sc.hasNextLine()) {
				String str=sc.nextLine();
				for(int i=0; i<str.length(); i++) {
					char ch=str.charAt(i);
					if(ch==' ' || ch=='.') {
						countW++;
					}					
					countCh++;
				}
				countl++;
			}
			sc.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		System.out.printf("Character count : %d\nWord count : %d\nLine count : %d",countCh, countW, countl);

	}

}
