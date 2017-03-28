package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Operacao {


    protected Servidor() throws RemoteException {
        super();
    }

    public static void main(String[] args){
        try {
            Servidor servidor = new Servidor();
            String local = "//localhost/operacao";
            Naming.rebind(local, servidor);
        } catch (RemoteException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("ERRO URL MAL FORMADA: " + e.getMessage());
        }
    }

    @Override
    public boolean primo(int x) throws RemoteException {
        int cont = 0;

        for (int j = 1; j <= x ; ++j){
            if(x % j == 0)
                cont++;
            if(cont > 2)
                return false;
        }
        return true;
    }
}
