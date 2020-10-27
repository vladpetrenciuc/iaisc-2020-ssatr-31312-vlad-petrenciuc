package mas.ssatr.vlad.petrenciuc;

import java.io.FileOutputStream;
import java.util.Arrays;

public class SimulationEngine {
    public boolean active = true;
    PetriNetModel pnm = new PetriNetModel();

    public void simulate() {
        String fileName = "tema1/output.txt";
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            while (this.active) {
                System.out.format("Running step %d \n", pnm.step_number); //display the information
                for (Place p : pnm.getPlaces()) {
                    System.out.format("%s: %d, ", p.name, p.getTokens());
                }
                System.out.println();
                for (Transition t : pnm.getTransitions()) {
                    System.out.format("%s: %d, ", t.name, t.hasToken());
                }
                System.out.println();
                String str = String.format("Step: %"+2+"s"+": %s\n", pnm.step_number, String.join(", ", pnm.get_state()));

                byte[] strToBytes = str.getBytes();
                outputStream.write(strToBytes);


                pnm.Step(); //execute a step
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (pnm.step_number == 20) { //stop after 20 steps
                    active = false;
                }

            }
            outputStream.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
