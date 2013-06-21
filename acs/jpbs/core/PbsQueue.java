package acs.jpbs.core;

import java.util.TreeMap;

import acs.jbps.attrib.PbsResource;
import acs.jbps.attrib.PbsStateCount;
import acs.jbps.enums.PbsQueueType;

public class PbsQueue {
	protected String name;
	protected PbsQueueType type;
	protected PbsStateCount stateCount;
	protected PbsResource resourcesAssigned;
	protected PbsResource defaultChunk;
	protected boolean enabled;
	protected boolean started;
	protected int priority;
	protected PbsServer server;
	
	public TreeMap<Integer, PbsJob> jobs = new TreeMap<Integer, PbsJob>();
	
	public PbsQueue(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return this.name;
	}
}
