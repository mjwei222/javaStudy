package com.qunar.study.xiaosxian.storm.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

public class ReportBolt extends BaseRichBolt{
	private HashMap<String, Long> counts = null; 
	@Override
	public void execute(Tuple tuple) {
		// TODO Auto-generated method stub
		String word = tuple.getStringByField("word");
		Long count = tuple.getLongByField("count");
		this.counts.put(word, count);
	}

	@Override
	public void prepare(Map config, TopologyContext context, OutputCollector collector) {
		// TODO Auto-generated method stub
		this.counts = new HashMap<String,Long>();
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declare) {
		// TODO Auto-generated method stub
		
	}
	public void cleanup() {
		System.out.println("=== FINAL COUNTS ===");
		List<String> keys = new ArrayList<String>();
		keys.addAll(this.counts.keySet());
		Collections.sort(keys);
		for (String key:keys) {
			System.out.println(key + " : " + this.counts.get(key));
		}
		System.out.println("-------------");
	}

}
