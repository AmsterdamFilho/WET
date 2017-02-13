package br.com.luvva.wet.service;

import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.jwheel.javafx.utils.CdiEnabledFxmlLoader;
import br.com.jwheel.javafx.utils.JavaFxUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class HwTestApplication extends Application
{
    @Override
    public void start (Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new CdiEnabledFxmlLoader();
        MyResourceProvider resourceProvider = WeldContext.getInstance().getBean(MyResourceProvider.class);
        try
        {
            primaryStage.setScene(new Scene(fxmlLoader.load(resourceProvider.hwTestFxml())));
            primaryStage.setTitle("Wireless Event Trigger Hardware Test");
            JavaFxUtils.centerOnScreen(primaryStage);
            primaryStage.show();
        }
        catch (Exception ex)
        {
            WeldContext.getInstance().getBean(Logger.class).error("Can't load HwTestFxApplication!", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void stop () throws Exception
    {
        WeldContext.getInstance().getBean(WetService.class).stop();
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}
