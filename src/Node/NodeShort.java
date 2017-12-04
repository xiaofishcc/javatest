package Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017-05-23.
 */
public class NodeShort {
    class Node{
        int value;
        List<Node>child_list;
        Node(){
            value=0;
            child_list=new LinkedList<>();
        }
    }
    private static void displayTree(Node node,int level){//递归显示树
        String preStr = "";
        for(int i=0; i<level; i++) {
            preStr += "    ";
        }
        for(int i=0; i<node.child_list.size(); i++) {
            Node t = node.child_list.get(i);
            System.out.println(preStr + "-"+t.value);
            if(! t.child_list.isEmpty()) {
                displayTree(t, level + 1);
            }
        }
    }
}
