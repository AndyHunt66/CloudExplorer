package org.alfresco.support.Cloud;

import javafx.event.ActionEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class Controller {
    private static Log logger = LogFactory.getLog(Controller.class);
    public void logon(ActionEvent actionEvent)
    {
        try
        {
            CloudConnection.logon("bob", "bob");
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent)
    {
        System.exit(0);
    }
}
