/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.omenk.provider;

import org.omenk.dao.KategoriDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HBTemplate {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        HBTemplate.applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        return applicationContext;
    }

    public static KategoriDAO getKategori() {
        return (KategoriDAO) applicationContext.getBean("kategoriDAO");
    }
}
