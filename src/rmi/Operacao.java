package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Rafahel on 28/03/2017.
 */
public interface Operacao extends Remote {

    public boolean primo(int x) throws RemoteException;

}
