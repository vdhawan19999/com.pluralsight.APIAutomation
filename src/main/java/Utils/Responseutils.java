package Utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Responseutils {

    public static String getHeader(CloseableHttpResponse response, final String headerName) {
        final Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        Header matchHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didn't find the header"));
        return matchHeader.getValue();
    }

    public static Object getUserName(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}

