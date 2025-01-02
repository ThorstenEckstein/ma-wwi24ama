package de.dhbw.databases.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import static de.dhbw.databases.demo.ObjectRelationalMapper.Columns.lc;

public class ObjectRelationalMapper {
    public enum Columns {
        // generic columns
        Id,
        // Item columns
        Title,Produced,Price,
        // client columns
        First_name,Last_Name
        ;

        public static String lc(Columns column) {
            return column.name().toLowerCase();
        }
    }

    public static Client toClient(ResultSet rs) throws SQLException {
        Client client= new Client();
        client.setId(rs.getLong(lc(Columns.Id)));
        client.setFirstName(rs.getString(lc(Columns.First_name)));
        client.setLastName(rs.getString(lc(Columns.Last_Name)));
        return client;
    }

    public static Item toItem(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong(lc(Columns.Id)));
        item.setTitle(rs.getString((lc(Columns.Title))));
        item.setProduced(rs.getDate((lc(Columns.Produced))));
        item.setPrice(rs.getFloat((lc(Columns.Price))));
        return item;
    }

}
