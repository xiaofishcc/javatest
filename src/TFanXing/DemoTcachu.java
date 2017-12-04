package TFanXing;

/**
 * Created by Administrator on 2017-05-18.
 */
public class DemoTcachu {
    public static void main(String[] args){
        Point2 p = new Point2();  // 类型擦除
        p.setX(10);
        p.setY(20.8);
        int x = (Integer)p.getX();  // 向下转型
        double y = (Double)p.getY();
        System.out.println("This point is：" + x + ", " + y);
    }
}
class Point2<T1, T2>{
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
}
