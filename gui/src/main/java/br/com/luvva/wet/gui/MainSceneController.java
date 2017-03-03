package br.com.luvva.wet.gui;

import br.com.luvva.wet.model.actions.RobotAction;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;
import br.com.luvva.wet.model.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class MainSceneController implements Initializable
{
    private @FXML Pane                   contentPane;
    private @FXML CheckBox               chkEnabled;
    private @FXML CheckBox               chkCustom;
    private @FXML MainSceneTabController tabAController;
    private @FXML MainSceneTabController tabBController;
    private @FXML MainSceneTabController tabCController;

    private @Inject MyResourceProvider resourceProvider;
    private @Inject MainSceneService   service;

    @Override
    public void initialize (URL location, ResourceBundle resources)
    {
        contentPane.getStylesheets().add(resourceProvider.getMainSceneCSS());

        tabAController.load(service, new ActionLoader()
        {
            @Override
            public RobotAction getAction (DefaultHandlerSettings settings)
            {
                return settings.getRobotActionA();
            }

            @Override
            public void setAction (DefaultHandlerSettings settings, RobotAction action)
            {
                settings.setRobotActionA(action);
            }
        });
        tabBController.load(service, new ActionLoader()
        {
            @Override
            public RobotAction getAction (DefaultHandlerSettings settings)
            {
                return settings.getRobotActionB();
            }

            @Override
            public void setAction (DefaultHandlerSettings settings, RobotAction action)
            {
                settings.setRobotActionB(action);
            }
        });
        tabCController.load(service, new ActionLoader()
        {
            @Override
            public RobotAction getAction (DefaultHandlerSettings settings)
            {
                return settings.getRobotActionC();
            }

            @Override
            public void setAction (DefaultHandlerSettings settings, RobotAction action)
            {
                settings.setRobotActionC(action);
            }
        });

        Preferences preferences = service.getPreferences();
        chkEnabled.selectedProperty().bindBidirectional(preferences.enabledProperty());
        chkEnabled.selectedProperty().addListener((observable, oldValue, newValue) -> service.persistPreferences());
        chkCustom.selectedProperty().bindBidirectional(preferences.useExtensionProperty());
        chkCustom.selectedProperty().addListener((observable, oldValue, newValue) -> service.persistPreferences());
    }

    public void exit ()
    {
        service.exit();
    }
}
