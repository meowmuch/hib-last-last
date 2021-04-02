package ru.sfedu.hibernatecoursezz.lab3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Article;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Book;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.model.Film;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.HibernateProvider;
import ru.sfedu.hibernatecoursezz.lab3.SingleTable.api.IHibernateProvider;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class ST {
    public static Logger log = LogManager.getLogger(ST.class);
    IHibernateProvider provider = new HibernateProvider();

    /**
     * Creates Book Record in DataSource
     * type: positive
     */
    @Test
    public void createBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertNotNull(id);
    }

    /**
     * Creates Book Record in DataSource
     * type: negative
     */
    @Test
    public void fcreateBook() {
        Long id = provider.createBook("", null, "", null, "", 0);
        assertNotNull(id);
        Book book = new Book();
        book = provider.getById(Book.class,id).get();
        Book expected = new Book();
        expected.setId(id);
        expected.setNameOfBook("bbook");
        assertNotEquals(expected,book);
        assertNotEquals(id,Long.valueOf(0));
    }


    /**
     * Creates Film Record in DataSource
     * type: positive
     */
    @Test
    public void createFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertNotNull(id);
    }

    /**
     * Creates Film Record in DataSource
     * type: negative
     */
    @Test
    public void fcreateFilm() {
        Long id = provider.createFilm("", "", "", "", "", "");
        assertNotNull(id);
        Film film = new Film();
        film = provider.getById(Film.class,id).get();
        Film expected = new Film();
        expected.setId(id);
        expected.setNameOfBook("bbook");
        assertNotEquals(expected,film);
        assertNotEquals(id,Long.valueOf(0));
    }

    /**
     * Creates Article Record in DataSource
     * type: positive
     */
    @Test
    public void createArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertNotNull(id);
    }

    /**
     * Creates Article Record in DataSource
     * type: negative
     */
    @Test
    public void fcreateArticle() {
        Long id = provider.createArticle("", "", "", "");
        assertNotNull(id);
        Article article = new Article();
        article = provider.getById(Article.class,id).get();
        Article expected = new Article();
        expected.setId(id);
        expected.setNameOfBook("bbook");
        assertNotEquals(expected,article);
        assertNotEquals(id,Long.valueOf(0));
    }

    /**
     * Delete Book Record in DataSource
     * type: positive
     */
    @Test
    public void deleteBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.COMPLETE, provider.deleteBook(id));
    }

    /**
     * Delete Book Record in DataSource
     * type: negative
     */
    @Test
    public void fdeleteBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.FAIL, provider.deleteBook(id = -1L));
    }

    /**
     * Delete Film Record in DataSource
     * type: positive
     */
    @Test
    public void deleteFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.COMPLETE, provider.deleteFilm(id));
    }

    /**
     * Delete Film Record in DataSource
     * type: negative
     */
    @Test
    public void fdeleteFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.FAIL, provider.deleteFilm(id= -1L));
    }

    /**
     * Delete Article Record in DataSource
     * type: positive
     */
    @Test
    public void deleteArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.COMPLETE, provider.deleteArticle(id));
    }

    /**
     * Delete Article Record in DataSource
     * type: negative
     */
    @Test
    public void fdeleteArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.FAIL, provider.deleteArticle(id = -1L));
    }

    /**
     * Update Book Record in DataSource
     * type: positive
     */
    @Test
    public void updateBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.COMPLETE, provider.updateBook(id, " new book name", "author name", "link.com", "review1", "genre1", 5));
    }

    /**
     * Update Book Record in DataSource
     * type: negative
     */
    @Test
    public void fupdateBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertEquals(ResultType.FAIL, provider.updateBook(id = -1L, " new book name", "author name", "link.com", "review1", "genre1", 5));
    }

    /**
     * Update Film Record in DataSource
     * type: positive
     */
    @Test
    public void updateFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.COMPLETE, provider.updateFilm(id, "new book name", "new author name", "country", "2000", "producer1", "format1"));
    }

    /**
     * Update Film Record in DataSource
     * type: negative
     */
    @Test
    public void fupdateFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertEquals(ResultType.FAIL, provider.updateFilm(id =-1L, "new book name", "new author name", "country", "2000", "producer1", "format1"));
    }

    /**
     * Update Article Record in DataSource
     * type: positive
     */
    @Test
    public void updateArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.COMPLETE, provider.updateArticle(id, "new book name", "author name", "new title", "content"));
    }

    /**
     * Update Article Record in DataSource
     * type: negative
     */
    @Test
    public void fupdateArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertEquals(ResultType.FAIL, provider.updateArticle(id =-1L, "new book name", "author name", "new title", "content"));
    }

    /**
     * Get Book Record in DataSource
     * type: positive
     */
    @Test
    public void getBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertNotNull(provider.getById(Book.class,id));
    }

    /**
     * Get Book Record in DataSource
     * type: negative
     */
    @Test
    public void fgetBook() {
        Long id = provider.createBook("book name", "author name", "link.com", "review1", "genre1", 5);
        assertNotEquals(id, provider.getById(Book.class,id=-1L));
    }

    /**
     * Get Film Record in DataSource
     * type: positive
     */
    @Test
    public void getFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertNotNull(provider.getById(Film.class,id));
    }

    /**
     * Get Film Record in DataSource
     * type: negative
     */
    @Test
    public void fgetFilm() {
        Long id = provider.createFilm("book name", "author name", "country", "2000", "producer1", "format1");
        assertNotEquals(id, provider.getById(Film.class,id=-1L));
    }

    /**
     * Get Article Record in DataSource
     * type: positive
     */
    @Test
    public void getArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertNotNull(provider.getById(Article.class,id));
    }

    /**
     * Get Article Record in DataSource
     * type: negative
     */
    @Test
    public void fgetArticle() {
        Long id = provider.createArticle("book name", "author name", "title", "content");
        assertNotEquals(id, provider.getById(Article.class,id=-1L));
    }
}
