package acs.jpbs.core;

import java.net.URI;
import java.util.Date;

import acs.jpbs.attrib.PbsResource;
import acs.jpbs.enums.PbsJobState;

public class PbsJob {
	protected int id;
	protected String jobName = null;
	protected String jobOwner = null;
	protected PbsJobState state = null;
	protected URI errorPath = null;
	protected URI outputPath = null;
	protected Date ctime = null;
	protected int priority = 0;
	protected Date qtime = null;
	protected PbsResource resourceList = new PbsResource();
	protected String comment = "";
	
	protected PbsQueue queue;
	
	public PbsJob(int _id, PbsQueue _q) {
		this.id = _id;
		this.queue = _q;
	}
	
	public int getId() {
		return this.id;
	}
}
