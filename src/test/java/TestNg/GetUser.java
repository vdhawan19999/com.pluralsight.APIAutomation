package TestNg;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Entity.Users.Login;
import static Utils.Responseutils.getUserName;


public class GetUser extends Base {

    @Test()
    public void apiTest() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/ashish");
        response = client.execute(get);
        String jsoBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsoBody);
        String user = (String) getUserName(jsonObject, Login);
        Assert.assertEquals(user, "Ashish");
    }
}
