package mas.ssatr.vlad.petrenciuc;

import java.util.Random;

public class Place {
    public String name = "";
    public int tokens = 0;
    public int min_time = 0;
    public int max_time = 0;
    public int processing_time = 0;
    private int current_time = 0;

    int getTokens() {
        return tokens;
    }

    void addTokens() {
        this.tokens++;
    }

    void extractTokens() {
        this.tokens--;
    }

    void startProcessing() {
        if ((this.processing_time == 0) && (this.current_time == 0) && (this.max_time>0)) {
            Random random = new Random();
            this.processing_time = random.nextInt(this.max_time - this.min_time) + min_time;
        }
    }

    void increaseCurrentTime(){
        this.current_time++;
    }

    boolean canExecute() {
        if (this.processing_time > this.current_time) {
            return false;
        } else {
            this.current_time = 0;
            this.processing_time = 0;
            return true;
        }
    }

    Place(String name, int tokens, int min_time, int max_time) {
        this.name = name;
        this.tokens = tokens;
        this.min_time = min_time;
        this.max_time = max_time;

    }
}
