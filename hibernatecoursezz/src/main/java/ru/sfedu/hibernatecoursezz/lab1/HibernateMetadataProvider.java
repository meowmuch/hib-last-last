package ru.sfedu.hibernatecoursezz.lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.hibernatecoursezz.utils.Constants;
import ru.sfedu.hibernatecoursezz.lab1.utils.HibernateUtil;

import java.io.IOException;
import java.util.List;


public class HibernateMetadataProvider implements IMetadataProvider{

    private static Logger log = LogManager.getLogger(ru.sfedu.hibernatecoursezz.lab1.HibernateMetadataProvider.class);



    @Override
    public List getSchema() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.SCHEMA);
            List resList = query.getResultList();
            session.close();
            log.info("Get schema size: {}", resList.size());
            return resList;
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getTables() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.TABLE);
            List resList = query.getResultList();
            session.close();
            log.debug("Get table size: {}" + resList.toString());
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getSchemaName() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.NAME);
            List resList = query.getResultList();
            session.close();
            log.debug("Get schema name: {}", resList);
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    @Override
    public List getUser() {
        try {
            Session session = this.getSession();
            NativeQuery query = session.createSQLQuery(Constants.USER);
            List resList = query.getResultList();
            session.close();
            log.debug("Get user: {}",resList);
            return resList;
        }
        catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    /**
     * getting session
     * @return result
     * @throws IOException
     */
    private Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }
}
