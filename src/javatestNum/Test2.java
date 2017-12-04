package javatestNum;

/**
 * 面试题2
 * 一个整形数组，数组里有正数也有负数。
 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和，求所有子数组的和的最大值，要求时间复杂度为O(n)。

 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，那么最大的子数组为3, 10, -4, 7, 2，因此输出为该子数组的和18
 * Created by Administrator on 2017-05-05.
 */
public class Test2 {
    public static void main(String[] args){
        int[]a={1, -2, 3, 10, -4, 7, 2, -5};
        int max=MaxSum(a);
        System.out.println(max);
    }
    public static int MaxSum(int[] a){
        int sum=0;
        int max=0;
        for (int i=0;i<a.length;i++){
            sum=sum+a[a.length-i-1];
            if (a[a.length-i-1]>=0){
                if (max<sum){
                    max=sum;
                    System.out.println(max);
                }
            }
            if (sum<0){
                sum=0;
            }
        }
        return max;
    }
}
