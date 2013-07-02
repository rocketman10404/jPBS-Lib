package acs.jpbs.enums;

import java.io.Serializable;

public enum PbsQueueType implements Serializable {
	EXECUTION(1),
	ROUTING(2);
	
	int id;
	private PbsQueueType(int _id) {
		this.id = _id;
	}
	
	public static PbsQueueType parseQueueType(String raw) {
		if(raw.equals("Routing")) return PbsQueueType.ROUTING;
		else return PbsQueueType.EXECUTION;
	}
}
