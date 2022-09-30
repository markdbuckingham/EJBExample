package com.example.ejbexample.client;

import com.example.ejbexample.beans.Calculator;
import com.example.ejbexample.beans.CountryState;
import com.example.ejbexample.beans.Library;
import com.example.ejbexample.beans.WelcomeMsgRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.List;

public class RemoteEJBClient {
        public static void main(String[] args) throws Exception {

                // Stateless session beans
                WelcomeMsgRemote welcomeMsg = lookupWelcomeMsgBean();
                System.out.println("Message = " + welcomeMsg.getWelcomeMsg());

                Calculator calculator = lookupCalculatorBean();
                System.out.println("3 + 6 = " + calculator.add(3,6));
                System.out.println("3 * 5 = " + calculator.multiple(3,5));

                // Singleton session beans
                CountryState countryState = lookupCountryStateBean();
                List<String> countryList = countryState.getStates("UnitedStates");
                countryList.forEach(s->System.err.println(s));

                // Stateful session bean.
                System.err.println("Books");
                Library library = lookupLibraryBean();
                library.addBook("1984");
                library.addBook("Animal Farm");
                System.err.println("Books");
                library.getBooks().forEach(s->System.err.println(s));
                library.addBook("2001");
                System.err.println("Books");
                library.getBooks().forEach(s->System.err.println(s));
        }

        private static Context getInitialContext() throws NamingException {
                final Hashtable jndiProperties = new Hashtable();
                jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
                jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8081");
                final Context ctx = new InitialContext(jndiProperties);
                return ctx;
        }

        private static Calculator lookupCalculatorBean() throws NamingException {
                return (Calculator) getInitialContext().lookup("ejb:/EJBExample-1.0-SNAPSHOT/CalculatorBean!com.example.ejbexample.beans.Calculator");
        }

        private static WelcomeMsgRemote lookupWelcomeMsgBean() throws NamingException {
                return (WelcomeMsgRemote) getInitialContext().lookup("ejb:/EJBExample-1.0-SNAPSHOT/WelcomeMsgBean2!com.example.ejbexample.beans.WelcomeMsgRemote");
        }

        private static CountryState lookupCountryStateBean() throws NamingException {
                return (CountryState) getInitialContext().lookup("ejb:/EJBExample-1.0-SNAPSHOT/CountryStateBean!com.example.ejbexample.beans.CountryState");
        }

        private static Library lookupLibraryBean() throws NamingException {
                return (Library) getInitialContext().lookup("ejb:/EJBExample-1.0-SNAPSHOT/LibraryBean!com.example.ejbexample.beans.Library?stateful");
        }
}
