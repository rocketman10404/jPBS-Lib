package acs.jpbs.core;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

import acs.jpbs.attrib.PbsResource;
import acs.jpbs.enums.PbsJobState;

public class PbsJob implements Serializable {
	private static final long serialVersionUID = -8595724426948951339L;
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
	protected String queueKey;
	
	public PbsJob(int _id, String _q) {
		this.id = _id;
		this.queueKey = _q;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((ctime == null) ? 0 : ctime.hashCode());
		result = prime * result
				+ ((errorPath == null) ? 0 : errorPath.hashCode());
		result = prime * result + id;
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result
				+ ((jobOwner == null) ? 0 : jobOwner.hashCode());
		result = prime * result
				+ ((outputPath == null) ? 0 : outputPath.hashCode());
		result = prime * result + priority;
		result = prime * result + ((qtime == null) ? 0 : qtime.hashCode());
		result = prime * result + ((queueKey == null) ? 0 : queueKey.hashCode());
		result = prime * result
				+ ((resourceList == null) ? 0 : resourceList.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		PbsJob other = (PbsJob) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (ctime == null) {
			if (other.ctime != null)
				return false;
		} else if (!ctime.equals(other.ctime))
			return false;
		if (errorPath == null) {
			if (other.errorPath != null)
				return false;
		} else if (!errorPath.equals(other.errorPath))
			return false;
		if (id != other.id)
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (jobOwner == null) {
			if (other.jobOwner != null)
				return false;
		} else if (!jobOwner.equals(other.jobOwner))
			return false;
		if (outputPath == null) {
			if (other.outputPath != null)
				return false;
		} else if (!outputPath.equals(other.outputPath))
			return false;
		if (priority != other.priority)
			return false;
		if (qtime == null) {
			if (other.qtime != null)
				return false;
		} else if (!qtime.equals(other.qtime))
			return false;
		if (queueKey == null) {
			if (other.queueKey != null)
				return false;
		} else if (!queueKey.equals(other.queueKey))
			return false;
		if (resourceList == null) {
			if (other.resourceList != null)
				return false;
		} else if (!resourceList.equals(other.resourceList))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
}
