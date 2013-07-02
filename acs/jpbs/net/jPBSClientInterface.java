package acs.jpbs.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

import acs.jpbs.core.PbsJob;
import acs.jpbs.core.PbsQueue;
import acs.jpbs.core.PbsServer;

public interface jPBSClientInterface extends Remote {
	void updateServer(PbsServer newServer) throws RemoteException;
	
	void updateQueue(PbsQueue newQueue) throws RemoteException;
	
	void updateJob(PbsJob newJob) throws RemoteException;
}
