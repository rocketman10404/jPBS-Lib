package acs.jpbs.core;

import java.net.URI;
import java.util.Date;

import acs.jbps.attrib.PbsResource;
import acs.jbps.enums.PbsJobState;

public class PbsJob {
	private int id;
	private String jobName;
	private String jobOwner;
	private PbsJobState state;
	private URI errorPath;
	private URI outputPath;
	private Date ctime;
	private int priority;
	private Date qtime;
	private PbsResource resourceList;
	private String comment;
	
	private PbsQueue queue;
	private PbsServer server;
	
	public PbsJob() { }
}
