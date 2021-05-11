package TestNg;

import Entity.Credentials;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Entity.Users.Login;
import static Utils.Responseutils.getUserName;


public class DeleteRepo extends Base {

    @Test()
    public void apiTest() throws IOException{
        HttpDelete request = new HttpDelete("https://github.com/vdhawan19999/deleteMe");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token "+ Credentials.TOKEN);
        response = client.execute(request);
        int getResponseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(getResponseCode, 204);

    }
}
