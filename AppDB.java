package databaseconnection;

import java.io.IOException;
import java.sql.SQLException;


public class AppDB {

    public static void main(String[] args) throws SQLException, IOException {

        DatabaseConnect connect = new DatabaseConnect();
        DataConsumer dbconnect1 = new DataConsumer();
        dbconnect1.getActorsFirstNameFromDvd();
        dbconnect1.getActorsFirstNameFromPrac();


    }
}
