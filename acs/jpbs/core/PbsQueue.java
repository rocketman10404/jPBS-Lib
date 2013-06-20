package acs.jpbs.core;

import java.util.ArrayList;
import java.util.List;

import acs.jbps.attrib.PbsResource;
import acs.jbps.attrib.PbsStateCount;
import acs.jbps.enums.PbsQueueType;

public class PbsQueue {
	private PbsQueueType type;
	private PbsStateCount stateCount;
	private PbsResource resourcesAssigned;
	private PbsResource defaultChunk;
	private boolean enabled;
	private boolean started;
	private int priority;
	private PbsServer server;
	
	public List<PbsJob> jobs = new ArrayList();
	
	public PbsQueue() { }
}
