package acs.jpbs.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

import acs.jpbs.core.PbsJob;
import acs.jpbs.core.PbsQueue;
import acs.jpbs.core.PbsServer;

public interface jPBSServerInterface extends Remote {
	public PbsServer getServerObject() throws RemoteException;
	public PbsQueue[] getQueueArray() throws RemoteException;
	public PbsJob[] getJobArray() throws RemoteException;
	public void register(jPBSClientInterface newClient) throws RemoteException;
	public void deregister(jPBSClientInterface client) throws RemoteException;
}
