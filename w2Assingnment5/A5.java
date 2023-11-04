package w2Assingnment5;

import java.io.*;
import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0,sum=0;
		FileWriter wq = null;
		try {
			wq = new FileWriter("D:\\eclipse-workspace\\Assignment Neebal\\src\\output.txt", true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(i<5) {
			double tvi=0;
			
			try {
				Scanner sc = new Scanner(System.in);
				FileWriter	w = new FileWriter("D:\\eclipse-workspace\\Assignment Neebal\\src\\output.txt", true);
				System.out.print("Product code : ");
				int pci=sc.nextInt();
				System.out.print("Cost : Rs ");
				double ci=sc.nextDouble();
				System.out.print("Quantity : ");
				int qi=sc.nextInt();
				tvi=ci*qi;
				System.out.print("Total Value : Rs "+tvi);
				sum+=tvi;
				System.out.println();
				w.write("Product code : "+pci+"\n");
			
				w.write("Cost : Rs "+ci+"\n");
		
				w.write("Quantity : "+qi+"\n");
		
				w.write("Total Value : Rs "+tvi+"\n"+"\n");
				w.close();
				
				} catch (Exception e) {
					System.out.println(e);
				}
			System.out.println();
			
			i++;
		} 
		
		try {
			wq.write("Total value of all products : Rs "+sum);
			wq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total value of all products : Rs "+sum);
	}

}
