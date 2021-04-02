package ru.sfedu.hibernatecoursezz.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.api.IListDP;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.api.ListDP;
import ru.sfedu.hibernatecoursezz.lab4.listCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ListDPTest {

    public List<String> comment = Arrays.asList("comment1","comment2","comment3");

    public List<String> commentUpdated = Arrays.asList("comment_1","comment_2","comment_3");


    public IListDP provider = new ListDP();
    private Logger log = LogManager.getLogger(ListDPTest.class);

    /**
     * Update Client Record in DataSource
     * type: positive
     */
    @Test
    public void updateClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",commentUpdated));
    }

    /**
     * Update Client Record in DataSource
     * type: negative
     */
    @Test
    public void updateClientFail() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",comment));
    }

    /**
     * Create Client Record in DataSource
     * type: positive
     */
    @Test
    public void createClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(id);
    }

    /**
     * Create Client Record in DataSource
     * type: negative
     */
    @Test
    public void createClientFail() {
        Long id = provider.createClient("","login", "password",comment);
        assertNotNull(id);
        Client client = new Client();
        client = provider.getByID(Client.class,id).get();
        Client expected = new Client();
        expected.setId(id);
        expected.setName("name");
        assertNotEquals(expected,client);
        assertNotEquals(id,Long.valueOf(0));
    }

    /**
     * Delete Client Record in DataSource
     * type: positive
     */
    @Test
    public void deleteClient() {
        Long id = provider.createClient("name","login", "password",comment);
        assertEquals(ResultType.COMPLETE,provider.deleteClient(id));
    }

    /**
     * Delete Client Record in DataSource
     * type: negative
     */
    @Test
    public void deleteClientFail(){
        assertEquals(ResultType.FAIL,provider.deleteClient(0L));
    }

    /**
     * Getting Client Records in DataSource
     * type: positive
     */
    @Test
    public void getClients()  {
        Long id = provider.createClient("name","login", "password",comment);
        List<Client> clientList = provider.getClient();
        log.info(clientList);
        assertNotNull(clientList);
    }

    /**
     * Getting Client Records in DataSource
     * type: negative
     */
    @Test
    public void fgetClients()  {
        List<Client> clientList = provider.getClient();
        assertEquals(clientList,provider.getClient());
    }

    /**
     * Get Client Record by id in DataSource
     * type: positive
     */
    @Test
    public void getClientById() {
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(provider.getByID(Client.class,id).get());
    }

    /**
     * Get Client Record by id in DataSource
     * type: negative
     */
    @Test
    public void fgetClientById() {
        Long id = provider.createClient("name","login", "password",comment);
        assertNotEquals(id, provider.getByID(Client.class,id=-1L));
    }
}
