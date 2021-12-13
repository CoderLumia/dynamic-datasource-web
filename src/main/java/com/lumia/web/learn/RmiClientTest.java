package com.lumia.web.learn;

import com.lumia.web.entity.RmiTest;
import com.sun.jndi.rmi.registry.ReferenceWrapper;
import com.sun.jndi.rmi.registry.ReferenceWrapper_Stub;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClientTest {

    public static void main(String[] args) {

        try {
            ReferenceWrapper_Stub referenceWrapper = (ReferenceWrapper_Stub) Naming.lookup("rmi://127.0.0.1:8088/hello");
            Reference reference = referenceWrapper.getReference();
            String className = reference.getClassName();
            Class<?> aClass = Class.forName(className);
            Object o = aClass.newInstance();
            System.out.println(className);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
