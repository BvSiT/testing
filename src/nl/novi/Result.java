package nl.novi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Result<T> {
    public T t;
    public double score;
    public String id;

    private static Comparator<Result> resultComparator = new Comparator<Result>() {
        @Override
        public int compare(Result o1, Result o2) {
            return o1.id.compareTo(o2.id);
        }
    };

    public Result(Competitor competitor){
        t = (T) competitor;
        score = competitor.score;
        id=competitor.ringId;
    }

    public Result(Member member,double score){
        t= (T) member;
        this.score = score;
        id=String.valueOf(member.id);
    }

    public T get(){
        return this.t;
    }

    public void addScore(double score){
        this.score+=score;
    }

    public void addScoreToList(List<Result<T>> resultList){
        for (Result<T> result : resultList) {
            if (resultComparator.compare(result,this ) == 0) {
                result.addScore(score);
                return;
            }
        }
        if (t instanceof Member) {
            Result<T> result = new Result<T>( (Member) t,score);
            resultList.add(result);
        }
        else if (t instanceof Competitor) {
            Result<T> result = new Result<T>( (Competitor) t);
            resultList.add(result);
        }
    }

    public static void addScoresCompetitors(List<Result<Competitor>> resultList, List<Competitor> competitorList){
        if (resultList==null) resultList = new ArrayList<>();
        for (Competitor c: competitorList){
            Result<Competitor> result = new Result<>( c);
            result.addScoreToList(resultList);
        }
    }

    public static void addScoresMembers(List<Result<Member>> resultList,List<Competitor> competitorList){
        if (resultList==null) resultList = new ArrayList<>();
        for (Competitor c: competitorList){
            Result<Member> result = new Result<>(c.currentOwner,c.score);
            result.addScoreToList(resultList);
        }
    }

    public void addScores(List<Competitor> competitorList,List<Result<T>> resultList){
        //if (resultList==null) resultList = new ArrayList<>();
        //TODO Is het mogelijk om een static methode te maken die een List<Result<T>> accepteert
        //TODO en die op basis van het type van T het toevoegen aan de lijst correct afhandelt?
        //TODO Maar hoe bepaal je het type van T??
        //TODO Ook accepteert een static geen List<Result<T>>
        //TODO Alles met als doel één methode addScores te hebben voor beide typen Result<Competitor> en Result<Member>
        Result<T> result = resultList.get(0); //??Dit werkt alleen als er al een element in de lijst aanwezig is.
        for (Competitor c: competitorList){
            Result<T> res = null;
            if (result.get() instanceof Member){
                res = new Result<>(c.currentOwner,c.score);
            } else if (result.get() instanceof Competitor){
                res = new Result<>(c);
            }
            res.addScoreToList(resultList);
        }
    }


    @Override
    public String toString() {
        return "Result{" +
                "t=" + t +
                ", score=" + score +
                ", id='" + id + '\'' +
                '}';
    }
}

/*

    public void addScoreToListX(List<Result<T>> resultList, Comparator<T> comparator){
        for (Result<T> result : resultList) {
            if (comparator.compare(result.get(),this.get() ) == 0) {
                result.addScore(score);
                return;
            }
        }
        if (t instanceof Member) {
            Result<T> result = new Result<T>( (Member) t,score);
            resultList.add(result);
        }
        else if (t instanceof Competitor) {
            Result<T> result = new Result<T>( (Competitor) t);
            resultList.add(result);
        }
    }

    public void addScoreToListXX(List<Result<T>> resultList){
        Comparator comparator=null;
        if (t instanceof  Member){
            comparator = Result.memberComparator;
        }
        else if (t instanceof Competitor) {
            comparator = Result.competitorComparator;
        }
        for (Result<T> result : resultList) {
            if (comparator.compare(result.get(),this.get() ) == 0) {
                result.addScore(score);
                return;
            }
        }
        if (t instanceof  Member){
            Result<T> result = new Result<T>( (Member) t,score);
            resultList.add(result);
        }
        else if (t instanceof Competitor) {
            Result<T> result = new Result<T>( (Competitor) t);
            resultList.add(result);
        }
    }*/

/*
    public static Comparator<Competitor> competitorComparator = new Comparator<Competitor>() {
        @Override
        public int compare(Competitor o1, Competitor o2) {
            return o1.ringId.compareTo(o2.ringId);
        }
    };

    public static Comparator<Member> memberComparator = new Comparator<Member>() {
        @Override
        public int compare(Member o1, Member o2) {
            return Integer.compare(o1.id, o2.id);
        }
    };
*/