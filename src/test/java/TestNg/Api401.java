package TestNg;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class Api401 extends Base{

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]{{"/user/keys"},
            {"/user/followers"},
            {"/user/keys"}
        };
    }

    @Test(dataProvider = "endpoints")
    public void apiTest(String endpoint) throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT + endpoint);
        response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode,401);
    }


}
