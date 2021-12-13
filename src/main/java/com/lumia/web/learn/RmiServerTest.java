package com.lumia.web.learn;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServerTest {

    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(8088);
            Reference reference = new Reference("com.lumia.web.entity.RmiTest", "com.lumia.web.entity.RmiTest", null);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            Naming.bind("rmi://127.0.0.1:8088/hello", referenceWrapper);
            System.out.println("finish binding");
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
