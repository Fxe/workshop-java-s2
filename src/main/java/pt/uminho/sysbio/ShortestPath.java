package pt.uminho.sysbio;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections15.Transformer;

import pt.uminho.sysbio.transformer.MappedWeightTransformer;
import pt.uminho.sysbio.viewer.LabelGraphViewer;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

/**
 * Created by Filipe on 21/03/2015.
 */
public class ShortestPath {
    public static void main(String...args) {
        Graph<String, String> g = new DirectedSparseGraph<String, String>();
        g.addVertex("v1");
        g.addVertex("v2");
        g.addVertex("v3");
        g.addVertex("v4");

        g.addEdge("e1", "v1", "v2");
        g.addEdge("e2", "v1", "v4");
        g.addEdge("e3", "v2", "v3");
        g.addEdge("e4", "v3", "v4");
        
        Map<String, Double> weights = new HashMap<> ();
        weights.put("e1", 1.0);
        weights.put("e2", 9.0);
        weights.put("e3", 1.0);
        weights.put("e4", 1.0);
        
        DijkstraShortestPath<String, String> sp = new DijkstraShortestPath<> (
        		g, new MappedWeightTransformer<>(weights));
        
        System.out.println( g.toString() );
        System.out.println( sp.getPath("v1", "v4"));
        System.out.println( sp.getDistance("v1", "v4"));
        LabelGraphViewer.view(g);
    }
}
