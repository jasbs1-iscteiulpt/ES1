package antiSpamFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * General pourpose rule.cf reader/writer/editor with only static methods
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
	 * @param rulesArray String[][] filled with th HashMap rules/values
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
	
	/**
	 * 
	 * Returns the best configuration results FP=result[0], FN=result[1], and result[2] is the line index 
	 * to get the respective configuration from the generator ".rs" file
	 * 
	 * @return String[] result
	 * 
	 * **/
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
		for(int i=0; i<fp.size(); i++) {
			if(fp.get(i) < smallest) {
				smallest=fp.get(i);
				indexSmallest=i;
			}else{
				if(fp.get(i) == smallest) {
					if(fn.get(i) < fn.get(indexSmallest)){
						smallest=fp.get(i);
						indexSmallest=i;
					}
				}
			}
		}
		String[] result=new String[3];
		result[0]=fp.get(indexSmallest).toString(); //FP
		result[1]=fn.get(indexSmallest).toString(); //FN
		result[2]=Integer.toString(indexSmallest);  //INDEX (linha)
		return result;
	
	}
	
	/**
	 * 
	 * Fills the given Hashmap values with the corresponding configuration result values in the index position of the generated ".rs"
	 *
	 * (ex: if index=2, the resultConfig(config, index) will fill config with the values in the second line (corresponding ones) of the ".rs" file
	 * 
	 * @param config HashMap
	 * @param index value to search config
	 * @return HashMap config
	 * 
	 */
	
	public static HashMap<String, Double> resultConfig(HashMap<String, Double> config, int index){
			
			try {
	
		        File file = new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.rs");
		        Scanner input = new Scanner(file);
		        int lineCount=0;
		        while (input.hasNextLine()) {
		        	if(lineCount==index) {
		        		Scanner line=new Scanner(input.nextLine());
		        		Iterator<Entry<String, Double>> it = config.entrySet().iterator();
		        		while(line.hasNext()) {
		        			double value=Double.parseDouble(line.next());
		        			HashMap.Entry<String, Double> pair = (HashMap.Entry<String, Double>)it.next();
		    		    	config.put(pair.getKey(),value);
		        		}
		        		line.close();
		        		lineCount++;
		        	}
		        	else {
		        		input.nextLine();
		        		lineCount++;
		        	}
		        }
		        input.close();
	
		    	} catch (Exception ex) {
		        ex.printStackTrace();
		    	}
			
			return config;
			
		}
				
		//main de testes
		public static void main(String[] args) {
			System.out.println(RuleScanner.readFile("rules.cf"));
			String[] p = RuleScanner.resultReader();
			int index=Integer.parseInt(p[2]);
			System.out.println(RuleScanner.resultConfig(RuleScanner.readFile("rules.cf"), index));
		}


}
