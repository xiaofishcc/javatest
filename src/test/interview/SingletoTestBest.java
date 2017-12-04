package test.interview;

/**
 * Created by Administrator on 2017-05-09.
 */
public class SingletoTestBest {
    // 定义一个私有构造方法
    private SingletoTestBest(){}
    //定义一个静态私有变量(不初始化，不使用final关键字，
    // 使用volatile保证了多线程访问时instance变量的可见性，
    // 避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static volatile SingletoTestBest instance;
    //定义一个共有的静态方法，返回该类型实例
    public static SingletoTestBest getInstance(){
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance==null){
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (SingletoTestBest.class){
                if (instance==null){
                    //未初始化，则初始instance变量
                    instance=new SingletoTestBest();
                }
            }
        }
        return instance;
    }
}
/*方法四为单例模式的最佳实现。内存占用地，效率高，线程安全，多线程操作原子性。
（事实上，可以通过Java反射机制来实例化private类型的构造方法，
此时基本上会使所有的Java单例实现失效。本帖不讨论反射情况下问题，默认无反射，也是常见的面试已经应用场景）*/
