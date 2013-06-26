package acs.jpbs.attrib;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.xml.datatype.Duration;

import acs.jpbs.utils.Utils;

public class PbsResource {
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
		Iterator iter = tmp.entrySet().iterator();
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
}
