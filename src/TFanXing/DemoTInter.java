package TFanXing;

/**
 * Created by Administrator on 2017-05-18.
 */
public class DemoTInter {
    public static void main(String arsg[]) {
        Info<String> obj = new InfoImp<String>("www.weixueyuan.net");
        System.out.println("Length Of String: " + obj.getVar().length());
    }
}
//定义泛型接口
interface Info<T> {
    public T getVar();
}
//实现接口
class InfoImp<T> implements Info<T> {
    private T var;
    // 定义泛型构造方法
    public InfoImp(T var) {
        this.setVar(var);
    }
    public void setVar(T var) {
        this.var = var;
    }
    public T getVar() {
        return this.var;
    }
}