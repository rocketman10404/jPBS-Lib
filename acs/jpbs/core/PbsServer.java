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
	protected PbsServerState state;
	protected String host;
	protected boolean scheduling;
	protected PbsStateCount stateCount;
	protected PbsQueue defaultQueue;
	protected PbsResource resourcesAssigned;
	protected PbsResource defaultChunk;
	protected int schedulerIteration;
	protected int fLicenses;
	protected boolean resvEnable;
	protected PbsServerLicenses licenseCount;
	protected String version;
	
	public HashMap<String, PbsQueue> queues = new HashMap<String, PbsQueue>();
	
	public PbsServer() { }
	
	public void debugPrint() {
		System.out.println("PBS SERVER OBJECT -- OUTPUT");
		System.out.println(".host : '"+this.host+"'");
		System.out.println(".scheduling : '"+this.scheduling+"'");
		System.out.println(".stateCount : ");
		this.stateCount.debugOutput();
		System.out.println(".defaultQueue : '"+this.defaultQueue.getName()+"'");
		System.out.println(".resourcesAssigned : ");
		System.out.println(".defaultChunk : ");
		System.out.println(".schedulerIteration : '"+this.schedulerIteration+"'");
		System.out.println(".fLicenses : '"+this.fLicenses+"'");
		System.out.println(".resvEnable : '"+this.resvEnable+"'");
		System.out.println(".licenseCount : ");
		this.licenseCount.debugOutput();
		System.out.println(".version : '"+this.version+"'");
		System.out.println("END SERVER OBJECT OUTPUT");
	}
}
