package antiSpamFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MailTest {
	
	int fn;
	HashMap<String, ArrayList<String> > spam;
	HashMap<String, ArrayList<String> > mail;
	HashMap<String, Integer> rulesArray;
	
	
	public MailTest(HashMap<String, Integer> rulesArray) {
		fn=0;
		this.spam=MailReader.read("spam.log");
		this.mail=MailReader.read("ham.log");
		this.rulesArray=rulesArray;
	}
	
	public int getFP(){
		int checksum=0;
		for (Entry<String, ArrayList<String>> entry : mail.entrySet()) {
		    ArrayList<String> rules = entry.getValue();
		    int summ=0;
		    for(int i=0; i<rules.size(); i++) {
		    	if(rulesArray.get(rules.get(i))!=null){
		    		summ=summ+rulesArray.get(rules.get(i));
		    	}
		    }
		    if(summ>5) {
		    	checksum++;
		    }
		}
		return checksum;
	}
	
	public int getFN(){
		int checksum=0;
		for (Entry<String, ArrayList<String>> entry : spam.entrySet()) {
		    ArrayList<String> rules = entry.getValue();
		    int summ=0;
		    for(int i=0; i<rules.size(); i++) {
		    	if(rulesArray.get(rules.get(i))!=null){
		    		summ=summ+rulesArray.get(rules.get(i));
		    	}
		    }
		    if(summ<-5) {
		    	checksum++;
		    }
		}
		return checksum;
	}

}
