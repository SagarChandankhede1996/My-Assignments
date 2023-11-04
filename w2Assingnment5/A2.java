package w2Assingnment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inputF=new File("D:\\eclipse-workspace\\Assignment Neebal\\src\\w2Assingnment5\\input.txt");
		FileWriter wF;
		try {
			wF = new FileWriter("D:\\eclipse-workspace\\Assignment Neebal\\src\\copy.txt");
			Scanner sc=new Scanner(inputF);
			while(sc.hasNextLine()) {
				String str=sc.nextLine();
				wF.write(str+"\n");
			}
			wF.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Success ! Check the input file");
	}
}
