package ru.sfedu.hibernatecoursezz.lab3.JoinedTable.api;


import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IHibernateProvider {

    /**
     * Creates Book Record in DataSource
     * @param aname author name
     * @param bname book name
     * @param link link
     * @param review review
     * @param genre genre
     * @param time time
     * @return result
     */
    Long createBook(String aname, String bname, String link,
                    String review, String genre, int time);

    /**
     * Creates Film Record in DataSource
     * @param aname author name
     * @param bname book name
     * @param country country
     * @param year year
     * @param producer producer
     * @param format format
     * @return result
     */
    Long createFilm(String aname, String bname, String country,
                    String year, String producer, String format);

    /**
     * Creates Article Record in DataSource
     * @param aname author name
     * @param bname book name
     * @param title title
     * @param content content
     * @return result
     */
    Long createArticle(String aname, String bname, String title,
                       String content);

    /**
     * Update Film Record in DataSource
     * @param id id of film
     * @param aname author name
     * @param bname book name
     * @param country country
     * @param year year
     * @param producer producer
     * @param format format
     * @return result
     */
    ResultType updateFilm(Long id, String aname, String bname, String country,
                          String year, String producer, String format);

    /**
     * Update Book Record in DataSource
     * @param id id of book
     * @param aname author name
     * @param bname book name
     * @param link link
     * @param review review
     * @param genre genre
     * @param time time
     * @return result
     */
    ResultType updateBook(Long id, String aname, String bname, String link,
                          String review, String genre, int time);

    /**
     * Update Article Record in DataSource
     * @param id id of article
     * @param aname author name
     * @param bname book name
     * @param title title
     * @param content content
     * @return result
     */
    ResultType updateArticle(Long id, String aname, String bname, String title,
                             String content);

    /**
     * Delete Book Record in DataSource
     * @param Id id of book
     * @return result
     */
    ResultType deleteBook(Long Id);

    /**
     * Delete Film Record in DataSource
     * @param Id id of film
     * @return result
     */
    ResultType deleteFilm(Long Id);

    /**
     * Delete Article Record in DataSource
     * @param Id id of article
     * @return result
     */
    ResultType deleteArticle(Long Id);

    /**
     * Updates Entity Record in DataSource
     * @param cn Class Name
     * @param <T> Generic type (any Class or type)
     */
    <T> void update(T cn);

    /**
     * Retrieve Entity with given id
     * @param cn Class Name
     * @param id id records
     * @param <T> Generic type (any Class or type)
     * @return result
     */
    <T>Optional<T> getById(Class<T> cn, Long id);

    /**
     * Save new entity in the database
     * @param cn Class Name
     * @param <T> Generic type (any Class or type)
     * @return result
     */
    <T>Long save(T cn);
}
