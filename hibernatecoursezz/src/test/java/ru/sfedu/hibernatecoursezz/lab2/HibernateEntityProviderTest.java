package ru.sfedu.hibernatecoursezz.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.hibernatecoursezz.lab2.api.HibernateEntityProvider;
import ru.sfedu.hibernatecoursezz.lab2.api.IEntityDataProvider;
import ru.sfedu.hibernatecoursezz.lab2.model.NewEntity;
import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;

public class HibernateEntityProviderTest {

    private Logger log = LogManager.getLogger(HibernateEntityProviderTest.class);
    public HibernateEntityProviderTest(){};

    /**
     * Creates Entity Record in DataSource
     * type: positive
     */
    @Test
    public void createEntitySuccess(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setName("name");
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertEquals(expected,testEntity);
    }

    /**
     * Creates Entity Record in DataSource
     * type: negative
     */
    @Test
    public void createEntityFalse(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertNotEquals(expected,testEntity);
    }

    /**
     * Delete Entity Record in DataSource
     * type: positive
     */
    @Test
    public void deleteTest(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setName("name");
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertEquals(ResultType.COMPLETE,provider.delete(id));
    }

    /**
     * Delete Entity Record in DataSource
     * type: negative
     */
    @Test
    public void deleteTestFail(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        assertEquals(ResultType.FAIL,provider.delete(-1L));
    }

    /**
     * Update Entity Record in DataSource
     * type: positive
     */
    @Test
    public void updateSuccess(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New name");
        newEntity.setDescription("New Description");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertEquals(ResultType.COMPLETE,provider.updateEntity(id,"name","new description",date,true,newEntity));
        assertEquals("new description",provider.getById(TestEntity.class,id).get().getDescription());
    }

    /**
     * Update Entity Record in DataSource
     * type: negative
     */
    @Test
    public void updateFail(){
        IEntityDataProvider provider = new HibernateEntityProvider();
        Date date = new Date();
        assertEquals(ResultType.FAIL,provider.updateEntity(-1L,"name","new description",date,true,null));
    }

    /**
     * Get Entity Record bu id in DataSource
     * type: positive
     */
    @Test
    public void getByIdSuccess() {
        System.out.println("getById");
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setName("name");
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertEquals(expected,testEntity);
        log.info(provider.getById(TestEntity.class, id));
    }

    /**
     * Get Entity Record bu id in DataSource
     * type: negative
     */
    @Test
    public void getByIdFail() {
        System.out.println("getById");
        IEntityDataProvider provider = new HibernateEntityProvider();
        NewEntity newEntity = new NewEntity();
        newEntity.setName("New N");
        newEntity.setDescription("New D");
        newEntity.setCollection(Arrays.asList("First","Second"));
        Date date = new Date();
        Long id = provider.createEntity("name","description",date,true,newEntity);
        assertNotNull(id);
        TestEntity testEntity = new TestEntity();
        testEntity = provider.getById(TestEntity.class,id).get();
        TestEntity expected = new TestEntity();
        expected.setId(id);
        expected.setName("name");
        expected.setDescription("description");
        expected.setDateCreated(date);
        expected.setChecking(true);
        expected.setNewEntity(newEntity);
        assertEquals(expected,testEntity);
        log.info(provider.getById(TestEntity.class, id=-1L));
        assertNotEquals(expected, provider.getById(TestEntity.class,id=-1L));
    }


}
