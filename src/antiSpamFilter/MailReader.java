package antiSpamFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Class used for reading email. Static methods only.
 * 
 *  @author ES1-METI-PL-106
 * 
 * **/

public class MailReader {
	
	/**
	 *  Receives a ".log" file location as input and returns an HashMap with the values of it parsed in
	 *  @param filePath absolute location of the log file
	 *  @return HashMap email
	 * 
	 * **/
	
	public static HashMap<String, ArrayList<String> > read(String filePath){
		
	HashMap<String, ArrayList<String> > hash1 = new HashMap<String, ArrayList<String>>();
	String line = "";
	BufferedReader in;
	try {
		in = new BufferedReader(new FileReader(filePath));
			while ((line = in.readLine()) != null) {
			    String rules4u[] = line.split("\t");
			    ArrayList<String> Array = new ArrayList<String>();
				for(int i=1;i<rules4u.length;i++){
					Array.add(rules4u[i]);
				}
				 hash1.put(rules4u[0],Array);
//				 System.out.println(rules4u[0]+ " " + Array);
			}
			in.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	
		return hash1;
	}
	
	public static void main(String[] pussy){
		System.out.print(MailReader.read("ham.log"));
	}
}
