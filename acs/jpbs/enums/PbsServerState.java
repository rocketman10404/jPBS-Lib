package acs.jpbs.enums;

public enum PbsServerState {
	HOT_START(1),
	IDLE(2),
	ACTIVE(3),
	SCHEDULING(4),
	TERMINATING(5),
	TERMINATING_DELAYED(6);
	
	int id;
	private PbsServerState(int _id) {
		this.id = _id;
	}
	
	public boolean acceptingJobs() {
		return this.id == 2 || this.id == 3 || this.id == 4;
	}
	
	public static PbsServerState parseState(String raw) {
		if(raw == "Hot_Start") return PbsServerState.HOT_START;
		else if(raw == "Idle") return PbsServerState.IDLE;
		else if(raw == "Active") return PbsServerState.ACTIVE;
		else if(raw == "Scheduling") return PbsServerState.SCHEDULING;
		else if(raw == "Terminating") return PbsServerState.TERMINATING;
		else return PbsServerState.TERMINATING_DELAYED;
	}
}
