package acs.jpbs.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import acs.jpbs.attrib.PbsResource;
import acs.jpbs.attrib.PbsServerLicenses;
import acs.jpbs.attrib.PbsStateCount;
import acs.jpbs.enums.PbsServerState;
import acs.jpbs.utils.Utils;

public class PbsServer implements Serializable {
	private static final long serialVersionUID = 6455928702644240133L;
	/*
	 * PbsServer implemented as Singleton
	 */
	private static PbsServer instance = null;
	/*
	 * Serialized object data to be transmitted between client/server
	 */
	protected PbsServerState state = null;
	protected String host = null;
	protected Boolean scheduling = null;
	protected PbsStateCount stateCount = new PbsStateCount();
	protected String defaultQueueKey = null;
	protected PbsResource resourcesAssigned = new PbsResource();
	protected PbsResource defaultChunk = new PbsResource();
	protected Integer schedulerIteration = null;
	protected Integer fLicenses = null;
	protected Boolean resvEnable = null;
	protected PbsServerLicenses licenseCount = new PbsServerLicenses();
	protected String version = null;
	/*
	 * Transient object data to be reconstructed on either side
	 */
	private transient HashMap<String, PbsQueue> queues = new HashMap<String, PbsQueue>();
	private transient ReentrantReadWriteLock queueMapLock = new ReentrantReadWriteLock(true);
	private transient Lock queueMapWriteLock = queueMapLock.writeLock();
	private transient Lock queueMapReadLock = queueMapLock.readLock();
	
	private PbsServer() { }
	
	public static PbsServer getInstance() {
		if(instance == null) {
			instance = new PbsServer();
		}
		return instance;
	}
	
	public static void makeCopy(PbsServer ref) {
		if(instance == null) instance = new PbsServer();
		instance.state = ref.state;
		instance.host = ref.host;
		instance.scheduling = ref.scheduling;
		instance.stateCount = ref.stateCount;
		instance.defaultQueueKey = ref.defaultQueueKey;
		instance.resourcesAssigned = ref.resourcesAssigned;
		instance.defaultChunk = ref.defaultChunk;
		instance.schedulerIteration = ref.schedulerIteration;
		instance.fLicenses = ref.fLicenses;
		instance.resvEnable = ref.resvEnable;
		instance.licenseCount = ref.licenseCount;
		instance.version = ref.version;
	}
	
	public void addQueue(PbsQueue q) {
		this.queueMapWriteLock.lock();
		try {
			this.queues.put(q.name, q);
		} finally {
			this.queueMapWriteLock.unlock();
		}
	}
	
	public void debugPrint() {
		System.out.println("PBS SERVER OBJECT -- OUTPUT");
		System.out.println(".host : '"+this.host+"'");
		System.out.println(".scheduling : '"+this.scheduling+"'");
		System.out.println(".stateCount : ");
		this.stateCount.debugOutput();
		System.out.println(".defaultQueue : '"+this.defaultQueueKey+"'");
		System.out.println(".resourcesAssigned : ");
		this.resourcesAssigned.debugOutput();
		System.out.println(".defaultChunk : ");
		this.defaultChunk.debugOutput();
		System.out.println(".schedulerIteration : '"+this.schedulerIteration+"'");
		System.out.println(".fLicenses : '"+this.fLicenses+"'");
		System.out.println(".resvEnable : '"+this.resvEnable+"'");
		System.out.println(".licenseCount : ");
		this.licenseCount.debugOutput();
		System.out.println(".version : '"+this.version+"'");
		System.out.println("END SERVER OBJECT OUTPUT");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PbsServer other = (PbsServer) obj;
		if (defaultChunk == null) {
			if (other.defaultChunk != null)
				return false;
		} else if (!defaultChunk.equals(other.defaultChunk))
			return false;
		if (defaultQueueKey == null) {
			if (other.defaultQueueKey != null)
				return false;
		} else if (!defaultQueueKey.equals(other.defaultQueueKey))
			return false;
		if (fLicenses == null) {
			if (other.fLicenses != null)
				return false;
		} else if (!fLicenses.equals(other.fLicenses))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (licenseCount == null) {
			if (other.licenseCount != null)
				return false;
		} else if (!licenseCount.equals(other.licenseCount))
			return false;
		this.queueMapReadLock.lock();
		try {
			if (queues == null) {
				if (other.queues != null)
					return false;
			} else if (!queues.equals(other.queues))
				return false;
		} finally {
			this.queueMapReadLock.unlock();
		}
		if (resourcesAssigned == null) {
			if (other.resourcesAssigned != null)
				return false;
		} else if (!resourcesAssigned.equals(other.resourcesAssigned))
			return false;
		if (resvEnable == null) {
			if (other.resvEnable != null)
				return false;
		} else if (!resvEnable.equals(other.resvEnable))
			return false;
		if (schedulerIteration == null) {
			if (other.schedulerIteration != null)
				return false;
		} else if (!schedulerIteration.equals(other.schedulerIteration))
			return false;
		if (scheduling == null) {
			if (other.scheduling != null)
				return false;
		} else if (!scheduling.equals(other.scheduling))
			return false;
		if (state != other.state)
			return false;
		if (stateCount == null) {
			if (other.stateCount != null)
				return false;
		} else if (!stateCount.equals(other.stateCount))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	public String getHostName() {
		return this.host;
	}
	
	public PbsJob[] getJobArray() {
		PbsJob[] retArr = null;
		for(PbsQueue q : this.getQueueArray()) {
			retArr = Utils.concat(retArr, q.getJobArray());
		}
		return retArr;
	}
	
	public int getNumJobs() {
		int retVal = 0;
		if(this.queues == null || this.queues.isEmpty()) return retVal;
		this.queueMapReadLock.lock();
		try {
			for(Entry<String, PbsQueue> qEntry : this.queues.entrySet()) {
				retVal += qEntry.getValue().getNumJobs();
			}
		} finally {
			this.queueMapReadLock.unlock();
		}
		return retVal;
	}
	
	public int getNumQueues() {
		int retVal = 0;
		this.queueMapReadLock.lock();
		try {
			if(this.queues != null && !this.queues.isEmpty()) retVal = this.queues.size();
		} finally {
			this.queueMapReadLock.unlock();
		}
		return retVal;
	}
	
	public PbsQueue getQueue(int index) {
		PbsQueue retQ = null;
		if(index < this.getNumQueues()) {
			this.queueMapReadLock.lock();
			try {
				String[] sArr = new String[this.queues.size()];
				this.queues.keySet().toArray(sArr);
				retQ = this.queues.get(sArr[index]);
			} finally {
				this.queueMapReadLock.unlock();
			}
		}
		return retQ;
	}
	
	public PbsQueue getQueue(String name) {
		PbsQueue retQ = null;
		if(this.queues == null || this.queues.isEmpty()) return null;
		this.queueMapReadLock.lock();
		try {
			if(this.queues.containsKey(name)) retQ = this.queues.get(name);
		} finally {
			this.queueMapReadLock.unlock();
		}
		return retQ;
	}

	public PbsQueue[] getQueueArray() {
		int numQueues = this.getNumQueues();
		if(numQueues == 0) return null;
		PbsQueue[] returnArr = null;
		
		this.queueMapReadLock.lock();
		try {
			returnArr = new PbsQueue[numQueues];
			int i = 0;
			for(Entry<String, PbsQueue> qEntry : this.queues.entrySet()) {
				returnArr[i++] = qEntry.getValue();
			}
		} finally {
			this.queueMapReadLock.unlock();
		}
		return returnArr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defaultChunk == null) ? 0 : defaultChunk.hashCode());
		result = prime * result
				+ ((defaultQueueKey == null) ? 0 : defaultQueueKey.hashCode());
		result = prime * result
				+ ((fLicenses == null) ? 0 : fLicenses.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result
				+ ((licenseCount == null) ? 0 : licenseCount.hashCode());
		this.queueMapReadLock.lock();
		try {
			result = prime * result + ((queues == null) ? 0 : queues.hashCode());
		} finally {
			this.queueMapReadLock.unlock();
		}
		result = prime
				* result
				+ ((resourcesAssigned == null) ? 0 : resourcesAssigned
						.hashCode());
		result = prime * result
				+ ((resvEnable == null) ? 0 : resvEnable.hashCode());
		result = prime
				* result
				+ ((schedulerIteration == null) ? 0 : schedulerIteration
						.hashCode());
		result = prime * result
				+ ((scheduling == null) ? 0 : scheduling.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((stateCount == null) ? 0 : stateCount.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		if(this.queueMapLock == null) {
			this.queueMapLock = new ReentrantReadWriteLock();
			this.queueMapReadLock = this.queueMapLock.readLock();
			this.queueMapWriteLock = this.queueMapLock.writeLock();
		}
		if(this.queues == null) this.queues = new HashMap<String, PbsQueue>();
	}
}
