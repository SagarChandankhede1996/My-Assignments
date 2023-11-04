package w2Assingnment5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inputF=new File("D:\\eclipse-workspace\\Assignment Neebal\\src\\w2Assingnment5\\input.txt");
		FileWriter wF;
		String str="";
		try {
			Scanner sc=new Scanner(inputF);
			wF = new FileWriter(inputF, true);

			while(sc.hasNextLine()) {
				str=sc.nextLine();
				
				wF.append(str);//we can use write to overwrite the file also 
			}
			
			wF.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Success ! Check the input file");
	}

}
