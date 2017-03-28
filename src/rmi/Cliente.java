package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by Rafahel on 28/03/2017.
 */
public class Cliente {
    Operacao operacao = null;
    public Cliente(){
        String local = "//localhost/operacao";
        try {
            operacao = (Operacao) Naming.lookup(local);



        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Cliente cliente = new Cliente();
        System.out.print("Insira um numero para saber se o mesmo e primo: ");
        Scanner scan = new Scanner(System.in);
        int valor = scan.nextInt();
        try {
            boolean resultado = cliente.operacao.primo(valor);

            if(resultado){
                System.out.println(valor + " eh primo");
                return;
            }
            System.out.println(valor + " nao eh primo");
            return;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
