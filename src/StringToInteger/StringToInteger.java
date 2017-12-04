package StringToInteger;

/**
 * Created by Administrator on 2017-05-10.
 */
/*String类型与Number类型互相转化 */
public class StringToInteger {
    public static void main(String[] args){
        //将String转为int
        String s="1000";
        int id=Integer.valueOf(s).intValue();
        System.out.println(id);
        //将int转为String
        int num=1000;
        String s1=String.valueOf(num);
        System.out.println(s1);
    }
}
