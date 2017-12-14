package antiSpamFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * Reads .log files and compares it with the given rules configuration to Identify False Positives and False Negatives
 * for ham and spam
 * 
 * @author ES1-METI-PL-106
 * 
 * **/

public class MailTest {
	
	int fn;
	HashMap<String, ArrayList<String> > spam;
	HashMap<String, ArrayList<String> > mail;
	HashMap<String, Double> rulesArray;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param rulesArray Rules Hashmap with rule/value pairs
	 * 
	 * **/
	
	public MailTest(HashMap<String, Double> rulesArray) {
		fn=0;
		this.spam=MailReader.read("src/spam.log");
		this.mail=MailReader.read("src/ham.log");
		this.rulesArray=rulesArray;
	}
	
	/**
	 * 
	 * returns False Positives for mail/rules configuration
	 * @return Integer
	 *
	 * 
	 * **/
	
	public int getFP(){
		int checksum=0;
		for (Entry<String, ArrayList<String>> entry : mail.entrySet()) {
		    ArrayList<String> rules = entry.getValue();
		    double summ=0;
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
	
	
	/**
	 * 
	 * returns False Negatives for spam/rules configuration
	 * @return Integer
	 *
	 * 
	 * **/
	
	public int getFN(){
		int checksum=0;
		for (Entry<String, ArrayList<String>> entry : spam.entrySet()) {
		    ArrayList<String> rules = entry.getValue();
		    double summ=0;
		    for(int i=0; i<rules.size(); i++) {
		    	if(rulesArray.get(rules.get(i))!=null){
		    		summ=summ+rulesArray.get(rules.get(i));
		    	}
		    }
		    if(summ<=5) {
		    	checksum++;
		    }
		}
		return checksum;
	}

}
