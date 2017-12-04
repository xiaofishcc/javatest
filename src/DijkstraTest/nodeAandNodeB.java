package DijkstraTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-05-24.
 * 用Java实现棵普通的叉树，给定 叉树的两个节点 nodeA、nodeB，找到nodeA和nodeB的最短路径，并输出
 */
public class nodeAandNodeB {
    public static List<Node> minPath(Node root, Node a, Node b) {//3个节点，最短距离
        List<Node> result = new ArrayList<Node>();//node 类型的list数组
        if (root == null || a == null || b == null) {//判断根节点为空，
            return result;
        }

        List<Node> aPath = path(root, a);//根节点和a节点的距离
        List<Node> bPath = path(root, b);//根节点和b节点的距离
        int lastSameNodeIndex = getLastSameNodeIndex(aPath, bPath);//找到两个距离他们之间最后一个相同节点的下标
        if (lastSameNodeIndex == -1) {
            return result;//如果下标为初始值，证明两个距离为空--》证明两个节点为叶子节点没有子节点
        }
        for (int i = aPath.size() - 1; i >= lastSameNodeIndex; i--) {//lastSameNodeIndex不为-1，即不是叶子节点
            result.add(aPath.get(i));//将a 的值加到result中
        }
        for (int i = lastSameNodeIndex + 1; i < bPath.size(); i++) {
            result.add(bPath.get(i));//将b 的值加到result中
        }
        return result;//得到result
    }

    private static int getLastSameNodeIndex(List<Node> aPath, List<Node> bPath) {//参数为nodeA和nodeB距离根节点的距离 数组值中，最后一个相同节点的下标
        int i = -1;//初始化i为-1
        while (i + 1 < aPath.size() && i + 1 < bPath.size()
                && aPath.get(i + 1) == bPath.get(i + 1)) {
            i++;
        }
        return i;
    }

    private static List<Node> path(Node root, Node n) {//求2个节点路径的方法，参数Node类型的 节点nodeA和nodeB
        List<Node> result = new ArrayList<Node>();//node 类型的list数组，用于存放节点
        result.add(root);//先将一个节点存入
        if (root == n) {
            return result;//如果nodeA和nodeB相等则返回result
        }
        if (root.left != null) {//nodeA和nodeB不相等-->判断当前节点的左边是否为空
            List<Node> left = path(root.left, n);//回调path
            if (left.size() > 0) {
                result.addAll(left);
                return result;
            }
        }
        if (root.right != null) {//nodeA和nodeB不相等-->判断当前节点的右边是否为空
            List<Node> right = path(root.right, n);
            if (right.size() > 0) {
                result.addAll(right);
                return result;
            }
        }
        result.clear();//如果当前节点左右节点为空，则result清空
        return result;//返回
    }
}

