package ru.sfedu.hibernatecoursezz.lab4.setCollection.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.Constants;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final String CUSTOM_CONFIG_PATH = System.getProperty("configPath");
    private static Logger log = LogManager.getLogger(HibernateUtil.class);
    /**
     * Создание фабрики
     *
     */
  /*  public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
// loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
           // metadataSources.addAnnotatedClass(TestEntity.class);// Аннотированная сущность
           // metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }
        return sessionFactory;
    }*/

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            File nf;
            try{
                nf = new File(CUSTOM_CONFIG_PATH);
            }
            catch(NullPointerException e){
                nf = new File(Constants.PATH_TO_CFG_XML_LAB4_S);
            };
            File file = nf;
            Configuration configuration = new Configuration().configure(file);

            log.error(file.getName());

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);


            //metadataSources.addResource("named-queries.hbm.xml");// Именованные запросы

            addEntities(metadataSources);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources){
        metadataSources.addAnnotatedClass(Client.class);
    }
}
