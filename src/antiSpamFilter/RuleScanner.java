package antiSpamFilter;

import java.io.File;
import java.util.Scanner;

public class RuleScanner {
	
	public void readFile(String filelocation) {
		
	try {

        Scanner input = new Scanner(filelocation);

        File file = new File(input.nextLine());

        input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


}
