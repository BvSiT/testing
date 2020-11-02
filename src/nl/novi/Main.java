package nl.novi;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here

        Race race = new Race();
        Member m1 = new Member("Piet");
        Member m2 = new Member("Jan");

        List<Member> memberList = new ArrayList<>();
        memberList.add(m1);
        memberList.add(m2);


        Random random=new Random();
        for (int i=0;i<8;i++){
            //Member m = memberList.get(random.nextInt(2));

            Member m = memberList.get(i % 2);
            race.addCompetitor(new Competitor(new Pigeon(),m));

        }

        double score=123.456;
        for (Competitor c : race.competitorList){
            c.score= (score+=0.678);
            System.out.println(c.toString());
        }


        List<Result<Member>> resultMembers = new ArrayList<>();

        Result.addScoresMembers(resultMembers,race.competitorList);
/*
        for (Competitor c : race.competitorList){
            //resultMembers.add(new Result<Member>(c,c.currentOwner));
            Result<Member> rm = new Result<Member>(c.currentOwner,c.score);
            rm.addScoreToList(resultMembers,new ComparatorMember());
        }
*/

        for (Result<Member> rm : resultMembers){
            System.out.println(rm.toString());
        }

        List<Result<Competitor>> resultCompetitors = new ArrayList<>();
        Result.addScoresCompetitors(resultCompetitors,race.competitorList);

/*

        for (Competitor c : race.competitorList){
            //resultMembers.add(new Result<Member>(c,c.currentOwner));
            Result<Competitor> rc = new Result<Competitor>(c);
            rc.addScoreToList(resultCompetitors,new ComparatorCompetitor());
        }
*/

        for (Result<Competitor> rc : resultCompetitors){
            System.out.println(rc.toString());
        }
    }
}
