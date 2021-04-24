package mpl;

import lombok.Builder;
import okhttp3.Headers;
import sun.net.www.http.HttpClient;

@Builder
public class RESTUtil {
//    String host;
//    String uri;
//    HashMap<String, String> headers;
//    ServiceType serviceType;
//
//    public String Get(HashMap<String,String> queryParms, String pathParms){
//        HttpClient httpClient = new HttpClient();
//        httpClient.addHeaders(headers);
//        httpClient.setHost(this.serviceType.getUrl());
//        httpClient.setHost(this.uri);
//        return httpClient.get();
//    }


    /*
    String stringResponse = RESTUtil
            .Hearder(Headers)
            .host(ServiceType.CART)
            .urI()
            .Get(pathParms , queryParms);
     */

    /**
     *
     * int[] arr = {12,89,80,7,5,31,99,2,1}
     *
     * bynarySearch(array, 3, 0, array.length-1)
     *
     * int bynarySearch(int[] array, int key, int left, int right){
     *     int mid = left+right/2;
     *
     *     if(left>=right)
     *          return -1;
     *
     *      if(array[mid] < array[left])
     *          return bynarySearch(arry, key);
     * }
     *
     */


    /**
     * Employee Table
     * emp_id emp_name department salary
     *
     * Select second highest salary from department ‘Engg’
     *
     * SELECT salary
     * FROM
     * (
     *      SELECT salary
     *      FROM Employee
     *      WHERE department = 'Engg'
     *      ORDER BY salary DESC
     *      LIMIT 2
     * )
     * ORDER BY ASC
     * LIMIT 1;
     *
     */
}
