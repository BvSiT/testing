package nl.novi;

public class Competitor extends Pigeon {
    public Member currentOwner;
    public int memberRegistrationId;
    public double score;

    public Competitor(Pigeon pigeon,Member owner) {
        //Create a 'deep'  copy of member to preserve data member in Competitor
        currentOwner = new Member(owner.name);
        currentOwner.id = owner.id; //Use same id!!
        memberRegistrationId = owner.id; //added for testing
        ringId = pigeon.ringId;
    }

    public <T> T get(){
        T t = (T) currentOwner;
        return t;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "currentOwner=" + currentOwner +
                ", memberRegistrationId=" + memberRegistrationId +
                ", score=" + score +
                ", ringId='" + ringId + '\'' +
                '}';
    }
}
