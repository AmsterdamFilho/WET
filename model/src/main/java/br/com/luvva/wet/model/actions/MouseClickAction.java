package br.com.luvva.wet.model.actions;

import javafx.beans.property.SimpleIntegerProperty;

import java.awt.*;

import static java.awt.event.InputEvent.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class MouseClickAction implements RobotAction
{
    private int                   delay  = 200;
    private SimpleIntegerProperty button = new SimpleIntegerProperty(BUTTON3_DOWN_MASK);

    public int getDelay ()
    {
        return delay;
    }

    public void setDelay (int delay)
    {
        this.delay = delay;
    }

    public int getButton ()
    {
        return button.get();
    }

    public SimpleIntegerProperty buttonProperty ()
    {
        return button;
    }

    public void setButton (int button)
    {
        this.button.set(button);
    }

    @Override
    public void act (Robot robot)
    {
        int button = getButton();
        if (button == BUTTON1_DOWN_MASK || button == BUTTON2_DOWN_MASK || button == BUTTON3_DOWN_MASK)
        {
            robot.mousePress(button);
            robot.delay(delay);
            robot.mouseRelease(button);
        }
    }
}
