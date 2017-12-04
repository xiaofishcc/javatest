package topK;

/**
 * Created by Administrator on 2017-05-17.
 *
 采用小根堆或者大根堆

 求最大K个采用小根堆，而求最小K个采用大根堆。

 求最大K个的步奏：

 根据数据前K个建立K个节点的小根堆。
 在后面的N-K的数据的扫描中，

 如果数据大于小根堆的根节点，则根节点的值覆为该数据，并调节节点至小根堆。
 如果数据小于或等于小根堆的根节点，小根堆无变化。

 求最小K个跟这求最大K个类似。时间复杂度O(nlogK)(n:数据的长度),特别适用于大数据的求Top K。/**
 * 求前面的最大K个 解决方案：小根堆 (数据量比较大（特别是大到内存不可以容纳）时，偏向于采用堆)
 *
 *
 */
public class TopK1 {
    /**
     * 创建k个节点的小根堆
     *
     * @param a
     * @param k
     * @return
     */
    int[] createHeap(int a[],int k){
        int[] result=new int[k];
        for (int i=0;i<k;i++){
            result[i]=a[i];
        }
        for (int i=1;i<k;i++){
            int child=i;
            int parent=(i-1)/2;
            int temp=a[i];
            while (parent>=0&&child!=0&&result[parent]>temp){
                result[child]=result[parent];
                child=parent;
                parent=(parent-1)/2;
            }
            result[child]=temp;
        }
        return result;
    }
    void insert(int a[],int value){
        a[0]=value;
        int parent=0;
        while (parent<a.length){
            int lchild=2*parent+1;
            int rchild=2*parent+2;
            int minIndex=parent;
            if (lchild<a.length&&a[parent]>a[lchild]){
                minIndex=lchild;
            }
            if (rchild<a.length&&a[minIndex]>a[rchild]){
                minIndex=rchild;
            }
            if (minIndex==parent){
                break;
            }else {
                int temp=a[parent];
                a[parent]=a[minIndex];
                a[minIndex]=temp;
                parent=minIndex;
            }
        }
    }
    int[] getTopKByHeap(int input[],int k){
        int heap[]=this.createHeap(input,k);
        for (int i=k;i<input.length;i++){
            if (input[i]>heap[0]){
                this.insert(heap,input[i]);
            }
        }
        return heap;
    }
    public static void main(String[] args){
        int a[]={4,3,5,1,2,8,9,10};
        int result[]=new TopK1().getTopKByHeap(a,3);
        for (int temp:result){
            System.out.println(temp);
        }
    }
}

