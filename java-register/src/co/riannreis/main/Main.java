package co.riannreis.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import co.riannreis.entities.InterestedPerson;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		File file = new File("form.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("Insert below in order:");
			fw.write(System.lineSeparator());
			fw.write("Your complete name; ");
			fw.write(System.lineSeparator());
			fw.write("Your email; ");
			fw.write(System.lineSeparator());
			fw.write("Your age; ");
			fw.write(System.lineSeparator());
			fw.write("Your heigth (m); ");
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(file);
			
			int i = 0;
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		String InterestedPersonName = sc.nextLine();
		String InterestedPersonEmail = sc.nextLine();
		byte InterestedPersonAge = sc.nextByte();
		float InterestedPersonHeigth = sc.nextFloat();
		
		sc.close();		
		
		InterestedPerson interested = new InterestedPerson(
				InterestedPersonName,
				InterestedPersonEmail,
				InterestedPersonAge,
				InterestedPersonHeigth);
		
		
		
		System.out.println(interested);

	}

}

