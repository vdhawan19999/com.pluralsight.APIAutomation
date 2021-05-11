package TestNg;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class Base {
    public static final String BASE_ENDPOINT = "https://api.github.com";
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void before(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void after() throws IOException {
        client.close();
        response.close();
    }
}
