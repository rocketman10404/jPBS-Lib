package acs.jbps.enums;

public enum PbsServerState {
	HOST_START(1),
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
}
