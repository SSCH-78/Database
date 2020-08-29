import databaseconnection.DataConsumer;
import databaseconnection.DatabaseConnect;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbTest {
    DataConsumer dbconnect1 = new DataConsumer();

    @Test
    public void compare() throws IOException, SQLException {

        List listFromDvd = new ArrayList<String>();
        List<String> listFromPractice = new ArrayList<String>();

       listFromDvd= dbconnect1.getActorsFirstNameFromDvd();
       listFromPractice= dbconnect1.getActorsFirstNameFromPrac();

        for(int i=0;i<listFromDvd.size();i++)
        {
            Assert.assertEquals(listFromDvd.get(i),listFromPractice.get(i));
        }
    }
}
