package de.dhbw.databases;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.File;

public class DatabaseTestConfig {

    private static final String DATABASE_NAME = "test";
    private static final String INPUT_DATA =  "dbunit/data.xml";
    private static final String DATABASE_SCHEMA = "./dbunit/schema.sql";

    public DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(
                "jdbc:h2:mem:"+DATABASE_NAME+";" +
                "MODE=LEGACY;" +
                "DB_CLOSE_DELAY=-1;" +
                "INIT=runscript from '"+DATABASE_SCHEMA+"'");
        dataSource.setUser("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    public IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File(INPUT_DATA));
    }

    public DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.REFRESH;
    }

    public DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }

}
