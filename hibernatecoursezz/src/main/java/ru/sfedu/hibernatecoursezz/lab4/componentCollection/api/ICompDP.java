package ru.sfedu.hibernatecoursezz.lab4.componentCollection.api;

import ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.*;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICompDP {

    /**
     * Update Client Record in DataSource
     * @param id id
     * @param cname client name
     * @param login login
     * @param password password
     * @param plan plan of client
     * @return result
     */
    ResultType updateClient(long id, String cname, String login, String password, List<Plan> plan);

    /**
     * Create Client Record in DataSource
     * @param cname client name
     * @param login login
     * @param password password
     * @param plan plan of client
     * @return
     */
    Long createClient(String cname, String login, String password, List<Plan> plan);

    /**
     * Delete Client Record in DataSource
     * @param Id id
     * @return
     */
    ResultType deleteClient(Long Id);


    /**
     * Get list Client Records in DataSource
     * @return
     */
    List<Client> getClient();

    /**
     * Updates Entity Record in DataSource
     * @param bean class Name
     * @param <T> class
     */
    <T> void update(T bean);

    /**
     * Retrieve Entity with given id
     * @param bean class name
     * @param id id
     * @param <T> class
     * @return
     */
    <T> Optional<T> getByID(Class<T> bean, long id);

    /**
     * Save new entity in the database
     * @param bean class name
     * @param <T> class
     * @return
     */
    <T>Long save(T bean);
}

