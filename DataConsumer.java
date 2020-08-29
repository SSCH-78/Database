package databaseconnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;

public class DataConsumer {
    static DatabaseConnect dbconnect;

    static {
        try {
            dbconnect = new DatabaseConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        getActorsFirstNameFromDvd();
        getActorsFirstNameFromPrac();

    }

    public static List getActorsFirstNameFromDvd() throws IOException, SQLException {
        String query = "SELECT first_name FROM public.actor limit 5";

        ResultSet resultSet = dbconnect.executeSelectQuery(query);

        List<String> actorsFirstNameListFromDB = new ArrayList<String>();

        while (resultSet.next()){
            actorsFirstNameListFromDB.add(resultSet.getString("first_name"));
        }
        System.out.println("****From dvdrental****");
       actorsFirstNameListFromDB.forEach(str-> System.out.println(str));

        return actorsFirstNameListFromDB;
    }

    public static List getActorsFirstNameFromPrac() throws SQLException, IOException{
        String query = "SELECT first_name FROM public.actor limit 5";

        ResultSet resultSet = dbconnect.executeSelectQuery(query);

        List<String> actorsFirstNameListFromPrac = new ArrayList<String>();

        while (resultSet.next()){
            actorsFirstNameListFromPrac.add(resultSet.getString("first_name"));
        }
        System.out.println("****From practice db****");
        actorsFirstNameListFromPrac.forEach(str-> System.out.println(str));

        return actorsFirstNameListFromPrac;
    }



}
