package pt.uminho.sysbio;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import pt.uminho.sysbio.viewer.LabelGraphViewer;
import pt.uminho.sysbio.viewer.SimpleGraphViewer;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Graph<String, String> g = new DirectedSparseGraph<String, String> ();
        for (int i = 0; i < 10; i++) {
            g.addVertex("v" + i);
        }

        for (int i = 0; i < 50; i++) {
            String v1 = "v" + (int)(Math.random() * 10);
            String v2 = "v" + (int)(Math.random() * 10);
            g.addEdge("e" + i, v1, v2);
        }

        DijkstraShortestPath<String, String> sp = new DijkstraShortestPath<String, String>(g);

        System.out.println( g.toString() );
        System.out.println( sp.getPath("v9", "v7"));
        LabelGraphViewer.view(g);

    }
}
