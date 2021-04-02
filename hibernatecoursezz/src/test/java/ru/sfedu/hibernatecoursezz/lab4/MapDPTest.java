package ru.sfedu.hibernatecoursezz.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.IMapDP;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.api.MapDP;
import ru.sfedu.hibernatecoursezz.lab4.mapCollection.model.Client;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class MapDPTest {

    public IMapDP provider = new MapDP();
    private Logger log = LogManager.getLogger(MapDPTest.class);
    public static Map<String,String> comment = new HashMap<String,String>();
    public static Map<String,String> commentUpdated = new HashMap<String,String>();

    /**
     * Update Client Record in DataSource
     * type: positive
     */
    @Test
    public void updateClient() {
        comment.put("comment_key","comment_1");
        commentUpdated.put("key","material_upd");
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
        comment.put("comment_key","comment_1");
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(id);
    }

    /**
     * Create Client Record in DataSource
     * type: negative
     */
    @Test
    public void createClientFail() {
        comment.put("comment_key","comment_1");
        Long id = provider.createClient("name","login", "password",comment);
        assertNotNull(id);
        Client client = new Client();
        client = provider.getByID(Client.class,id).get();
        Client expected = new Client();
        expected.setId(id);
        expected.setName("lname");
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
