package pt.uminho.sysbio;

import pt.uminho.sysbio.viewer.LabelGraphViewer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

/**
 * Created by Filipe on 21/03/2015.
 */
public class SimpleGraph {
	/**
	 * Create and visualize a simple graph
	 * 
	 * v1
	 * v2
	 * v3
	 * v4
	 * v5
	 * 
	 * e1 (v1, v2)
	 * e2 (v2, v3)
	 * e3 (v3, v4)
	 * e4 (v1, v5)
	 * e5 (v5, v4)
	 * e6 (v1, v1)
	 * 
	 * @param args
	 */
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

        System.out.println( g.toString() );

        LabelGraphViewer.view(g);

    }
}
