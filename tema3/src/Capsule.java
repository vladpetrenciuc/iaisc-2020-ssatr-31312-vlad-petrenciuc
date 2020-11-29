public class Capsule {
    public Port port1 = new Port();
    private StateMachine ST;

    public Capsule(Port port1, StateMachine ST) {
        this.port1 = port1;
        this.ST=ST;
    }

    public void startSM(){
        this.ST.start();
    }
}
