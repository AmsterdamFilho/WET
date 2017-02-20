package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.luvva.wet.model.Preferences;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.awt.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class DefaultEventHandler implements WetEventHandler
{
    private @Inject Logger logger;

    private RobotService robotService;

    @PostConstruct
    private void init ()
    {
        try
        {
            robotService = new RobotService(new Robot());
        }
        catch (AWTException e)
        {
            logger.error("Could not create a Robot!", e);
        }
    }

    @Override
    public void handleEventA ()
    {
        new PrivateHandlerA().handle();
    }

    @Override
    public void handleEventB ()
    {
        new PrivateHandlerB().handle();
    }

    @Override
    public void handleEventC ()
    {
        new PrivateHandlerC().handle();
    }

    protected RobotService getRobotService ()
    {
        return robotService;
    }

    protected Preferences readPreferences ()
    {
        return WeldContext.getInstance().getBean(Preferences.class, new AnnotationLiteral<Default>() {});
    }

    protected void handleEventA (Preferences preferences)
    {
    }

    protected void handleEventB (Preferences preferences)
    {
    }

    protected void handleEventC (Preferences preferences)
    {
    }

    /**
     * Checks if this EventHandler is currently able to handle events.
     *
     * @return a valid Preferences object if handle is enabled or null otherwise
     */
    protected Preferences canHandle ()
    {
        if (robotService != null)
        {
            Preferences preferences = readPreferences();
            if (preferences.isEnabled())
            {
                return preferences;
            }
        }
        return null;
    }

    private abstract class PrivateHandler
    {
        void handle ()
        {
            Preferences preferences = canHandle();
            if (preferences != null)
            {
                handleImpl(preferences);
            }
        }

        abstract void handleImpl (Preferences preferences);
    }

    private class PrivateHandlerA extends PrivateHandler
    {
        @Override
        void handleImpl (Preferences preferences)
        {
            handleEventA(preferences);
        }
    }

    private class PrivateHandlerB extends PrivateHandler
    {
        @Override
        void handleImpl (Preferences preferences)
        {
            handleEventB(preferences);
        }
    }

    private class PrivateHandlerC extends PrivateHandler
    {
        @Override
        void handleImpl (Preferences preferences)
        {
            handleEventC(preferences);
        }
    }
}
