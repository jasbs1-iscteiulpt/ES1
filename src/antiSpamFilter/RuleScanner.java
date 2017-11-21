package antiSpamFilter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class RuleScanner {
	
	public static HashMap<String,Integer> readFile(String filelocation) {
		
	HashMap<String,Integer> rules = new HashMap<String,Integer>();
		
	try {

        File file = new File(filelocation);

        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] ruleValue=line.split(" ");
            String rule=ruleValue[0];
            int value=0;
            
            if(ruleValue.length>1){
            	value = Integer.parseInt(ruleValue[1]);
            }
            rules.put(rule, value);   
        }
        input.close();

    	} catch (Exception ex) {
        ex.printStackTrace();
    	}
	
	return rules;
	}
	
	public static String[][] MapToArray(HashMap<String,Integer> rulesArray){

		String[][] rules = new String[rulesArray.keySet().toArray().length][rulesArray.values().toArray().length];
		Object[] rule=rulesArray.keySet().toArray();
		Object[] value=rulesArray.values().toArray();
		for(int i=0; i<rules.length; i++){
				rules[i][0]=rule[i].toString();
				rules[i][1]= value[i].toString();
//				System.out.println(rules[i][0] + " " + rules[i][1]);
			}
//		System.out.println(Arrays.toString(value));
		return rules;
	}
	
	public static void writeFile(String filepath, String[][] rules){
		try{
			PrintWriter writer = new PrintWriter(filepath, "UTF-8");
			
			for(int i=0; i<rules.length; i++){
				writer.println(rules[i][0] + " " + rules[i][1]);
				}
			writer.close();
			
		} catch(IOException ex){}
	}
	
	public static void main(String[] args) {
		System.out.println(RuleScanner.readFile("rules.cf"));
	}


}
