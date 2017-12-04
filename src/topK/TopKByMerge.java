package topK;

/**
 * Created by Administrator on 2017-05-17.
 */

import java.util.List;

/**
 * 已知几个递减有序的m个数组，求这几个数据前k大的数
 *适合采用Merge的方法,时间复杂度(O(k*m);
 *
 合并法

 这种方法适用于几个数组有序的情况，来求Top k。时间复杂度为O(k*m)。(m:为数组的个数）.具体实现如下：
 */
public class TopKByMerge {
    public  int[] getTopK(List<List<Integer>>input,int k){
        int index[]=new int[input.size()];//保存每个数组下标扫描的位置;
        int result[]=new int[k];
        for (int i=0;i<k;i++){
            int max=Integer.MIN_VALUE;
            int maxIndex=0;
            for(int j=0;j<input.size();j++){
                if (index[j]<input.get(j).size()){
                    if (max<input.get(j).get(index[j])){
                        max=input.get(j).get(index[j]);
                        maxIndex=j;
                    }
                }
            }
            if (max==Integer.MIN_VALUE){
                return result;
            }
            result[i]=max;
            index[maxIndex]+=1;
        }
        return result;
    }
}
