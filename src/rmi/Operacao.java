package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operacao extends Remote {

    public boolean primo(int x) throws RemoteException;

}
