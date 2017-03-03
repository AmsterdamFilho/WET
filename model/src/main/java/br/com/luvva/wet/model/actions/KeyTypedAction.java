package br.com.luvva.wet.model.actions;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class KeyTypedAction implements RobotAction
{
    private SimpleStringProperty  keyStroke = new SimpleStringProperty("");
    private SimpleBooleanProperty alt       = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty ctrl      = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty shift     = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty meta      = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty altGraph  = new SimpleBooleanProperty(false);

    public String getKeyStroke ()
    {
        return keyStroke.get();
    }

    public SimpleStringProperty keyStrokeProperty ()
    {
        return keyStroke;
    }

    public void setKeyStroke (String keyStroke)
    {
        this.keyStroke.set(keyStroke);
    }

    public boolean isAlt ()
    {
        return alt.get();
    }

    public SimpleBooleanProperty altProperty ()
    {
        return alt;
    }

    public void setAlt (boolean alt)
    {
        this.alt.set(alt);
    }

    public boolean isCtrl ()
    {
        return ctrl.get();
    }

    public SimpleBooleanProperty ctrlProperty ()
    {
        return ctrl;
    }

    public void setCtrl (boolean ctrl)
    {
        this.ctrl.set(ctrl);
    }

    public boolean isShift ()
    {
        return shift.get();
    }

    public SimpleBooleanProperty shiftProperty ()
    {
        return shift;
    }

    public void setShift (boolean shift)
    {
        this.shift.set(shift);
    }

    public boolean isMeta ()
    {
        return meta.get();
    }

    public SimpleBooleanProperty metaProperty ()
    {
        return meta;
    }

    public void setMeta (boolean meta)
    {
        this.meta.set(meta);
    }

    public boolean isAltGraph ()
    {
        return altGraph.get();
    }

    public SimpleBooleanProperty altGraphProperty ()
    {
        return altGraph;
    }

    public void setAltGraph (boolean altGraph)
    {
        this.altGraph.set(altGraph);
    }

    @Override
    public void act (Robot robot)
    {
        KeyStroke keyStrokeObject = KeyStroke.getKeyStroke(getKeyStroke());
        if (keyStrokeObject != null)
        {
            modifierKeyPress(robot);
            robot.keyPress(keyStrokeObject.getKeyCode());
            robot.keyRelease(keyStrokeObject.getKeyCode());
            modifierKeyRelease(robot);
        }
    }

    private void modifierKeyPress (Robot robot)
    {
        if (isAlt())
        {
            robot.keyPress(KeyEvent.VK_ALT);
        }
        if (isAltGraph())
        {
            robot.keyPress(KeyEvent.VK_ALT_GRAPH);
        }
        if (isCtrl())
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
        }
        if (isMeta())
        {
            robot.keyPress(KeyEvent.VK_META);
        }
        if (isShift())
        {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }
    }

    private void modifierKeyRelease (Robot robot)
    {
        if (isAlt())
        {
            robot.keyRelease(KeyEvent.VK_ALT);
        }
        if (isAltGraph())
        {
            robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
        }
        if (isCtrl())
        {
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        if (isMeta())
        {
            robot.keyRelease(KeyEvent.VK_META);
        }
        if (isShift())
        {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
