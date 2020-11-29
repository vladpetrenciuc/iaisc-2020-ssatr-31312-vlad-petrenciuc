public class Main {
    public static void main(String[] args) {
        Port p1 = new Port();
        Port p2 = new Port();
        p1.setDestination_port(p2);
        StateMachineC1 ST1 = new StateMachineC1(p1);
        StateMachineC2 ST2 = new StateMachineC2(p2);
        Capsule c1 = new Capsule(p1, ST1);
        Capsule c2 = new Capsule(p2, ST2);
        c1.startSM();
        c2.startSM();
    }
}
