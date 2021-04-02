package ru.sfedu.hibernatecoursezz.lab4.setCollection.api;

import ru.sfedu.hibernatecoursezz.lab4.setCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ISetDP {

        /**
         * Update Client Record in DataSource
         *
         * @param id       id
         * @param cname    client name
         * @param login    login
         * @param password password
         * @param comment  comment
         * @return result
         */
        ResultType updateClient(long id, String cname, String login, String password, Set<String> comment);

        /**
         * Create Client Record in DataSource
         *
         * @param cname    client name
         * @param login    login
         * @param password password
         * @param comment  comment
         * @return
         */
        Long createClient(String cname, String login, String password, Set<String> comment);

        /**
         * Delete Client Record in DataSource
         *
         * @param Id id
         * @return
         */
        ResultType deleteClient(Long Id);

        /**
         * Get Client Record by id in DataSource
         *
         * @param Id id
         * @return
         */
        Client getbyidClient(Long Id);

        /**
         * Get list Client Records in DataSource
         *
         * @return
         */
        List<Client> getClient();

        /**
         * Updates Entity Record in DataSource
         *
         * @param bean class Name
         * @param <T>  class
         */
        <T> void update(T bean);

        /**
         * Retrieve Entity with given id
         *
         * @param bean class name
         * @param id   id
         * @param <T>  class
         * @return
         */
        <T> Optional<T> getByID(Class<T> bean, long id);

        /**
         * Save new entity in the database
         *
         * @param bean class name
         * @param <T>  class
         * @return
         */
        <T> Long save(T bean);
    }


