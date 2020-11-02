package nl.novi;

public class Member {
    private static int instanceCounter=10000;
    public String name;
    public int id;

    public Member(String name)
    {
        id=uniqueId();
        this.name = name;
    }

    private int uniqueId(){
        //https://stackoverflow.com/questions/13431013/increments-by-1-and-add-it-with-every-created-object
        instanceCounter++;
        return instanceCounter;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
