package Node;

/**
 * @author hcc
 * @date 2017-11-23
 */
/**单向链表的java模拟*/
public class Linked {
    /**节点*/
    Entry entry;

    /**Constructor*/
    public Linked(){
        entry=new Entry(null,null);
    }
    static class Entry{
        /**Field*/
        Object data;
        Entry next;
        Entry(Object data,Entry next){
            this.data=data;
            this.next=next;
        }
    }
}
