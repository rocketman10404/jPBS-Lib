package acs.jbps.enums;

public enum PbsJobState {
	EXITING(1),
	HELD(2),
	QUEUED(3),
	RUNNING(4),
	SUSPEND(5),
	TRANSITING(6),
	USER_SUSPEND(7),
	WAITING(8);
	
	int id;
	private PbsJobState(int _id) {
		this.id = _id;
	}
	
	public PbsJobState getStateByChar(char _state) {
		switch(_state) {
		case 'E':
			return EXITING;
		case 'H':
			return HELD;
		case 'Q':
			return QUEUED;
		case 'R':
			return RUNNING;
		case 'S':
			return SUSPEND;
		case 'T':
			return TRANSITING;
		case 'U':
			return USER_SUSPEND;
		default:
			return WAITING;
		}
	}
}
