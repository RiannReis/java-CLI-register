package co.riannreis.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import co.riannreis.entities.InterestedPerson;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<InterestedPerson> people = new ArrayList<>();

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		int value;

		do {
			
			System.out.println("============MENU============");
			System.out.println("[ 0 ] PARA ENCERRAR O PROGRAMA");
			System.out.println("[ 1 ] PARA CADASTRAR PESSOA");
			System.out.println("[ 2 ] PARA LISTAR TODAS AS PESSOAS");
			System.out.println("[ 3 ] PARA CADASTRAR NOVA PERGUNTA");
			System.out.println("[ 4 ] PARA DELETAR PERGUNTA");
			System.out.println("[ 5 ] PESQUISAR PESSOA POR NOME OU IDADE OU EMAIL");
			System.out.println("============MENU============");
			System.out.println();

			value = Integer.parseInt(sc.nextLine());

			switch (value) {
			case 0:
				sc.close();
				System.out.println("ENCERRADO");
				break;
			case 1:
				showQuestions();
				registerInterestedPeople();
				break;
			case 2:
				System.out.println();
				listAll();
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				System.out.println();
			}

		} while (value != 0);
		
	}

	public static void registerInterestedPeople() {
		String InterestedPersonName = sc.nextLine().trim();
		String InterestedPersonEmail = sc.nextLine();
		byte InterestedPersonAge = Byte.parseByte(sc.nextLine());
		float InterestedPersonHeigth = Float.parseFloat(sc.nextLine());

		InterestedPerson interested = new InterestedPerson(InterestedPersonName, InterestedPersonEmail,
				InterestedPersonAge, InterestedPersonHeigth);

		people.add(interested);

		File saveFile = new File(
				people.indexOf(interested) + "-" + InterestedPersonName.toUpperCase().replace(" ", "") + ".txt");

		try {
			FileWriter fwOnSavedFile = new FileWriter(saveFile);

			String tempByte = String.valueOf(InterestedPersonAge);
			String tempFloat = String.valueOf(InterestedPersonHeigth);

			fwOnSavedFile.write(InterestedPersonName);
			fwOnSavedFile.write(System.lineSeparator());
			fwOnSavedFile.write(InterestedPersonEmail);
			fwOnSavedFile.write(System.lineSeparator());
			fwOnSavedFile.write(tempByte);
			fwOnSavedFile.write(System.lineSeparator());
			fwOnSavedFile.write(tempFloat);

			fwOnSavedFile.flush();
			fwOnSavedFile.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(interested);
	}
	
	public static void listAll() {
		
		AtomicInteger number = new AtomicInteger(0);
		
		people.stream().map(p -> p.getName())
		.forEach(name -> System.out.println(number.getAndIncrement() + " - " + name));
	}

	public static void showQuestions() {
		File file = new File("form.txt");

		if (!file.exists()) {

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
		}

		try {
			FileReader fr = new FileReader(file);

			int i = 0;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}

			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}

}
