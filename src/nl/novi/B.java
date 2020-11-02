package nl.novi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B {
    public List<A> aList;

    public B() {
        aList = new ArrayList<>();
        aList.add(new A(4.333));
        aList.add(new A(3.333));
    }

    public void printSorted(){
        List<A> list = new ArrayList<>();
        for (A a: aList){
            list.add(a);
        }

        list.sort(Comparator.comparing(A::getD));

        for (A a : list){
            System.out.println(a.d);
        }
    }
}
