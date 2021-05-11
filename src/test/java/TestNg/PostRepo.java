package TestNg;

import Entity.Credentials;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Base64;


public class PostRepo extends Base {

    @Test()
    public void apiTest() throws IOException{
        HttpPost request = new HttpPost("https://github.com/user/repos");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token "+ Credentials.TOKEN);
        String json = "{\"name\":\"deleteMe\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);
        int getResponseCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(getResponseCode, 204);

    }
}
