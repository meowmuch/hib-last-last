package ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Client;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.Plan;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.utils.HibernateUtil;
import ru.sfedu.hibernatecoursezz.utils.Constants;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CompMapDP implements ICompMapDP {

    public static Logger log = LogManager.getLogger(CompMapDP.class);
    static Session session;

    @Override
    public ResultType updateClient(long id, String cname, String login, String password, Map<String, Plan> plan) {
        log.info("In updateSection method");

        try {
            Client client = this.getByID(Client.class, id).get();
            client.setName(cname);
            client.setLogin(login);
            client.setPassword(password);
            client.setPlans(plan);
            this.update(client);
            return ResultType.COMPLETE;
        }
        catch (NoSuchElementException e){
            log.error(e);
            return ResultType.FAIL;
        }
    }

    @Override
    public Long createClient(String cname, String login, String password, Map<String, Plan> plan) {
        log.info("In createSection method");
        Client client = new Client();
        client.setName(cname);
        client.setLogin(login);
        client.setPassword(password);
        client.setPlans(plan);
        log.debug("Initializing section: "+ client);
        long id = this.save(client);
        log.debug("Saving section with id: "+ id);
        return id;
    }

    @Override
    public ResultType deleteClient(Long Id) {
        log.debug("On deleteStudent method");
        try {
            session = this.getSession();
            Client client = this.getByID(Client.class,Id).get();
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            return ResultType.COMPLETE;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return ResultType.FAIL;

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public List<Client> getClient() {
        try {
            session = this.getSession();
            String query = String.format(Constants.QUERY, Client.class.getSimpleName());
            Transaction transaction = session.beginTransaction();
            List<Client> clientList = session.createQuery(query).list();
            transaction.commit();
            log.debug(clientList);
            return clientList;
        } catch (IOException | NoSuchElementException e) {
            log.error(e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }

    public Session getSession() throws IOException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        return factory.openSession();
    }


    @Override
    public <T> void update(T bean) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(bean);
            transaction.commit();
        } catch (IOException | NonUniqueObjectException e) {
            log.error(e);
        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    @Transactional
    public <T> Optional<T> getByID(Class<T> bean, long id) {
        try {
            Session session = this.getSession();
            T resultBean = session.get(bean, id);
            log.debug("Returned entity: " + resultBean.toString());
            session.close();
            return Optional.of(resultBean);
        } catch (IOException | NullPointerException e) {
            log.error(e);
            return Optional.empty();
        }
    }

    @Override
    public <T>Long save(T bean) {
        try {
            session = this.getSession();
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(bean);
            transaction.commit();
            log.debug("Saving bean with the id: " + id.toString());
            return id;
        } catch (IOException e) {
            log.error(e);
            return null;
        } finally {
            if (session != null) session.close();
        }
    }
}