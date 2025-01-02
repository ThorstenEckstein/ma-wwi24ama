package de.dhbw.databases;

import de.dhbw.databases.demo.Client;
import de.dhbw.databases.demo.Item;
import de.dhbw.databases.demo.ObjectRelationalMapper;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Tuo use the H2 shell from CLI, type:
 * (path-to-jar: /Users/thorsteneckstein/.m2/repository/com/h2database/h2/2.1.214/h2-2.1.214.jar)
 *   java -cp <path-to-jar> org.h2.tools.Shell
 * followed by some inputs:
 *   [Enter]   jdbc:h2:~/test
 *   URL       jdbc:h2:mem:default
 *
 *   [Enter]   org.h2.Driver
 *   Driver
 *
 *   [Enter]
 *   User
 *   Password
 *   Type the same password again to confirm database creation.
 *   Password
 * Connected
 */

@RunWith(JUnit4.class)
public class DataSourceDBUnitTests extends DataSourceBasedDBTestCase {

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

    @Test
    public void canSetupDatabaseCorrectlyUsingSchema() throws Exception {
        // given
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("CLIENTS");

        // when
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("CLIENTS");

        // then
        assertEquals(
                expectedTable.getTableMetaData().getTableName(),
                actualTable.getTableMetaData().getTableName());

    }

    @DisplayName("Select items from database")
    @Test
    public void canLoadAllItems() throws Exception {
        // given -  already setup database connection, see above

        // when
        ResultSet rs = connection.createStatement().executeQuery("select * from ITEMS");
        List<Item> items = new LinkedList<>();
        while(rs.next()) {
            Item item = ObjectRelationalMapper.toItem(rs);
            items.add(item);
        }

        // then
        assertEquals(5,items.size());

        // dump
        System.out.println(items);
    }

    @DisplayName("Count number of entries in database table")
    @Test
    public void canCountTableEntries() throws Exception {
        // given -  already setup database connection, see above

        // when
        int itemsCount = count(1,"ITEMS");
        int clientsCount = count(2,"CLIENTS");

        // then
        assertEquals(5, itemsCount);
        assertEquals(1, clientsCount);
    }

    @DisplayName("Insert client into database")
    @Test
    public void canSaveClient() throws Exception {
        // given -  already setup database connection, see above

        // when - insert and ...
        connection.createStatement().executeUpdate(
                "INSERT INTO CLIENTS (first_name, last_name) VALUES ('John', 'Jansen')");

        // directly fetch (select) the new data
        ResultSet rs = connection.createStatement().executeQuery(
                "select * from CLIENTS where last_name = 'Jansen'");

        // then
        assertTrue(rs.next());
        Client client = ObjectRelationalMapper.toClient(rs);

        assertEquals("Jansen", client.getLastName());

        // dump to see full data
        System.out.println(client);
    }

    @DisplayName("Update existing client in database")
    @Test
    public void canUpdateClient() throws Exception {
        // given -  already setup database connection, see above

        // when - insert and ...
        connection.createStatement().executeUpdate("update CLIENTS set last_name='Darwin' where id = 1");

        // directly fetch (select) the new data
        ResultSet rs = connection.createStatement().executeQuery("select * from CLIENTS where last_name = 'Darwin'");

        // then
        assertTrue(rs.next());
        Client client = ObjectRelationalMapper.toClient(rs);

        assertEquals("Charles Darwin", client.getFirstName() + " " + client.getLastName());

        // dump to see full data
        System.out.println(client);
    }

    @DisplayName("Delete item from database")
    @Test
    public void canDeleteItem() throws Exception {
        // given -  already setup database connection, see above

        // when - insert and ...
        int before = count(1, "ITEMS");
        connection.createStatement().executeUpdate("delete from ITEMS where title = 'Backpack'");
        int after = count(2, "ITEMS");

        // then
        assertEquals(5, before);
        assertEquals(4, after);
    }

    // -------------------------------------- private methods, should be moved to separate helper class

    private int count(int version, String tableName) throws Exception {
        if (version == 1) {
            return countV1(tableName);
        } else if(version == 2) {
            return countV2(tableName);
        } else {
            throw new IllegalArgumentException("Unsupported version: " + version);
        }
    }

    private int countV1(String tableName) throws SQLException {
        ResultSet rs = connection.createStatement().executeQuery("select count(*) from " + tableName);
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    private int countV2(String tableName) throws Exception {
        IDataSet databaseDataSet = getConnection().createDataSet();
        return databaseDataSet.getTable(tableName).getRowCount();
    }

}