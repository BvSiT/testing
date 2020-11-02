package nl.novi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    public List<Competitor> competitorList=new ArrayList<>();

    public void addCompetitor(Competitor competitor){
        competitorList.add(competitor);
    }

    public void addScoresToResults(List<Result<Member>> resultList, Comparator<Member> comparator){

    }
}
