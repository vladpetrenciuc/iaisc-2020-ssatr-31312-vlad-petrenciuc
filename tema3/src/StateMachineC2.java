import java.util.Scanner;

public class StateMachineC2 extends StateMachine {
    private Port p;

    public StateMachineC2(Port p) {
        this.p = p;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = p.getMessage();
            if (!s.isEmpty()) {
                System.out.println("C2: I have received this message: " + s);
                s = "";
            }
        }
    }
}
