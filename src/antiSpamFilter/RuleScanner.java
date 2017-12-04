package antiSpamFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * General pourpose rule.cf reader/writer with only static methods
 * @author ES1-METI-PL-106
 * 
 * **/

public class RuleScanner {
	
	/**
	 * 
	 * rules.cf File reader
	 * @param filelocation rules.cf absolute path
	 * @return HashMap rules
	 * 
	 * **/
	
	public static HashMap<String,Double> readFile(String filelocation) {
		
	HashMap<String,Double> rules = new HashMap<String,Double>();
		
	try {

        File file = new File(filelocation);

        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] ruleValue=line.split(" ");
            String rule=ruleValue[0];
            double value=0;
            
            if(ruleValue.length>1){
            	value = Double.parseDouble(ruleValue[1]);
            }
            rules.put(rule, value);   
        }
        input.close();

    	} catch (Exception ex) {
        ex.printStackTrace();
    	}
	
	return rules;
	}
	
	/**
	 * 
	 * General purpose HashMap to String[][] converter
	 * @param rulesArray
	 * @return String rules
	 * 
	 * **/
	
	public static String[][] MapToArray(HashMap<String,Double> rulesArray){

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
	
	/**
	 * 
	 * rules.cf File writer
	 * @param filepath rules.cf absolute path
	 * @param rules rules.cf current configuration
	 * 
	 * **/
	
	public static void writeFile(String filepath, String[][] rules){
		try{
			PrintWriter writer = new PrintWriter(filepath, "UTF-8");
			
			for(int i=0; i<rules.length; i++){
				writer.println(rules[i][0] + " " + rules[i][1]);
				}
			writer.close();
			
		} catch(IOException ex){}
	}
	
	public static String[] resultReader() {
		String line = "";
		BufferedReader in;
		ArrayList<Integer> fp = new ArrayList<Integer>();
		ArrayList<Integer> fn = new ArrayList<Integer>();
		
		try {
			in = new BufferedReader(new FileReader("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.rf"));
				while ((line = in.readLine()) != null) {
				    String falses[] = line.split(" ");
				    fp.add((int) Double.parseDouble(falses[0]));
				    fn.add((int) Double.parseDouble(falses[1]));
					}
				in.close();
		} catch (IOException e) {return null;}
		
		int smallest=fp.get(0);
		int indexSmallest=0;
		for(int curr: fp) {
			if(curr < smallest) {
				smallest=curr;
				indexSmallest=fp.indexOf(curr);
			}
			if(curr == smallest) {
				if(fn.get(fp.indexOf(curr)) < fn.get(indexSmallest)){
					smallest=curr;
					indexSmallest=fp.indexOf(curr);
				}
			}
		}
		String[] result=new String[2];
		result[0]=fp.get(indexSmallest).toString();
		result[1]=fn.get(indexSmallest).toString();
		return result;
	
	}
	
	public static void main(String[] args) {
		//System.out.println(RuleScanner.readFile("rules.cf"));
		System.out.println(Arrays.toString(RuleScanner.resultReader()));
	}


}
