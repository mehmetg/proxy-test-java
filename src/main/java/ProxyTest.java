import Models.StatusMessage;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.transports.http.configuration.ProxyServerType;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

/**
 * Created by mehmetgerceker on 12/1/15.
 */
public class ProxyTest {

    public static final String proxyAddress = "localhost";
    public static final int proxyPort = 56193;
    public static final String httpTarget = "http://saucelabs.com";
    public static final String httpsTarget = "https://saucelabs.com";
    public static final String apiEndPoint = "/rest/v1/info/status";
    public static void main(String[] args) {
        System.out.println("====================");
        System.out.println("Testing simple http:");
        getStatus(httpTarget, null, -1, null);
        System.out.println("====================");
        System.out.println("Testing simple https:");
        getStatus(httpsTarget, null, -1, null);
        System.out.println("====================");
        System.out.println("Testing simple http with http proxy:");
        getStatus(httpTarget, proxyAddress, proxyPort, ProxyServerType.HTTP);
        System.out.println("====================");
        System.out.println("Testing simple https with http proxy:");
        getStatus(httpsTarget, proxyAddress, proxyPort, ProxyServerType.HTTP);
    }
    public static void getStatus(String target, String proxy, int proxyPort, ProxyServerType proxyType){
        WebClient client = WebClient.create(target, Collections.singletonList(new JacksonJsonProvider()))
                .path(apiEndPoint).accept(MediaType.APPLICATION_JSON);
        if (proxy != null && proxyPort > 0) {
            HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
            HTTPClientPolicy policy = conduit.getClient();
            policy.setProxyServer(proxy);
            policy.setProxyServerPort(proxyPort);
            policy.setProxyServerType(proxyType);
        }
        StatusMessage statusMessage = client.get(StatusMessage.class);
        System.out.println(statusMessage);
    }
}
