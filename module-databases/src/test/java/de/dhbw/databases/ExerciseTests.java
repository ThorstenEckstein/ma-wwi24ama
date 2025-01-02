package de.dhbw.databases;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(JUnit4.class)
public class ExerciseTests extends DataSourceBasedDBTestCase {

    private Connection connection;

    // helper class
    DatabaseTestConfig setup = new DatabaseTestConfig();

    @Override
    protected DataSource getDataSource() { return setup.getDataSource(); }
    @Override
    protected IDataSet getDataSet() throws Exception { return setup.getDataSet(); }
    @Override
    protected DatabaseOperation getSetUpOperation() {
        return setup.getSetUpOperation();
    }
    @Override
    protected DatabaseOperation getTearDownOperation() {
        return setup.getTearDownOperation();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        connection = getConnection().getConnection();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @DisplayName(
        """
        Erzeuge eine neue Tabelle 'ORDERS' in der Datenbank.
        Die Tabelle soll die Spalten bekommen:
        - 'id' als Ganzzahl
        - 'orderNumber' als String
        """
    )
    @Test
    public void canCreateTable() throws Exception {
        // given

        // when

        // then
    }

    @DisplayName(
        """
        Erzeuge in der Tabelle 'ORDERS' einen neuen Datensatz mit beliebigen Daten an
        """
    )
    @Test
    public void canInsertDataIntoTable() throws Exception {
        // given

        // when

        // then
    }

}