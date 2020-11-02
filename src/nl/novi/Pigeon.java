package nl.novi;

public class Pigeon {
    private static int instanceCounter=100;
    public String ringId;

    public Pigeon() {
        ringId=String.valueOf(uniqueId());
    }

    private int uniqueId(){
        //https://stackoverflow.com/questions/13431013/increments-by-1-and-add-it-with-every-created-object
        instanceCounter++;
        return instanceCounter;
    }

    @Override
    public String toString() {
        return "Pigeon{" +
                "ringId='" + ringId + '\'' +
                '}';
    }
}
