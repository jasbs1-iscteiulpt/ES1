package antiSpamFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MailReader {
	
	public static void readHam(){
	HashMap<String, ArrayList<String> > hash1 = new HashMap<String, ArrayList<String>>();
	String line = "";
	BufferedReader in;
	try {
		in = new BufferedReader(new FileReader("ham.log"));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void main(String[] pussy){
		MailReader.readHam();
	}
}
