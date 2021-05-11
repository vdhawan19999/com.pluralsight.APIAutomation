package TestNg;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.Responseutils.getHeader;
import static org.testng.Assert.assertEquals;

public class GetHeader extends Base {

    @Test()
    public void apiTest() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        String headerValue = getHeader(response, "Server");

    }
}
