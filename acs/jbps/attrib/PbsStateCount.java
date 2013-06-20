package acs.jbps.attrib;

public class PbsStateCount {
	private int transit;
	private int queued;
	private int held;
	private int waiting;
	private int running;
	private int exiting;
	private int begun;
	
	public int getTransit() { return this.transit; }
	
	public int getQueued() { return this.queued; }
	
	public int getHeld() { return this.held; }
	
	public int getWaiting() { return this.waiting; }
	
	public int getRunning() { return this.running; }
	
	public int getExiting() { return this.exiting; }
	
	public int getBegun() { return this.begun; }
	
	public int getTotal() {
		return this.transit + this.queued + this.held + this.waiting + this.running + this.exiting + this.begun;
	}
}
