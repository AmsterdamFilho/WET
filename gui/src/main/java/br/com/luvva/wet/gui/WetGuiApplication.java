package br.com.luvva.wet.gui;

import br.com.jwheel.javafx.utils.JwFxmlLoader;
import br.com.jwheel.template.control.JavaFxApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class WetGuiApplication extends JavaFxApplication
{
    private @Inject MyResourceProvider resourceProvider;
    private @Inject Logger             logger;

    @Override
    public boolean databaseConnectionOk ()
    {
        return true;
    }

    @Override
    public void init (Stage primaryStage)
    {
        try
        {
            Stage newPrimaryStage = new Stage();
            newPrimaryStage.setScene(new Scene(JwFxmlLoader.loadWithCdi(resourceProvider.mainSceneFxml(),
                    resourceProvider.getI18nBundle())));
            newPrimaryStage.centerOnScreen();

            primaryStage.close();
            newPrimaryStage.setResizable(false);
            newPrimaryStage.show();
        }
        catch (Exception ex)
        {
            logger.error("Can't load WetGuiApplication!", ex);
            primaryStage.close();
        }
    }
}
