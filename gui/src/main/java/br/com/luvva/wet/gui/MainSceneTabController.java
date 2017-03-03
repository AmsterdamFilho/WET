package br.com.luvva.wet.gui;

import br.com.luvva.wet.model.actions.EmptyAction;
import br.com.luvva.wet.model.actions.KeyTypedAction;
import br.com.luvva.wet.model.actions.MouseClickAction;
import br.com.luvva.wet.model.actions.RobotAction;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import javax.inject.Inject;
import java.awt.event.InputEvent;
import java.util.Objects;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class MainSceneTabController
{
    private @FXML RadioButton      rdbNone;
    private @FXML RadioButton      rdbMouse;
    private @FXML RadioButton      rdbKeyboard;
    private @FXML ComboBox<String> cmbMouseButton;
    private @FXML TextField        txtKeyBoard;
    private @FXML CheckBox         chkAlt;
    private @FXML CheckBox         chkCtrl;
    private @FXML CheckBox         chkShift;
    private @FXML CheckBox         chkAltGraph;
    private @FXML CheckBox         chkMeta;

    private @FXML   ToggleGroup        tggAction;
    private @Inject MyResourceProvider resourceProvider;

    private EmptyAction      emptyAction      = new EmptyAction();
    private MouseClickAction mouseClickAction = new MouseClickAction();
    private KeyTypedAction   keyTypedAction   = new KeyTypedAction();

    void load (MainSceneService service, ActionLoader actionLoader)
    {
        loadCurrentAction(actionLoader.getAction(service.getSettings()));

        tggAction.selectedToggleProperty().addListener((obs, old, newValue) -> actionChanged(service, actionLoader));

        cmbMouseButton.setItems(FXCollections.observableArrayList(
                resourceProvider.getI18nProperty(MyResourceProvider.LEFT_MOUSE_BUTTON),
                resourceProvider.getI18nProperty(MyResourceProvider.MIDDLE_MOUSE_BUTTON),
                resourceProvider.getI18nProperty(MyResourceProvider.RIGHT_MOUSE_BUTTON)));
        Bindings.bindBidirectional(cmbMouseButton.valueProperty(), mouseClickAction.buttonProperty(), new
                MouseButtonConverter());
        cmbMouseButton.valueProperty().addListener((observable, oldValue, newValue) -> service.persistSettings());
        cmbMouseButton.disableProperty().bind(rdbMouse.selectedProperty().not());

        txtKeyBoard.textProperty().bindBidirectional(keyTypedAction.keyStrokeProperty());
        txtKeyBoard.textProperty().addListener((observable, oldValue, newValue) -> service.persistSettings());
        txtKeyBoard.editableProperty().bind(rdbKeyboard.selectedProperty());

        ChangeListener<Boolean> booleanChangeListener = (observable, oldValue, newValue) -> service.persistSettings();
        chkAlt.selectedProperty().bindBidirectional(keyTypedAction.altProperty());
        chkAlt.selectedProperty().addListener(booleanChangeListener);
        chkAlt.disableProperty().bind(rdbKeyboard.selectedProperty().not());

        chkAltGraph.selectedProperty().bindBidirectional(keyTypedAction.altGraphProperty());
        chkAltGraph.selectedProperty().addListener(booleanChangeListener);
        chkAltGraph.disableProperty().bind(rdbKeyboard.selectedProperty().not());

        chkCtrl.selectedProperty().bindBidirectional(keyTypedAction.ctrlProperty());
        chkCtrl.selectedProperty().addListener(booleanChangeListener);
        chkCtrl.disableProperty().bind(rdbKeyboard.selectedProperty().not());

        chkMeta.selectedProperty().bindBidirectional(keyTypedAction.metaProperty());
        chkMeta.selectedProperty().addListener(booleanChangeListener);
        chkMeta.disableProperty().bind(rdbKeyboard.selectedProperty().not());

        chkShift.selectedProperty().bindBidirectional(keyTypedAction.shiftProperty());
        chkShift.selectedProperty().addListener(booleanChangeListener);
        chkShift.disableProperty().bind(rdbKeyboard.selectedProperty().not());
    }

    private void actionChanged (MainSceneService service, ActionLoader actionLoader)
    {
        RobotAction action = null;
        if (rdbNone.isSelected())
        {
            action = emptyAction;
        }
        else if (rdbMouse.isSelected())
        {
            action = mouseClickAction;
        }
        else if (rdbKeyboard.isSelected())
        {
            action = keyTypedAction;
        }
        actionLoader.setAction(service.getSettings(), action);
        service.persistSettings();
    }

    private void loadCurrentAction (RobotAction action)
    {
        if (action instanceof MouseClickAction)
        {
            mouseClickAction = (MouseClickAction) action;
            rdbMouse.setSelected(true);
        }
        else if (action instanceof KeyTypedAction)
        {
            keyTypedAction = (KeyTypedAction) action;
            rdbKeyboard.setSelected(true);
        }
        else
        {
            rdbNone.setSelected(true);
        }
    }

    private class MouseButtonConverter extends StringConverter<Number>
    {
        @Override
        public String toString (Number object)
        {
            if (Objects.equals(InputEvent.BUTTON3_DOWN_MASK, object))
            {
                return resourceProvider.getI18nProperty(MyResourceProvider.RIGHT_MOUSE_BUTTON);
            }
            if (Objects.equals(InputEvent.BUTTON2_DOWN_MASK, object))
            {
                return resourceProvider.getI18nProperty(MyResourceProvider.MIDDLE_MOUSE_BUTTON);
            }
            if (Objects.equals(InputEvent.BUTTON1_DOWN_MASK, object))
            {
                return resourceProvider.getI18nProperty(MyResourceProvider.LEFT_MOUSE_BUTTON);
            }
            return null;
        }

        @Override
        public Number fromString (String string)
        {
            if (resourceProvider.getI18nProperty(MyResourceProvider.LEFT_MOUSE_BUTTON).equals(string))
            {
                return InputEvent.BUTTON1_DOWN_MASK;
            }
            if (resourceProvider.getI18nProperty(MyResourceProvider.MIDDLE_MOUSE_BUTTON).equals(string))
            {
                return InputEvent.BUTTON2_DOWN_MASK;
            }
            if (resourceProvider.getI18nProperty(MyResourceProvider.RIGHT_MOUSE_BUTTON).equals(string))
            {
                return InputEvent.BUTTON3_DOWN_MASK;
            }
            return 0;
        }
    }
}
