package br.com.luvva.wet.service;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class HwTestController
{
    private @FXML ListView<String> expectedEventsRecord;
    private @FXML ListView<String> otherEventsRecord;

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    void handleEventA ()
    {
        handleEvent("A");
    }

    void handleEventB ()
    {
        handleEvent("B");
    }

    void handleEventC ()
    {
        handleEvent("C");
    }

    private void handleEvent (String type)
    {
        expectedEventsRecord.getItems().add(sdf.format(new Date()) + " — " + type);
    }

    void handleUnregisteredEvent (String event)
    {
        otherEventsRecord.getItems().add(event);
    }

    public void clearExpectedEvents ()
    {
        expectedEventsRecord.getItems().clear();
    }

    public void clearOtherEvents ()
    {
        otherEventsRecord.getItems().clear();
    }
}
