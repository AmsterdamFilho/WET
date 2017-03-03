package br.com.luvva.wet.service.handler;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.awt.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public abstract class RobotEventHandler<T> extends AbstractEventHandler<T>
{
    private         Robot  robot;
    private @Inject Logger logger;

    @PostConstruct
    private void init ()
    {
        try
        {
            robot = new Robot();
        }
        catch (AWTException e)
        {
            logger.error("Could not create a Robot!", e);
        }
    }

    protected Robot getRobot ()
    {
        return robot;
    }

    @Override
    public boolean initOk ()
    {
        return robot != null;
    }
}
