package ru.sfedu.hibernatecoursezz.lab4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api.CompMapDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.api.ICompMapDP;
import ru.sfedu.hibernatecoursezz.lab4.componentCollectionMap.model.*;

import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CompMapDPTest {

    public ICompMapDP provider = new CompMapDP();
    public static Plan plan = new Plan();
    private Logger log = LogManager.getLogger(CompMapDPTest.class);


    /**
     * Update Client Record in DataSource
     * type: positive
     */
    @Test
    public void updateClient() {
        Plan planNew = new Plan();
        planNew.setName("New plan name");
        Map<String, Plan> plans = new HashMap<String, Plan>();
        plans.put("plan_key", planNew);
        Long id = provider.createClient("name","login", "password",plans);
        assertEquals(ResultType.COMPLETE,provider.updateClient(id," New name","login", " New password",plans));
    }

    /**
     * Update Client Record in DataSource
     * type: negative
     */
    @Test
    public void updateClientFail() {
        assertEquals(ResultType.FAIL,provider.updateClient(0,"name","login", "password",Collections.emptyMap()));
    }

    /**
     * Create Client Record in DataSource
     * type: positive
     */
    @Test
    public void createClient() {
        Plan planNew = new Plan();
        planNew.setName("New plan name");
        Map<String ,Plan> plans = new HashMap<String,Plan>();
        plans.put("plan_key",plan);
        Long id  = provider.createClient("Name","login","password", plans);
        Assertions.assertNotNull(id);
    }

    /**
     * Create Client Record in DataSource
     * type: negative
     */
    @Test
    public void createClientFail() {
        Long id  = provider.createClient("name","login", "password", Collections.emptyMap());
        assertNotNull(id);
    }

    /**
     * Delete Client Record in DataSource
     * type: positive
     */
    @Test
    public void deleteClient() {
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
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
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
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
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
        assertNotNull(provider.getByID(Client.class,id).get());
    }

    /**
     * Get Client Record by id in DataSource
     * type: negative
     */
    @Test
    public void fgetClientById() {
        plan.setName("Neww plan");
        Long id = provider.createClient("name","login", "password",Collections.emptyMap());
        assertNotEquals(id, provider.getByID(Client.class,id=-1L));
    }

}
