package collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author hcc
 * @date 2017-11-23
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<java.io.Serializable> c = new LinkedList<java.io.Serializable>();
        Collection<java.io.Serializable> c1 = new ArrayList<>();
        Collection<Object> c2 = new ArrayList<>();
        c.add(100);//自动装箱
        c.add(3.14);//自动装箱
        c.add(false);//自动装箱

        c1.add(100);//自动装箱
        c1.add(3.14);//自动装箱
        c1.add(false);//自动装箱

        Integer i1 = 10;
        c2.add(i1);//自动装箱
        c2.add(4);//自动装箱
        c2.add(6);//自动装箱

        //迭代，遍历
        //获取迭代器对象
        Iterator<java.io.Serializable> it = c.iterator();//面向接口编程it是一个引用，保存内存地址，指向堆中的迭代器对象
        System.out.println(it);//java.util.LinkedList$ListItr@5a07e868  LinkedList所依赖的iterator

        Iterator<java.io.Serializable> it1 = c1.iterator();
        System.out.println(it1);//java.util.ArrayList$Itr@782830e   ArrayList所依赖的
        //如果hasNext为真，则执行next
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element);
        }
        //boolean b=it.hasNext();  判断是否有更多的元素，如果有返回true, 如果仍有元素可以迭代，则返回 true。
        //Object o=it.next();将迭代器向下移动一位，并且取出指向的元素
        ////原则：调用it.next()方法之前必须调用it.hasNext();

        for (Serializable element : c) {
            System.out.println(element);
        }

        // boolean	contains(Object o) 如果此 collection 包含指定的元素，则返回 true。判断集合中是否包含某个元素
        //boolean remove(Object o)删除集合中某个元素
        System.out.println(c2.contains(i1));
        Integer i2 = 10;
        //contains方法底层调用的是equals方法，如果equals返回true,就是包含
        //remove和contains方法都需要集合中的元素重写equals方法
        //因为Object 中的equals方法比较内容地址，在现实的业务逻辑当中不能比较内存地址，该比较内容
        System.out.println(c2.contains(i2));
/*jdk 1.8
        public boolean contains(Object o) {
            Iterator<E> it = iterator();
            if (o==null) {
                while (it.hasNext())
                    if (it.next()==null)
                        return true;
            } else {
                while (it.hasNext())
                    if (o.equals(it.next()))
                        return true;
            }
            return false;
        }
        */

        Manager manager = new Manager(100, "JACK");
        c2.add(manager);
        System.out.println(c2.contains(manager));

        Manager manager1 = new Manager(100, "JACK");
        System.out.println(c2.contains(manager1));
    }

    static class Manager {
        int no;
        String name;

        /**
         * @param no
         * @param name
         */
        Manager(int no, String name) {
            this.no = no;
            this.name = name;
        }
        //重写equals方法
        //需求规定，如果编号和姓名都相同则表示同一个Manager
//        @Override    <jdk1.8
//        public boolean equals(Object o){
//            if (this==o){return true;}
//            if (o instanceof Manager){
//                Manager m=(Manager)o;
//                if (m.no==this.no&&m.name.equals(this.name)){
//                    return true;
//                }
//            }
//            return false;
//        }
//jdk1.8
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Manager manager = (Manager) o;

            return no == manager.no && (name != null ? name.equals(manager.name) : manager.name == null);
        }

        @Override
        public int hashCode() {
            int result = no;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

}
