package pt.uminho.sysbio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pt.uminho.sysbio.metabolic.EcoliCore;
import pt.uminho.sysbio.transformer.MappedWeightTransformer;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class MetabolicNetwork {
	/**
	 * Construct a metabolic network from ecoli core use {@link EcoliCore}
	 * to load metabolites, reactions and edges
	 * @param args
	 */
	public static void main(String[] args) {
		Graph<String, String> g = new DirectedSparseGraph<String, String>();
        for (String cpd : EcoliCore.species) {
            g.addVertex(cpd);
        }
        for (String rxn : EcoliCore.reactions) {
            g.addVertex(rxn);
        }
        
        Map<String, String[]> edgeMap = new HashMap<> ();
        int edgeCounter = 0;
        for (String[] edge : EcoliCore.edges) {
        	if (edge[0].equals("M_f6p_c") && edge[1].equals("M_f6p_c")) {
        		System.out.println(Arrays.toString(edge));
        	}
        	String e_ = "e" + edgeCounter++; 
            g.addEdge(e_, edge[0], edge[1]);
            edgeMap.put(e_, edge);
        }
        
        Set<String> cofac = new HashSet<> ( Arrays.asList(new String[]{}) ); 
        
        Map<String, Double> wMap = new HashMap<> ();
        System.out.println(g.degree("M_g3p_c"));
        		
        for (String edge : edgeMap.keySet()) {
        	String[] edgeV = edgeMap.get(edge);
        	double w = 0.0;
        	double r_w = 0.0;
        	if (edgeV[0].startsWith("M_")) {
        		w = g.degree(edgeV[0]);
        		r_w = g.degree(edgeV[1]);
        		if (cofac.contains(edgeV[0])) w = w * 1000;
        	} else if (edgeV[1].startsWith("M_")) {
        		w = g.degree(edgeV[1]);
        		r_w = g.degree(edgeV[0]);
        		if (cofac.contains(edgeV[1])) w = w * 1000;
        	}
//        	w = w*w;
        	System.out.println(String.format("%s:%.1f ## %s -> %s ## %.1f %.1f", edge, w, edgeV[0], edgeV[1], w, r_w));
        	wMap.put(edge, w);
        }
        DijkstraShortestPath<String, String> sp = new DijkstraShortestPath<> (
        		g, new MappedWeightTransformer<>(wMap));
        
        String START = "M_g6p_c";
        String END = "M_succ_c";
        for (String p : sp.getPath(START, END)) {
        	System.out.println(Arrays.toString(edgeMap.get(p)));
        }
        System.out.println( sp.getPath(START, END));
        System.out.println( sp.getDistance(START, END));
        //LabelGraphViewer.view(g);
	}
}
