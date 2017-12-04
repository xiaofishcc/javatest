package ArrayMinToMax;

/**
 * Created by Administrator on 2017-05-10.
 */
public class TestBaiduKnow {

    public static void main(String[] args) {
        /*方法一*/
        int[] a = { 13, 8, 7, 10, 6, 5, 4, 3, 2, 1 };

        System.out.println("原始数组：");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }

        System.out.println("\n" + "排序后数组：");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
/*方法二*/
        int[] arr={11,22,33,66,55,44};
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(a);
        System.out.println("\n"+"倒序输出");
        for (int k=arr.length-1;k>=0;k--){
            System.out.println(arr[k]+" ");
        }
        System.out.println("\n"+"倒序输出");
        for (int k=a.length-1;k>=0;k--){
            System.out.println(a[k]+" ");
        }

    }

}