package Node;

/**
 * Created by Administrator on 2017-05-23.
 */
public class TestShortestPath {//hapjin test
    public static void main(String[] args) {
        String graphFilePath;
        if(args.length == 0)
            graphFilePath = "E:\\works\\tupian\\t.txt";
        else
            graphFilePath = args[0];

        String graphContent = FileUtil.read(graphFilePath, null);
        NonDirectedGraph graph = new NonDirectedGraph(graphContent);
        graph.unweightedShortestPath();
        graph.showDistance();
    }
}
