package com.qunar.study.xiaosxian.storm.trident;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.storm.coordination.BatchOutputCollector;
import org.apache.storm.transactional.ICommitterTransactionalSpout.Emitter;
import org.apache.storm.transactional.TransactionAttempt;

public class DiagnosisiEventEmitter implements Emitter,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AtomicInteger successfullTransaction = new AtomicInteger(0);
	@Override
	public void cleanupBefore(BigInteger txid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emitBatch(TransactionAttempt tx, Object coordinatorMeta, BatchOutputCollector collector) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			List<Object> events = new ArrayList<Object>();
			double lat = new Double(-30 + (int) (Math.random() * 75));
			double lng = new Double(-120 + (int) (Math.random() * 75));
			long time = System.currentTimeMillis();
			String diag = new Integer(320 + (int) (Math.random() * 7)).toString();
			DiagnosisEvent event = new DiagnosisEvent(lat,lng,time,diag);
			events.add(event);
			collector.emit(events);
		}
	}

	@Override
	public void commit(TransactionAttempt attempt) {
		// TODO Auto-generated method stub
		
	}

}
