import java.util.Scanner;

public class StateMachineC1 extends StateMachine{
    private Port p;

    public StateMachineC1(Port p){
        this.p=p;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("C1: Please input message to send");
            String line = scanner.nextLine();
            System.out.println("Sending message");
            p.setMessage(line);
            p.sendMessage();
            System.out.println("Message sent. Waiting 5 seconds");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
