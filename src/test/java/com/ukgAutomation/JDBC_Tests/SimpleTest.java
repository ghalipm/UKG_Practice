package com.ukgAutomation.JDBC_Tests;

import com.ukgAutomation.utilities.ConfigurationReader;
import com.ukgAutomation.utilities.DB_Utility;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    /**
     * Assuming that we captured the UI dashboard numbers from library1 app
     * Now we want to make sure those numbers match the database data
     */
    @Test
    public void testDashboardNumbers(){

        int userCountUI = 8553 ;
        int bookCountUI = 3493 ;
        int borrowedBookCountUI = 800 ;

        String url      = com.ukgAutomation.utilities.ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);
        DB_Utility.runQuery("SELECT count(*) FROM books")  ;

        String bookCountDB_Str =  DB_Utility.getFirstRowFirstColumn();
        int bookCountDB = Integer.parseInt(bookCountDB_Str) ;
        //assertEquals(expected, actual)
        assertEquals(bookCountUI, bookCountDB);

        System.out.println("actual book count from DB = " + bookCountDB);

        DB_Utility.destroy();

    }


}