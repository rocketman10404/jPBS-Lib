package acs.jpbs.attrib;

import java.io.Serializable;

public class PbsServerLicenses implements Serializable {

	private static final long serialVersionUID = -2574293919302300076L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availGlobal;
		result = prime * result + availLocal;
		result = prime * result + highUse;
		result = prime * result + used;
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
		PbsServerLicenses other = (PbsServerLicenses) obj;
		if (availGlobal != other.availGlobal)
			return false;
		if (availLocal != other.availLocal)
			return false;
		if (highUse != other.highUse)
			return false;
		if (used != other.used)
			return false;
		return true;
	}
}
