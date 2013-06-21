package acs.jpbs.core;

import java.util.ArrayList;
import java.util.List;

import acs.jbps.attrib.PbsResource;
import acs.jbps.attrib.PbsServerLicenses;
import acs.jbps.attrib.PbsStateCount;
import acs.jbps.enums.PbsServerState;

public class PbsServer implements IPbsObject {
	/*
	 * read-only attributes
	 */
	private PbsServerState state;
	private String host;
	private boolean scheduling;
	private PbsStateCount stateCount;
	private PbsQueue defaultQueue;
	private PbsResource resourcesAssigned;
	private PbsResource defaultChunk;
	private int schedulerIteration;
	private int fLicenses;
	private boolean resvEnable;
	private PbsServerLicenses licenseCount;
	private String version;
	
	public List<PbsQueue> queues = new ArrayList();
	
	public PbsServer() { }
	
	public void updateSelf() { }
	
	public void updateChildren() { }
}
