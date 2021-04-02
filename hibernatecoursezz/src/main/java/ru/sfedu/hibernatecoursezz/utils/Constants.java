package ru.sfedu.hibernatecoursezz.utils;

import java.util.Arrays;
import java.util.HashSet;

public class Constants {

    public static final String FEW_ARGUMENTS = "Too few arguments were given...";

    //lab1
    public static final String PATH_TO_CFG_XML_LAB1 = "./src/main/java/ru/sfedu/hibernatecoursezz/lab1/utils/hibernate.cfg.xml";

    public static final String SCHEMA = "SELECT schema_name FROM information_schema.schemata";
    public static final String TABLE = "Select pg_size_pretty(pg_database_size(datname)) from pg_database";
    public static final String NAME = "SELECT current_catalog";
    public static final String USER = "SELECT current_user";

    //lab2
    public static final String PATH_TO_CFG_XML_LAB2 = "./src/main/java/ru/sfedu/hibernatecoursezz/lab2/utils/hibernate.cfg.xml";

    //lab3
    public static final String PATH_TO_CFG_XML_LAB3_MS = "./src/main/java/ru/sfedu/hibernatecoursezz/lab3/MappedSuperclass/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB3_TPC = "./src/main/java/ru/sfedu/hibernatecoursezz/lab3/TablePerClass/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB_3_JT = "./src/main/java/ru/sfedu/hibernatecoursezz/lab3/JoinedTable/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB3_ST = "./src/main/java/ru/sfedu/hibernatecoursezz/lab3/SingleTable/utils/hibernate.cfg.xml";

    //lab4
    public static final String PATH_TO_CFG_XML_LAB4_S = "./src/main/java/ru/sfedu/hibernatecoursezz/lab4/setCollection/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB4_M = "./src/main/java/ru/sfedu/hibernatecoursezz/lab4/mapCollection/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB4_L = "./src/main/java/ru/sfedu/hibernatecoursezz/lab4/listCollection/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB4_Comp = "./src/main/java/ru/sfedu/hibernatecoursezz/lab4/componentCollection/utils/hibernate.cfg.xml";
    public static final String PATH_TO_CFG_XML_LAB4_CompM = "./src/main/java/ru/sfedu/hibernatecoursezz/lab4/componentCollectionMap/utils/hibernate.cfg.xml";

    //lab5
    public static final String PATH_TO_CFG_XML_LAB5 = "./src/main/java/ru/sfedu/hibernatecoursezz/lab5/utils/hibernate.cfg.xml";

    public static final String QUERY = "FROM %s";
    public static final String POSTGRES = "POSTGRESQL";
    public static final String PATH_TO_CFG_XML = "./src/main/resources/hibernate.cfg.xml";
    public static final String CLIENT = "Client";
    public static final String COUNT = "select count(*) from %s";
    public static final String TIME_TAKEN = "Time: %ss";
    public static final String NO_ARGS = "No arguments were given";
    public static final String BAD_ARG = "Bad Argument was given";

}
