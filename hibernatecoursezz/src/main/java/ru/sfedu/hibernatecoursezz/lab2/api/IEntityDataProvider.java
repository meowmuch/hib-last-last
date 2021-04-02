package ru.sfedu.hibernatecoursezz.lab2.api;

import ru.sfedu.hibernatecoursezz.lab2.model.NewEntity;
import ru.sfedu.hibernatecoursezz.lab2.model.TestEntity;
import ru.sfedu.hibernatecoursezz.utils.ResultType;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEntityDataProvider {
    /**
     * Creates Entity Record in DataSource
     * @param name name of record
     * @param description description of record
     * @param dateCreated dateCreated of record
     * @param check check of record
     * @param newEntity newEntity of record
     * @return result
     */
    public Long createEntity(String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);

    /**
     * Updates Entity Record in DataSource
     * @param id id of record
     * @param name new name of record
     * @param description new description of record
     * @param dateCreated new dateCreated of record
     * @param check new check of record
     * @param newEntity new newEntity of record
     * @return result
     */
    public ResultType updateEntity(Long id, String name, String description, Date dateCreated, Boolean check, NewEntity newEntity);

    /**
     * Updates Entity Record in DataSource
     * @param entity new record
     */
    public void update(TestEntity entity);

    /**
     * Delete Entity Record in DataSource
     * @param Id id of record
     * @return result
     */
    public ResultType delete(Long Id);

    /**
     * Retrieve Entity with given id
     * @param entity
     * @param id id of record
     * @return the entity by id
     */
    public Optional<TestEntity> getById(Class<TestEntity> entity, Long id);


    /**
     * Save new entity in the database
     * @param entity record
     * @return result
     */
    public Long save(TestEntity entity);
}
