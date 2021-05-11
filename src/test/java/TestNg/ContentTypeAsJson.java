package TestNg;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ContentTypeAsJson extends Base {

    @Test()
    public void apiTest() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        ContentType contentType = ContentType.getOrDefault(response.getEntity());
        assertEquals(contentType.getMimeType(), "application/json");
    }
}
