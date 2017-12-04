package test.interview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017-05-09.
 */
/*一般大家都知道ArrayList和LinkedList的大致区别：
     1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
     2.对于随机访问get和set，ArrayList绝对优于LinkedList，因为LinkedList要移动指针。
     3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
     ArrayList和LinkedList在性能上各有优缺点，都有各自所适用的地方，总的说来可以描述如下：
1．对ArrayList和LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的。对ArrayList而言，
主要是在内部数组中增加一项，指向所添加的元素，偶尔可能会导致对数组重新进行分配；
而对LinkedList而言，这个开销是统一的，分配一个内部Entry对象。
2．在ArrayList的中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；
而在LinkedList的中间插入或删除一个元素的开销是固定的。
3．LinkedList不支持高效的随机元素访问。
4．ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，
而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间
可以这样说：当操作是在一列数据的后面添加数据而不是在前面或中间,
并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能；当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了。*/
public class InterviewTest {
    static final int N = 50000;

    static long timeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis() - start;
    }
    static long readList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 1;i < N; i++) {
           list.get(i);
        }
        return System.currentTimeMillis() - start;
    }

    static List addList(List list) {
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println("ArrayList添加"+N+"条耗时："+timeList(new ArrayList()));
        System.out.println("LinkedList添加"+N+"条耗时："+timeList(new LinkedList()));
        List list1=addList(new ArrayList());
        list1.add(new Integer(1));
        list1.add(new Integer(2));
        list1.add(new Integer(3));
        list1.add(new Integer(4));
        List list2=addList(new LinkedList());
        list2.add(new Integer(1));
        list2.add(new Integer(2));
        list2.add(new Integer(3));
        list2.add(new Integer(4));
        System.out.println("ArrayList查找"+N+"条耗时："+readList(list1));
        System.out.println("LinkedList查找"+N+"条耗时："+readList(list2));
    }
}