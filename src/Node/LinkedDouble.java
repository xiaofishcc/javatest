package Node;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hcc
 * @date 2017-11-23
 */
public class LinkedDouble {
    Entry entry;
    private static class Entry {
        //数据
        Object item;
        //下一节点地址
        Entry next;
        //上一节点地址
        Entry prev;

        Entry(Entry prev, Object element, Entry next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
        public static void main(String[] args){
            //创建集合
            Collection collection=new ArrayList();//多态
            //添加元素
            collection.add(1);
            collection.add(new Integer(100));
            Object o=new Object();
            collection.add(o);//collection集合只能单个存储元素，并且只能存储引用类型

            Customer customer=new Customer("jack",20);
            collection.add(customer);



            Object[] objects=collection.toArray();
            for (int i=0;i<objects.length;i++){
                System.out.println(objects[i]);
            }
            //获取元素的个数
            collection.size();
            System.out.println();
            System.out.println(collection.size());
            System.out.println(collection.isEmpty());
            collection.clear();
            System.out.println(collection.size());
            System.out.println(collection.isEmpty());
        }
    }
    static class Customer{
        String name;
        int age;
        Customer(String name,int age){
            this.name=name;
            this.age=age;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
