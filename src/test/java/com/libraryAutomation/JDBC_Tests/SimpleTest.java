package com.libraryAutomation.JDBC_Tests;

import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.DB_Utility;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    /**
     * Assuming that we captured the UI dashboard numbers from library1 app
     * Now we want to makes sure those numbers match the database data
     */
    @Test
    public void testDashboardNumbers(){

        int userCountUI = 8553 ;
        int bookCountUI = 2015 ;
        int borrowedBookCountUI = 800 ;

        String url      = com.libraryAutomation.utilities.ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(url, username, password);
        DB_Utility.runQuery("SELECT count(*) FROM books")  ;

        String bookCountDB_Str =  DB_Utility.getFirstRowFirstColumn();
        int bookCountDB = Integer.parseInt(bookCountDB_Str) ;

        assertEquals(bookCountDB, bookCountUI );


        DB_Utility.destroy();

    }


}