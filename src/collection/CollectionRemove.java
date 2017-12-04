package collection;
import java.util.*;
/**
 * @author hcc
 * @date 2017-11-24
 */
public class CollectionRemove {
    public static void main(String[] args){
        Collection<Object> c=new ArrayList<>();
        Integer i1=10;
        c.add(i1);
        Integer i2=10;
        c.remove(i2);
        System.out.println(c.size());
        CollectionTest.Manager manager=new CollectionTest.Manager(100,"JACK");
        c.add(manager);
        CollectionTest.Manager manager1=new CollectionTest.Manager(100,"JACK");
        c.remove(manager1);
        System.out.println(c.size());

        Collection<Object> collection=new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Iterator<Object> iterator=collection.iterator();
        //通过迭代器自身的remove删除
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        System.out.println(collection.size());

        List<Object> list=new ArrayList<>();
        list.add(100);
        list.add(99);
        list.add(23);
        list.add(250);
        list.add(250);
        for (Object aList : list) {
            System.out.println(aList);
        }
    }
}
