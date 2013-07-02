package acs.jpbs.attrib;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.xml.datatype.Duration;

import acs.jpbs.utils.Utils;

public class PbsResource implements Serializable {
	private static final long serialVersionUID = -9065959700088246656L;
	public String arch = null;
	public Integer cpupercent = null;
	public Duration cput = null;
	private String execVnode = null;
	public Long file = null;
	public String host = null;
	public Long mem = null;
	public Integer mpiprocs = null;
	public Integer nchunk = null;
	public Integer ncpus = null;
	public Integer nice = null;
	public Integer nodeCount = null;
	public Integer ompThreads;
	public Duration pcput = null;
	public Long pmem = null;
	public Long pvmem = null;
	public String select = null;
	public String software = null;
	public Long startTime = null;
	public Long vmem = null;
	public String vnode = null;
	public Duration wallTime = null;
	
	public PbsResource() { }
	
	public void debugOutput() {
		HashMap<String, Object> tmp = new HashMap<String, Object>();
		
		tmp.put(".arch", this.arch);
		tmp.put(".cpupercent", this.cpupercent);
		tmp.put(".cput", this.cput);
		tmp.put(".execVnode", this.execVnode);
		tmp.put(".file", this.file);
		tmp.put(".host", this.host);
		tmp.put(".mem", this.mem);
		tmp.put(".mpiproces", this.mpiprocs);
		tmp.put(".nchunk", this.nchunk);
		tmp.put(".ncpus", this.ncpus);
		tmp.put(".nice", this.nice);
		tmp.put(".nodeCount", this.nodeCount);
		tmp.put(".ompThreads", this.ompThreads);
		tmp.put(".pcput", this.pcput);
		tmp.put(".pmem", this.pmem);
		tmp.put(".pvmem", this.pvmem);
		tmp.put(".select", this.select);
		tmp.put(".software", this.software);
		tmp.put(".startTime", this.startTime);
		tmp.put(".vmem", this.vmem);
		tmp.put(".vnode", this.vnode);
		tmp.put(".wallTime", this.wallTime);
		
		
		System.out.println("PBS RESOURCE OBJECT -- OUTPUT");
		Iterator<Entry<String, Object>> iter = tmp.entrySet().iterator();
		Entry<String, Object> ptr = (Entry<String, Object>)iter.next();
		while(iter.hasNext()) {
			System.out.print(ptr.getKey() + " : ");
			if(ptr.getValue() != null) System.out.println(ptr.getValue().toString());
			else System.out.println("null");
			ptr = (Entry<String, Object>)iter.next();
		}
		System.out.println("END RESOURCE OUTPUT");
	}
	
	public static PbsResource processResource(List<String[]> rawArrList) {
		PbsResource pr = new PbsResource();
		if(rawArrList == null || rawArrList.isEmpty()) return pr;
		for(String[] rawArr : rawArrList) {
			if(rawArr.length != 2) continue;
			String[] rawAtt = rawArr[0].split("\\.");
			if(rawAtt.length != 2) continue;
			
			
			if(rawAtt[1].equals("arch")) pr.arch = rawArr[1].trim();
			else if(rawAtt[1].equals("cpupercent")) pr.cpupercent = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("cput")) pr.cput = Utils.getHMSDuration(rawArr[1].trim());
			else if(rawAtt[1].equals("exec_vnode")) pr.execVnode = rawArr[1].trim();
			else if(rawAtt[1].equals("file")) pr.file = Long.parseLong(rawArr[1].trim().replace("kb", ""));
			else if(rawAtt[1].equals("host")) pr.host = rawArr[1].trim();
			else if(rawAtt[1].equals("mem")) pr.mem = Long.parseLong(rawArr[1].trim().replace("kb", ""));
			else if(rawAtt[1].equals("mpiprocs")) pr.mpiprocs = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("nchunk")) pr.nchunk = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("ncpus")) pr.ncpus = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("nice")) pr.nice = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("nodect")) pr.nodeCount = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("ompthreads")) pr.ompThreads = Integer.parseInt(rawArr[1].trim());
			else if(rawAtt[1].equals("pcput")) pr.pcput = Utils.getHMSDuration(rawArr[1].trim());
			else if(rawAtt[1].equals("pmem")) pr.pmem = Long.parseLong(rawArr[1].trim().replace("kb",""));
			else if(rawAtt[1].equals("pvmem")) pr.pvmem = Long.parseLong(rawArr[1].trim().replace("kb",""));
			else if(rawAtt[1].equals("select")) pr.select = rawArr[1].trim();
			else if(rawAtt[1].equals("software")) pr.software = rawArr[1].trim();
			else if(rawAtt[1].equals("start_time")) pr.startTime = Long.parseLong(rawArr[1].trim());
			else if(rawAtt[1].equals("vmem")) pr.vmem = Long.parseLong(rawArr[1].trim().replace("kb",""));
			else if(rawAtt[1].equals("vnode")) pr.vnode = rawArr[1].trim();
			else if(rawAtt[1].equals("walltime")) pr.wallTime = Utils.getHMSDuration(rawArr[1].trim());
		}
		return pr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arch == null) ? 0 : arch.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((mem == null) ? 0 : mem.hashCode());
		result = prime * result
				+ ((mpiprocs == null) ? 0 : mpiprocs.hashCode());
		result = prime * result + ((nchunk == null) ? 0 : nchunk.hashCode());
		result = prime * result + ((ncpus == null) ? 0 : ncpus.hashCode());
		result = prime * result
				+ ((ompThreads == null) ? 0 : ompThreads.hashCode());
		result = prime * result + ((pcput == null) ? 0 : pcput.hashCode());
		result = prime * result + ((pmem == null) ? 0 : pmem.hashCode());
		result = prime * result + ((pvmem == null) ? 0 : pvmem.hashCode());
		result = prime * result + ((select == null) ? 0 : select.hashCode());
		result = prime * result
				+ ((software == null) ? 0 : software.hashCode());
		result = prime * result + ((vmem == null) ? 0 : vmem.hashCode());
		result = prime * result + ((vnode == null) ? 0 : vnode.hashCode());
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
		PbsResource other = (PbsResource) obj;
		if (arch == null) {
			if (other.arch != null)
				return false;
		} else if (!arch.equals(other.arch))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (mem == null) {
			if (other.mem != null)
				return false;
		} else if (!mem.equals(other.mem))
			return false;
		if (mpiprocs == null) {
			if (other.mpiprocs != null)
				return false;
		} else if (!mpiprocs.equals(other.mpiprocs))
			return false;
		if (nchunk == null) {
			if (other.nchunk != null)
				return false;
		} else if (!nchunk.equals(other.nchunk))
			return false;
		if (ncpus == null) {
			if (other.ncpus != null)
				return false;
		} else if (!ncpus.equals(other.ncpus))
			return false;
		if (ompThreads == null) {
			if (other.ompThreads != null)
				return false;
		} else if (!ompThreads.equals(other.ompThreads))
			return false;
		if (pcput == null) {
			if (other.pcput != null)
				return false;
		} else if (!pcput.equals(other.pcput))
			return false;
		if (pmem == null) {
			if (other.pmem != null)
				return false;
		} else if (!pmem.equals(other.pmem))
			return false;
		if (pvmem == null) {
			if (other.pvmem != null)
				return false;
		} else if (!pvmem.equals(other.pvmem))
			return false;
		if (select == null) {
			if (other.select != null)
				return false;
		} else if (!select.equals(other.select))
			return false;
		if (software == null) {
			if (other.software != null)
				return false;
		} else if (!software.equals(other.software))
			return false;
		if (vmem == null) {
			if (other.vmem != null)
				return false;
		} else if (!vmem.equals(other.vmem))
			return false;
		if (vnode == null) {
			if (other.vnode != null)
				return false;
		} else if (!vnode.equals(other.vnode))
			return false;
		return true;
	}
}
