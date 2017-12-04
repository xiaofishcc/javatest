package TFanXing;

/**
 * Created by Administrator on 2017-05-18.
 * 与普通类的定义相比，上面的代码在类名后面多出了 <T1, T2>，T1, T2 是自定义的标识符，
 * 也是参数，用来传递数据的类型，而不是数据的值，我们称之为类型参数。
 * 在泛型中，不但数据的值可以通过参数传递，数据的类型也可以通过参数传递。
 * T1, T2 只是数据类型的占位符，运行时会被替换为真正的数据类型。
 * 因为在使用泛型类时指明了数据类型，赋给其他类型的值会抛出异常，
 * 既不需要向下转型，也没有潜在的风险，比本文一开始介绍的自动装箱和向上转型要更加实用。
 * 类型参数只能用来表示引用类型，不能用来表示基本类型，如  int、double、char 等。
 * 但是传递基本类型不会报错，因为它们会自动装箱成对应的包装类
 */
public class DemoT {
    public static void main(String[] args){
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        //System.out.println("This point is：" + x + ", " + y);
        p1.printPoint(p1.getX(),p1.getY());

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();
       // System.out.println("This point is：" + m + ", " + n);
        p2.printPoint(p2.getX(),p2.getY());
    }
}
// 定义泛型类
class Point<T1, T2>{
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }
    // 定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y){
        T1 m = x;
        T2 n = y;
        System.out.println("This point is：" + m + ", " + n);
    }
}

