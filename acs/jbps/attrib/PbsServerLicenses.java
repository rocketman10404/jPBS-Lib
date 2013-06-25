package acs.jbps.attrib;

public class PbsServerLicenses {
	public int availGlobal = 0;
	public int availLocal = 0;
	public int used = 0;
	public int highUse = 0;
	
	public PbsServerLicenses() { }
	
	public void debugOutput() {
		System.out.println("PBS SERVER LICENSES OBJECT -- OUTPUT");
		System.out.println(".availGlobal : '"+this.availGlobal+"'");
		System.out.println(".availLocal : '"+this.availLocal+"'");
		System.out.println(".used : '"+this.used+"'");
		System.out.println(".highUse : '"+this.highUse+"'");
		System.out.println("END LICENSES OBJECT OUTPUT");
	}
	
	public static PbsServerLicenses parseServerLicenses(String raw) {
		PbsServerLicenses psl = new PbsServerLicenses();
		
		String[] states = raw.split(" ");
		for(int i=0; i<states.length; i++) {
			String[] state = states[i].split(":");
			if(state.length != 2) continue;
			if(state[0].equals("Avail_Global")) psl.availGlobal = Integer.parseInt(state[1]);
			else if(state[0].equals("Avail_Local")) psl.availLocal = Integer.parseInt(state[1]);
			else if(state[0].equals("Used")) psl.used = Integer.parseInt(state[1]);
			else psl.highUse = Integer.parseInt(state[1]);
		}
		return psl;
	}
}
