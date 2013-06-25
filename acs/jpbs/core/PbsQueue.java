package acs.jpbs.core;

import java.util.TreeMap;

import acs.jbps.attrib.PbsResource;
import acs.jbps.attrib.PbsStateCount;
import acs.jbps.enums.PbsQueueType;

public class PbsQueue {
	protected String name;
	protected PbsQueueType type = null;
	protected PbsStateCount stateCount = new PbsStateCount();
	protected PbsResource resourcesAssigned = new PbsResource();
	protected PbsResource defaultChunk = new PbsResource();
	protected Boolean enabled = null;
	protected Boolean started = null;
	protected int priority = 0;
	protected PbsServer server;
	
	public TreeMap<Integer, PbsJob> jobs = new TreeMap<Integer, PbsJob>();
	
	public PbsQueue(String _name, PbsServer myServer) {
		this.name = _name;
		this.server = myServer;
	}
	
	public void debugPrint() {
		System.out.println("PBS QUEUE OBJECT -- OUTPUT");
		System.out.println(".name : '"+this.name+"'");
		System.out.println(".type : '"+this.type.name()+"'");
		System.out.println(".stateCount : ");
		this.stateCount.debugOutput();
		System.out.println(".resourcesAssigned : ");
		this.resourcesAssigned.debugOutput();
		System.out.println(".defaultChunk : ");
		this.defaultChunk.debugOutput();
		System.out.println(".enabled : '"+this.enabled+"'");
		System.out.println(".started : '"+this.started+"'");
		System.out.println(".priority : '"+this.priority+"'");
		System.out.println(".server : '"+this.server.host+"'");
		System.out.println("END SERVER OBJECT OUTPUT");
	}
	
	public String getName() {
		return this.name;
	}
}
