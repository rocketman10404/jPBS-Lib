package acs.jpbs.enums;

public enum PbsQueueType {
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
