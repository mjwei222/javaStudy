package com.qunar.study.xiaosxian.storm.wordcount;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
public class SentenceSpout extends BaseRichSpout{
	private ConcurrentHashMap<UUID,Values> pending;
	private SpoutOutputCollector collector;
	private String[] sentences = {
			"my dog has fleas",
			"i like cold beverage",
			"the dog ate my homework",
			"don't have a cow man",
			"i don't think i like fleas"
	};
	private int index = 0;
	@Override
	public void nextTuple() {
		// TODO Auto-generated method stub
		Values values = new Values(sentences[index]);
		UUID msgid = UUID.randomUUID();
		this.pending.put(msgid, values);
		this.collector.emit(values);
		index ++;
		if (index >= sentences.length) {
			index = 0;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void open(Map config, TopologyContext context, SpoutOutputCollector collector) {
		// TODO Auto-generated method stub
		this.collector = collector;
		this.pending = new ConcurrentHashMap<UUID,Values>();
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		declarer.declare(new Fields("sentence"));
	}
	public void ack(Object msgid) {
		this.pending.remove(msgid);
	}
	public void fail(Object msgid) {
		this.collector.emit(this.pending.get(msgid),msgid);
	}
}
