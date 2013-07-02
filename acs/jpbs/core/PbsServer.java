package acs.jpbs.core;

import java.io.Serializable;
import java.util.HashMap;

import acs.jpbs.attrib.PbsResource;
import acs.jpbs.attrib.PbsServerLicenses;
import acs.jpbs.attrib.PbsStateCount;
import acs.jpbs.enums.PbsServerState;

public class PbsServer implements Serializable {
	private static final long serialVersionUID = 6455928702644240133L;
	/*
	 * read-only attributes
	 */
	protected PbsServerState state = null;
	protected String host = null;
	protected Boolean scheduling = null;
	protected PbsStateCount stateCount = new PbsStateCount();
	protected String defaultQueue = null;
	protected PbsResource resourcesAssigned = new PbsResource();
	protected PbsResource defaultChunk = new PbsResource();
	protected Integer schedulerIteration = null;
	protected Integer fLicenses = null;
	protected Boolean resvEnable = null;
	protected PbsServerLicenses licenseCount = new PbsServerLicenses();
	protected String version = null;
	
	public HashMap<String, PbsQueue> queues = new HashMap<String, PbsQueue>();
	
	public PbsServer() { }
	
	public void debugPrint() {
		System.out.println("PBS SERVER OBJECT -- OUTPUT");
		System.out.println(".host : '"+this.host+"'");
		System.out.println(".scheduling : '"+this.scheduling+"'");
		System.out.println(".stateCount : ");
		this.stateCount.debugOutput();
		System.out.println(".defaultQueue : '"+this.defaultQueue+"'");
		System.out.println(".resourcesAssigned : ");
		this.resourcesAssigned.debugOutput();
		System.out.println(".defaultChunk : ");
		this.defaultChunk.debugOutput();
		System.out.println(".schedulerIteration : '"+this.schedulerIteration+"'");
		System.out.println(".fLicenses : '"+this.fLicenses+"'");
		System.out.println(".resvEnable : '"+this.resvEnable+"'");
		System.out.println(".licenseCount : ");
		this.licenseCount.debugOutput();
		System.out.println(".version : '"+this.version+"'");
		System.out.println("END SERVER OBJECT OUTPUT");
	}
	
	public String getHostName() {
		return this.host;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defaultChunk == null) ? 0 : defaultChunk.hashCode());
		result = prime * result
				+ ((defaultQueue == null) ? 0 : defaultQueue.hashCode());
		result = prime * result
				+ ((fLicenses == null) ? 0 : fLicenses.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result
				+ ((licenseCount == null) ? 0 : licenseCount.hashCode());
		result = prime * result + ((queues == null) ? 0 : queues.hashCode());
		result = prime
				* result
				+ ((resourcesAssigned == null) ? 0 : resourcesAssigned
						.hashCode());
		result = prime * result
				+ ((resvEnable == null) ? 0 : resvEnable.hashCode());
		result = prime
				* result
				+ ((schedulerIteration == null) ? 0 : schedulerIteration
						.hashCode());
		result = prime * result
				+ ((scheduling == null) ? 0 : scheduling.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((stateCount == null) ? 0 : stateCount.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		PbsServer other = (PbsServer) obj;
		if (defaultChunk == null) {
			if (other.defaultChunk != null)
				return false;
		} else if (!defaultChunk.equals(other.defaultChunk))
			return false;
		if (defaultQueue == null) {
			if (other.defaultQueue != null)
				return false;
		} else if (!defaultQueue.equals(other.defaultQueue))
			return false;
		if (fLicenses == null) {
			if (other.fLicenses != null)
				return false;
		} else if (!fLicenses.equals(other.fLicenses))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (licenseCount == null) {
			if (other.licenseCount != null)
				return false;
		} else if (!licenseCount.equals(other.licenseCount))
			return false;
		if (queues == null) {
			if (other.queues != null)
				return false;
		} else if (!queues.equals(other.queues))
			return false;
		if (resourcesAssigned == null) {
			if (other.resourcesAssigned != null)
				return false;
		} else if (!resourcesAssigned.equals(other.resourcesAssigned))
			return false;
		if (resvEnable == null) {
			if (other.resvEnable != null)
				return false;
		} else if (!resvEnable.equals(other.resvEnable))
			return false;
		if (schedulerIteration == null) {
			if (other.schedulerIteration != null)
				return false;
		} else if (!schedulerIteration.equals(other.schedulerIteration))
			return false;
		if (scheduling == null) {
			if (other.scheduling != null)
				return false;
		} else if (!scheduling.equals(other.scheduling))
			return false;
		if (state != other.state)
			return false;
		if (stateCount == null) {
			if (other.stateCount != null)
				return false;
		} else if (!stateCount.equals(other.stateCount))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
