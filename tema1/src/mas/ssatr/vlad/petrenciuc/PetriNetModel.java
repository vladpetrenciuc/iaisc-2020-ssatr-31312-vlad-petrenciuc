package mas.ssatr.vlad.petrenciuc;


import java.util.ArrayList;

public class PetriNetModel {
    public int step_number = 0;
    private ArrayList<Place> places;
    private ArrayList<Transition> transitions;

    public PetriNetModel() {
        PetriNetLoader pnl = new PetriNetLoader();
        this.places = pnl.places;
        this.transitions = pnl.transitions;
    }


        public ArrayList<String> get_state() {
            ArrayList<String> state = new ArrayList<String>();
            for (Place p : this.places) {
                state.add(String.valueOf(p.getTokens()));
            }
            return state;
        }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void Step() {
        ArrayList<Transition> executable = new ArrayList<>();
        for (Transition t : this.transitions) {
            if (t.allHaveToken(t.inPlaces) || t.hasToken() == 1) {
                executable.add(t);
            }
        }

        for (Transition transition : executable) {
            transition.Execute();
            for (Place p : transition.outPlaces) {
                if (p.getTokens()>0)
                    p.startProcessing();
            }
        }

        for (Place p : this.places) {
            if (p.processing_time > 0) {
                p.increaseCurrentTime();
            }
        }
        this.step_number++;
    }
}
