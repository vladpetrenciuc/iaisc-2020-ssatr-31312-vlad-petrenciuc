package net.agten.heatersimulator.domain.algorithm;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FuzzyController implements ControllerAlgorithm{
	public short targetAdc;
	public FIS fis;
	public FunctionBlock fb;
	
	public FuzzyController() {
		String filename = "C:\\Users\\Vlad\\eclipse-workspace\\heater-simulator-master\\HeaterSimulator\\src\\net\\agten\\heatersimulator\\controller\\dto\\fuzzyController.fcl";
        this.fis = FIS.load(filename, true);

        if (this.fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        this.fb = this.fis.getFunctionBlock(null);
	}

	@Override
	public short nextValue(short curAdc) {
		// Set inputs
        fb.setVariable("error", this.targetAdc-curAdc);


        // Evaluate
        fb.evaluate();
        //System.out.println(fb.getVariable("result").defuzzify());

        // Show output variable's chart
        return (short)fb.getVariable("result").defuzzify();
	}

	@Override
	public void setTargetAdc(short targetAdc) {
		this.targetAdc=targetAdc;
		
	}

}
