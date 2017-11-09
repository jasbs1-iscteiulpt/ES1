package antiSpamFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RuleScanner {
	
	public ArrayList<String> rules = new ArrayList<String>();
	
	public void readFile(String filelocation) {
		
	try {

        File file = new File(filelocation);

        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            rules.add(line);
            System.out.println(line);   
        }
        input.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


}
