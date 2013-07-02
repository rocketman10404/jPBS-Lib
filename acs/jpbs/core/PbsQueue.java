package acs.jpbs.core;

import java.io.Serializable;
import java.util.TreeMap;

import acs.jpbs.attrib.PbsResource;
import acs.jpbs.attrib.PbsStateCount;
import acs.jpbs.enums.PbsQueueType;

public class PbsQueue implements Serializable {
	private static final long serialVersionUID = -5614180437640698241L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defaultChunk == null) ? 0 : defaultChunk.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
		result = prime
				* result
				+ ((resourcesAssigned == null) ? 0 : resourcesAssigned
						.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result + ((started == null) ? 0 : started.hashCode());
		result = prime * result
				+ ((stateCount == null) ? 0 : stateCount.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PbsQueue other = (PbsQueue) obj;
		if (defaultChunk == null) {
			if (other.defaultChunk != null)
				return false;
		} else if (!defaultChunk.equals(other.defaultChunk))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		if (resourcesAssigned == null) {
			if (other.resourcesAssigned != null)
				return false;
		} else if (!resourcesAssigned.equals(other.resourcesAssigned))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (started == null) {
			if (other.started != null)
				return false;
		} else if (!started.equals(other.started))
			return false;
		if (stateCount == null) {
			if (other.stateCount != null)
				return false;
		} else if (!stateCount.equals(other.stateCount))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
