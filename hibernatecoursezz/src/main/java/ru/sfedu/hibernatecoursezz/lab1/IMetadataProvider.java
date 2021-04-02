package ru.sfedu.hibernatecoursezz.lab1;

import java.util.List;

public interface IMetadataProvider {
    /**
     * getting the size of the schemata
     * @return result
     */
    List getSchema();

    /**
     * getting the size of the tables
     * @return result
     */
    List getTables();

    /**
     * getting the name of the database
     * @return result
     */
    List getSchemaName();

    /**
     * getting the user of the database
     * @return result
     */
    List getUser();
}
