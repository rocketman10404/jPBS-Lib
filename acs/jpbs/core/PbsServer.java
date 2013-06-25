package acs.jpbs.core;

import java.util.HashMap;

import acs.jbps.attrib.PbsResource;
import acs.jbps.attrib.PbsServerLicenses;
import acs.jbps.attrib.PbsStateCount;
import acs.jbps.enums.PbsServerState;

public class PbsServer {
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
}
