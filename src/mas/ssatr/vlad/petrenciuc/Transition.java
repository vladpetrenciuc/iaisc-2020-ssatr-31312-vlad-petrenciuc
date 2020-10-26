package mas.ssatr.vlad.petrenciuc;

import java.util.ArrayList;

public class Transition {
    public String name = "";
    public ArrayList<Place> inPlaces;
    public ArrayList<Place> outPlaces;
    public int time = 0;
    private int current_time = 0;
    private boolean has_token = false;

    public Transition(String name, ArrayList<Place> in_palces, ArrayList<Place> out_places, int time) {
        this.name = name;
        this.inPlaces = in_palces;
        this.outPlaces = out_places;
        this.time = time;
    }

    public boolean allHaveToken(ArrayList<Place> list) {
        for (Place p : list) if (!(p.getTokens() > 0)) return false;
        return true;
    }

    private boolean allCanExecute(ArrayList<Place> list) {
        for (Place p : list) if (!(p.canExecute())) return false;
        return true;
    }

    public int hasToken() {
        if (this.has_token) {
            return 1;
        } else {
            return 0;
        }
    }

    public void Execute() {
        this.current_time++;
        if (allHaveToken(inPlaces)) {
            if (allCanExecute(inPlaces)) {
                for (Place p : inPlaces) {
                    p.extractTokens();
                    this.has_token = true;
                }
            }
        }
        if (this.has_token && (this.current_time > this.time)) {
            for (Place po : outPlaces) {
                po.addTokens();
            }
            this.has_token = false;
            this.current_time = 0;
        }
    }
}
