package acs.jpbs.attrib;

import java.io.Serializable;

public class PbsStateCount implements Serializable {
	private static final long serialVersionUID = 597030985142433845L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + begun;
		result = prime * result + exiting;
		result = prime * result + held;
		result = prime * result + queued;
		result = prime * result + running;
		result = prime * result + transit;
		result = prime * result + waiting;
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
		PbsStateCount other = (PbsStateCount) obj;
		if (begun != other.begun)
			return false;
		if (exiting != other.exiting)
			return false;
		if (held != other.held)
			return false;
		if (queued != other.queued)
			return false;
		if (running != other.running)
			return false;
		if (transit != other.transit)
			return false;
		if (waiting != other.waiting)
			return false;
		return true;
	}
}
