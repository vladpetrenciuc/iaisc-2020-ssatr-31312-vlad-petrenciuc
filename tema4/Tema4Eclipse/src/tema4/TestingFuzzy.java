package tema4;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TestingFuzzy {
    public static void main(String[] args) throws Exception {
        String filename = "C:\\\\Users\\\\Vlad\\\\eclipse-workspace\\\\heater-simulator-master\\\\HeaterSimulator\\\\src\\\\net\\\\agten\\\\heatersimulator\\\\controller\\\\dto\\\\fuzzyController.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("error", 145);

        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("result").defuzzify();

        // Print ruleSet
        System.out.println(fb);
        System.out.println("Result: " + fb.getVariable("result").getValue());


        // Show
        JFuzzyChart.get().chart(fb);

        // Set inputs
        fis.setVariable("error", 145);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = fb.getVariable("result");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);


    }

}