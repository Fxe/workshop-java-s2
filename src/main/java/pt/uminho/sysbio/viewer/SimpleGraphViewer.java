package pt.uminho.sysbio.viewer;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

import javax.swing.*;

/**
 * Created by Filipe on 23/03/2015.
 */
public class SimpleGraphViewer {
    public static<V,E> void view(Graph<V, E> g) {
        JFrame jf = new JFrame();
        VisualizationViewer<V, E> vv = new VisualizationViewer<V, E>(new FRLayout<V, E>(g));
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
