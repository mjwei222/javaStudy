package com.qunar.study.xiaosxian.storm.trident;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.trident.spout.ITridentSpout;
import org.apache.storm.tuple.Fields;

public class DiagnosisEventSpout implements ITridentSpout<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SpoutOutputCollector collector;
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	//Emitter<Long> emitter = new DiagnosisiEventEmitter();
	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatchCoordinator<Long> getCoordinator(String arg0, Map arg1, TopologyContext arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emitter<Long> getEmitter(String arg0, Map arg1, TopologyContext arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
