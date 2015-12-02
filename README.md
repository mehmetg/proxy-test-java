# proxy-test-java

Tests proxy configuration using java WebClient
Makes a simple REST API call to a status endpoint.
Prints out server response body to stdout.

##Setup:

* Execute ```mvn clean compile``` in the project root.

* Edit the lines below in the ProxyTest.java file to have your proxy information.

    ```public static final String proxyAddress = "localhost";```<br>
    ```public static final int proxyPort = 56193;``` 

##Run:

* Execute ```mvn exec:java``` in the project root.

##Expected results:

* During the tests you should always get a valid response.
* The first two test requests do not use the proxy and responses should be consistent with and without the proxy. 