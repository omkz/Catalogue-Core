package org.omenk.provider;

import org.omenk.dao.KategoriDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Kurnia Muhamad
 */
public class ApplicationContextProvider {

    private static ApplicationContextProvider provider;
    private  ApplicationContext applicationContext; //update

    public synchronized static ApplicationContextProvider getInstance() throws ExceptionInInitializerError {
        ApplicationContextProvider tempProvider = null;
        if (provider == null) {
            provider = new ApplicationContextProvider();
            tempProvider = provider;
        } else if (provider.getApplicationContext() == null) {
            provider = new ApplicationContextProvider();
            tempProvider = provider;
        } else {
            tempProvider = provider;
        }

        return tempProvider;
    }

    private ApplicationContextProvider() throws ExceptionInInitializerError {
        try {
            this.applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        } catch (Throwable ex) {
            System.err.println("Initial ApplicationContext creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    //update
   
}
