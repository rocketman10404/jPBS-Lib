package acs.jpbs.core;

import java.net.URI;
import java.util.Date;

import acs.jbps.attrib.PbsResource;
import acs.jbps.enums.PbsJobState;

public class PbsJob {
	protected int id;
	protected String jobName;
	protected String jobOwner;
	protected PbsJobState state;
	protected URI errorPath;
	protected URI outputPath;
	protected Date ctime;
	protected int priority;
	protected Date qtime;
	protected PbsResource resourceList;
	protected String comment;
	
	protected PbsQueue queue;
	protected PbsServer server;
	
	public PbsJob() { }
	
}
