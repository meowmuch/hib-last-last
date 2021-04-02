package ru.sfedu.hibernatecoursezz.lab1;

import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab1.HibernateMetadataProvider;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class HibernateMetadataProviderTest {

    /**
     * getting the size of the schemata
     * type: positive
     */
    @Test
    public void getSchema() {
        System.out.println("getSchema");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getSchema();
        assertNotNull(result);
    }

    /**
     * getting the size of the tables
     * type: positive
     */
    @Test
    public void getTables() {
        System.out.println("getTables");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getTables();
        assertNotNull(result);
    }

    /**
     * getting the name of the database
     * type: positive
     */
    @Test
    public void getSchemaName() {
        System.out.println("getSchemaName");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getSchemaName();
        assertNotNull(result);
    }

    /**
     * getting the user of the database
     * type: positive
     */
    @Test
    public void getUser() {
        System.out.println("getUser");
        HibernateMetadataProvider instance = new HibernateMetadataProvider();
        List result = instance.getUser();
        assertNotNull(result);
    }

}
