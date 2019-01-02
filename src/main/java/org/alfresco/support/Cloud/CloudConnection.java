package org.alfresco.support.Cloud;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CloudConnection
{
    private static Log logger = LogFactory.getLog(CloudConnection.class);

    private static String LOGON_URL ="https://my.alfresco.com/share/-default-/page/dologin";
    private static String charset = "UTF-8";
    private static String domain = "";

    public static void logon(String username, String password) throws IOException
    {
        logger.debug("STarting logon");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(LOGON_URL);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", username));
        nvps.add(new BasicNameValuePair("password", password));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try
        {
            logger.debug("Login Response: " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 303)
            {
                logger.debug(EntityUtils.toString(entity));
            }
            // do something useful with the response body
            // and ensure it is fully consumed

            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
    }
}
