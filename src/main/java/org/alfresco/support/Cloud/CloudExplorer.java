package org.alfresco.support.Cloud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

public class CloudExplorer extends Application {

    private static Log logger = LogFactory.getLog(CloudExplorer.class);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log-config.properties");
        logger.debug("Starting application");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CloudExplorer.fxml"));
        primaryStage.setTitle("Alfresco Cloud Explorer");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
