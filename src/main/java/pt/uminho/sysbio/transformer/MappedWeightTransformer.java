package pt.uminho.sysbio.transformer;

import java.util.Map;

import org.apache.commons.collections15.Transformer;

public class MappedWeightTransformer<V> implements Transformer<V, Double> {
	
	private final Map<V, Double> weightMap;
	
	public MappedWeightTransformer(Map<V, Double> weightMap) {
		this.weightMap = weightMap;
	}
	
	@Override
	public Double transform(V v) {
		Double value = weightMap.get(v);
		if (value == null) throw new IllegalArgumentException(v + " not found in the vertex weight map");
		return value;
	}

}
