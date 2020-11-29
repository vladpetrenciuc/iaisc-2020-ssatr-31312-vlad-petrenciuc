public class Port {
    private String message;
    private boolean received = false;
    private Port destination_port;

    public void sendMessage() {
        if (!this.message.equals("")) {
            destination_port.receiveMessage(this.message);
            this.message = "";
        }
    }

    public void receiveMessage(String message) {
        this.message = message;
        this.received = true;
    }

    public String getMessage() {
        if (this.received) {
            this.received = false;
            return this.message;
        } else return "";
    }

    public void setMessage(String message) {
        this.message=message;
    }

    public void setDestination_port(Port destination_port){
        this.destination_port=destination_port;
    }
}
