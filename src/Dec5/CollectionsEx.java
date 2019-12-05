package Dec5;

import java.util.ArrayList;
import static java.util.Collections.*;

import java.util.Enumeration;
import java.util.List;

/**
 * Created by Raphael Yun on 12/5/2019
 */

public class CollectionsEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);

        addAll(list, 1,2,3,4,5);
        System.out.println(list);

        rotate(list,2);
        System.out.println(list);

        swap(list, 0,2);
        System.out.println(list);

        shuffle(list);
        System.out.println(list);

        sort(list);
        System.out.println(list);

        sort(list, reverseOrder());
        System.out.println(list);

        int idx= binarySearch(list,3);
        System.out.println("index of 3 = " + idx);

        System.out.println("max="+max(list));
        System.out.println("min="+min(list));
        System.out.println("min="+max(list, reverseOrder()));

        List newList2 = nCopies(list.size(), list);
        System.out.println("newList2="+newList2);

        fill(list, 9);
        System.out.println("list="+list);

        List newList = nCopies(list.size(), 2);
        System.out.println("newList="+newList);

        System.out.println(disjoint(list, newList));

        copy(list, newList);
        System.out.println("newList="+newList);
        System.out.println("list="+list);

        replaceAll(list, 2, 1);
        System.out.println("list="+list);

        Enumeration e = enumeration(list);
        ArrayList list2=list(e);
        System.out.println("list2="+list2);

    }
}
