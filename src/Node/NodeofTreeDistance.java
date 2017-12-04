package Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-05-23.
 */
public class NodeofTreeDistance {
    static class Tree {
        private List<Node> list = new ArrayList<Node>();

        /**
         * 内部类
         *
         * @author hcc
         */
        class Node {
            String data;
            String parent;
        }

        public void add(String parent, String child) {
            Node n = new Node();
            n.data = child;
            n.parent = parent;
            list.add(n);
        }

        /**
         * 获取父节点
         *
         * @param x
         * @return
         */
        public String getParent(String x) {
            String p=new String();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).data.equals(x)) {// 比较内容
                    p=list.get(i).parent.toString();
                }
            }
            return p;
        }

        /**
         * 获取孩子节点
         *
         * @param x
         * @return
         */
        public List<String> getChild(String x) {
            List<String> newList = new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).parent.equals(x)) {
                    newList.add(list.get(i).data);
                }
            }
            return newList;
        }

        /**
         * 距离
         *
         * @param x
         * @param y
         * @param t
         * @return
         */
        public int distance(Tree t, String x, String y) {
            int distance = 0;
            if (t.getChild(x).size()==0){
                t.getParent(x);
                distance=distance+1;
                for (int k=0;k<t.getChild(t.getParent(x)).size();k++){
                    if (t.getChild(t.getParent(x)).toString().contains(y)){
                        distance=distance+1;
                        break;
                    }else {
                        String city2=t.getChild(t.getParent(x)).get(k);
                        int z = distance(t, t.getChild(t.getParent(x)).get(k), y);//回调函数计算距离
                        if (z != 0) {//这里判断下，如果先前有节点已经包含了就跳出来
                            distance = z + 1;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < t.getChild(x).size(); i++) {
                if (t.getChild(x).toString().contains(y)) {
                    distance = 1;
                    break;
                } else {
                    String city = t.getChild(x).get(i);
                    int z = distance(t, t.getChild(x).get(i), y);//回调函数计算距离
                    if (z != 0) {//这里判断下，如果先前有节点已经包含了就跳出来
                        distance = z + 1;
                        break;
                    }
                }
            }
            return distance;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Tree a = new Tree();
        a.add("世界", "欧洲");
        a.add("世界", "亚洲");
        a.add("世界", "美洲");
        a.add("亚洲", "中国");
        a.add("亚洲", "日本");
        a.add("亚洲", "韩国");
        a.add("中国", "北京");
        a.add("中国", "江苏");
        a.add("中国", "上海");
        a.add("北京", "西城");
        a.add("北京", "东城");
        a.add("北京", "朝阳");
//        //求世界到安徽的节点距离
//        System.out.println("世界与安徽的距离为" + a.distance(a, "世界", "上海"));
//        //求亚洲到安徽的节点距离
//        System.out.println("亚洲与安徽的距离为" + a.distance(a, "亚洲", "上海"));
//        //求韩国到丰台的节点距离
//        System.out.println("亚洲与丰台的距离为" + a.distance(a, "亚洲", "朝阳"));
        System.out.println("亚洲与北京的距离为" + a.distance(a, "美洲", "北京"));

    }
}
