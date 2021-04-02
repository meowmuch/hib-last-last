package ru.sfedu.hibernatecoursezz.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.api.CompDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.api.ICompDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollection.model.*;

import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CompDPTest {

    public ICompDP provider = new CompDP();
    public static Plan plan = new Plan();
    private Logger log = LogManager.getLogger(CompDPTest.class);

    /**
     * Update Client Record in DataSource
     * type: positive
     */
    @Test
    public void updateClient() {
        Plan planNew = new Plan();
        planNew.setName("New plan plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(planNew));
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",Collections.singletonList(planNew)));
    }

    /**
     * Update Client Record in DataSource
     * type: negative
     */
    @Test
    public void updateClientFail() {
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",Collections.emptyList()));
    }

    /**
     * Create Client Record in DataSource
     * type: positive
     */
    @Test
    public void createClient() {
        plan.setName("New plan");
        Long id = provider.createClient("name","login", "password", Collections.singletonList(plan));
        assertNotNull(id);
    }

    /**
     * Create Client Record in DataSource
     * type: negative
     */
    @Test
    public void createClientFail() {
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(plan));
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
        plan.setName("New plan");
        Long id = provider.createClient("name","login", "password",Collections.emptyList());
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
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(plan));
        List<Client> clientList = provider.getClient();
        log.info(clientList);
        assertNotNull(clientList);
    }

    /**
     * Getting Client Records in DataSource
     * type: negative
     */
    @Test
    public void getClientsFail()  {
        List<Client> clientList = provider.getClient();
        assertNotNull(clientList);
    }

    /**
     * Get Client Record by id in DataSource
     * type: positive
     */
    @Test
    public void getClientById() {
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(plan));
        assertNotNull(provider.getByID(Client.class,id).get());
    }

    /**
     * Get Client Record by id in DataSource
     * type: negative
     */
    @Test
    public void fgetClientById() {
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.singletonList(plan));
        assertNotEquals(id, provider.getByID(Client.class,id=-1L));
    }


}
