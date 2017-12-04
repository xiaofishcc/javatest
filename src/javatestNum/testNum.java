package javatestNum;

import java.util.Scanner;
/*面试题1
* JAVA程序1,1,2,3,5,8,13,21....第30个是什么*/
/**
 * Created by Administrator on 2017-05-05.
 */
public class testNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你要查询的第几位数");
        int a =sc.nextInt();
        System.out.println("第"+a+"位数是"+sum(a));

    }

    public static int sum(int num){
        if (num==1||num==2){
            return 1;
        }else{
            return sum(num-1)+sum(num-2);
        }
    }
}
