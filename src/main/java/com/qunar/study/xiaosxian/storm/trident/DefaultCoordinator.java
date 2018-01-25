package com.qunar.study.xiaosxian.storm.trident;

import java.io.Serializable;

import org.apache.storm.trident.spout.ITridentSpout.BatchCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DefaultCoordinator implements BatchCoordinator<Long>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(DefaultCoordinator.class);
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long initializeTransaction(long txid, Long prevMetadata, Long currMetadata) {
		// TODO Auto-generated method stub
		LOG.info("Initializing Transaction [" + txid + "]");
		return null;
	}

	@Override
	public boolean isReady(long txid) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void success(long txid) {
		// TODO Auto-generated method stub
		LOG.info("Successful Transaction [" + txid + "]");
	}
	
}
