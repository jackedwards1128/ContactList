public class Hooper extends Person {
    private int OVR;

    public Hooper(String firstName, String lastName, String phoneNumber, int OVR) {
        super(firstName, lastName, phoneNumber);
        this.OVR = OVR;
    }

    public int getOVR() {
        return OVR;
    }

    @Override
    public String toString() {
        return super.toString() + " - OVR: " + OVR;
    }
}
