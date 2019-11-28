package Nov28;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Raphael Yun on 11/28/2019
 */

public class HashSetEx5 {
    public static void main(String[] args) {
        Set setA = new HashSet();
        Set setB = new HashSet();
        Set setHab = new HashSet();
        Set setKyo = new HashSet();
        Set setCha = new HashSet();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");
        System.out.println("A = " + setA);

        setB.add("4");
        setB.add("5");
        setB.add("7");
        setB.add("8");
        setB.add("6");
        System.out.println("B = " + setB);

//        setHab.addAll(setA ,setB);
//        boolean c = setKyo.retainAll(setA, setB);
//        boolean b = setCha.removeAll(setA, setB);

        Iterator it = setB.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(setA.contains(tmp)) {
                setKyo.add(tmp);
            }
        }

        it = setA.iterator();
        while(it.hasNext()) {
            Object tmp = it.next();
            if(!setB.contains(tmp)) {
                setCha.add(tmp);
            }
        }

        it = setA.iterator();
        while(it.hasNext()) {
            setHab.add(it.next());
        }
        it = setB.iterator();
        while(it.hasNext()) {
            setHab.add(it.next());
        }

        System.out.println("A ∩ b = " + setKyo);
        System.out.println("A U b = " + setHab);
        System.out.println("A - b = " + setCha);
    }
}
