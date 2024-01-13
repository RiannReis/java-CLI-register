import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
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

	}

}
