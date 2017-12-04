package TFanXing;


/**
 * Created by Administrator on 2017-05-18.
 */
public class DemoTFanXing {
    public static void main(String[] args) {
        Point1 p = new Point1();
        p.setX(10);  // int -> Integer -> Object
        p.setY(20);
        int x = (Integer) p.getX();  // 必须向下转型
        int y = (Integer) p.getY();
        System.out.println("This point is：" + x + ", " + y);

        p.setX(25.4);  // double -> Double -> Object
        p.setY("东京180度");
        double m = (Double) p.getX();  // 必须向下转型
        double n = (Double) p.getY();  // 运行期间抛出异常  Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Double
        System.out.println("This point is：" + m + ", " + n);
    }
}
    class Point1{
        Object x = 0;
        Object y = 0;
        public Object getX() {
            return x;
        }
        public void setX(Object x) {
            this.x = x;
        }
        public Object getY() {
            return y;
        }
        public void setY(Object y) {
            this.y = y;
        }
}
