package antiSpamFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AntiSpamFilterProblem() {
	    // 335 variables (anti-spam filter rules) rules.cf lines 
	    this(335);
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){
	    
	    double[] falsos = new double[getNumberOfObjectives()]; //falsos[0]=FALSOS POSITIVOS falsos[1]=FALSOS NEGATIVOS
	    double[] pesos = new double[getNumberOfVariables()]; //pesos para exprimentar
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      pesos[i] = solution.getVariableValue(i) ;
	    }
	    
	    HashMap<String,Double> rules= RuleScanner.readFile("rules.cf");
	    int i=0;
	    for (Entry<String, Double> entry : rules.entrySet()) {
	    	rules.put(entry.getKey(), pesos[i]);
	    	i++;
	    }
	    // System.out.println(rules);
	    MailTest test = new MailTest(rules);
	    
	    falsos[0]=test.getFP();
	    // System.out.println("Falsos positivos " + falsos[0]);
	    falsos[1]=test.getFN();
	    // System.out.println("Falsos negtivos " + falsos[1]);
	    solution.setObjective(0, falsos[0]);
	    solution.setObjective(1, falsos[1]);
	  }
	}
