package acs.jbps.attrib;

public class PbsStateCount {
	private int transit = 0;
	private int queued = 0;
	private int held = 0;
	private int waiting = 0;
	private int running = 0;
	private int exiting = 0;
	private int begun = 0;
	
	public PbsStateCount() { }
	
	public void debugOutput() {
		System.out.println("PBS STATE OBJECT -- OUTPUT");
		System.out.println(".transit : '"+this.transit+"'");
		System.out.println(".queued : '"+this.queued+"'");
		System.out.println(".held : '"+this.held+"'");
		System.out.println(".waiting : '"+this.waiting+"'");
		System.out.println(".running : '"+this.running+"'");
		System.out.println(".exiting : '"+this.exiting+"'");
		System.out.println(".begun : '"+this.begun+"'");
		System.out.println("END STATE OBJECT OUTPUT");
	}
	
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
	
	public static PbsStateCount parseStateCount(String raw) {
		PbsStateCount psc = new PbsStateCount();
		
		String[] states = raw.split(" ");
		for(int i=0; i<states.length; i++) {
			String[] state = states[i].split(":");
			if(state.length != 2) continue;
			if(state[0].equals("Transit")) psc.transit = Integer.parseInt(state[1]);
			else if(state[0].equals("Queued")) psc.queued = Integer.parseInt(state[1]);
			else if(state[0].equals("Held")) psc.held = Integer.parseInt(state[1]);
			else if(state[0].equals("Waiting")) psc.waiting = Integer.parseInt(state[1]);
			else if(state[0].equals("Running")) psc.running = Integer.parseInt(state[1]);
			else if(state[0].equals("Exiting")) psc.exiting = Integer.parseInt(state[1]);
			else psc.begun = Integer.parseInt(state[1]);
		}
		return psc;
	}
}
