package w2Assingnment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str;
		String[] arrS= {};
		int maxL=0;
		String Lword="";
		File f=new File("D:\\eclipse-workspace\\Assignment Neebal\\src\\w2Assingnment5\\input.txt");
		try {
			Scanner sc=new Scanner(f);

			while(sc.hasNextLine()) {
				str=sc.nextLine();
				arrS=str.split(" ");
				for(int i=0; i< arrS.length;i++) {
					if(arrS[i].length()>maxL) {
						maxL=arrS[i].length();
						Lword=arrS[i].replace(".", "");	
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("Longest Word : "+Lword);	
	}
}