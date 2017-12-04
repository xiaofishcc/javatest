package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hcc
 * @date 2017-12-01
 */
public class ListTest {
    public static void main(String []args){
        List l=new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("4");
        l.add("3");

        Iterator it=l.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add(1,555);
        System.out.println(list.get(0));
        System.out.println("===============================");
        for (int i=0;i<list.size();i++){
            Object element=list.get(i);
            System.out.println(element);
        }
        System.out.println("===============================");
        Iterator it1=list.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}
