package TFanXing;

/**
 * Created by Administrator on 2017-05-18.
 * 上面的代码会报错，doubleValue() 是 Number 类的方法，不是所有的类都有该方法，
 * 所以我们要限制类型参数 T，让它只能接受 Number 及其子类（Integer、Double、Character 等）。
 * <T extends Number> 表示 T 只接受 Number 及其子类，传入其他类型的数据会报错。
 * 这里的限定使用关键字 extends，后面可以是类也可以是接口。
 * 但这里的 extends 已经不是继承的含义了，应该理解为 T 是继承自 Number 类的类型，或者 T 是实现了 XX 接口的类型。
 */
public class DemoxianzhiT {
    public <T extends Number> T getMax(T array[]){
        T max = null;
        for(T element : array){
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
}
