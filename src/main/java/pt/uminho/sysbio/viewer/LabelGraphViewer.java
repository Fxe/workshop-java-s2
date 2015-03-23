package pt.uminho.sysbio.viewer;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

/**
 * Created by Filipe on 23/03/2015.
 */
public class LabelGraphViewer {

    public static<V,E> void view(Graph<V, E> g) {
        JFrame jf = new JFrame();
        VisualizationViewer<V, E> vv = new VisualizationViewer<V, E>(new FRLayout<V, E>(g));
        
        //the component responsible to render the vertex label
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<V>());
        //the component responsible to render the edge label
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<E>());
        
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        DefaultModalGraphMouse<V, E> gm = new DefaultModalGraphMouse<V, E>();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(gm);
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
