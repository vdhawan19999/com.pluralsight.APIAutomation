package TestNg;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class Api200 extends Base {

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]{{"/rate_limit"},{"/events"},{""}
        };
    }

    @Test(dataProvider = "endpoints")
    public void apiTest(String endpoint) throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT + endpoint);
        response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode,200);
    }
}
