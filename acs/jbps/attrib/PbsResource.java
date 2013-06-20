package acs.jbps.attrib;

import java.util.Date;

import javax.xml.datatype.Duration;

public class PbsResource {
	public String arch;
	public Duration cput;
	private String execVnode;
	public long file;
	public String host;
	public long mem;
	public int mpiprocs;
	public int nchunk;
	public int ncpus;
	public int nice;
	public int ompThreads;
	public Duration pcput;
	public long pmem;
	public long pvmem;
	public String software;
	public Date startTime;
	public long vmem;
	public String vnode;
	public Duration wallTime;
	
	public PbsResource() { }
}
