package acs.jbps.enums;

public enum PbsQueueType {
	EXECUTION(1),
	ROUTING(2);
	
	int id;
	private PbsQueueType(int _id) {
		this.id = _id;
	}
}
