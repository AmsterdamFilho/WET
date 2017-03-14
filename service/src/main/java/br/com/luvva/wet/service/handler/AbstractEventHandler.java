package br.com.luvva.wet.service.handler;

import br.com.jwheel.cdi.WeldContext;
import br.com.luvva.wet.model.prefs.Preferences;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * A WetEventHandler that respects the enabled setting from {@link Preferences} and handles the events according to
 * some settings
 *
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 * @param <T> the settings model
 */
public abstract class AbstractEventHandler<T> implements WetEventHandler
{
    private @Inject Logger logger;

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

    private Preferences readPreferences ()
    {
        return WeldContext.getInstance().getDefault(Preferences.class);
    }

    private abstract class PrivateHandler
    {
        void handle ()
        {
            if (readPreferences().isEnabled())
            {
                handleImpl(readSettings());
            }
        }

        abstract void handleImpl (T settings);
    }

    private class PrivateHandlerA extends PrivateHandler
    {
        @Override
        void handleImpl (T settings)
        {
            logger.info("Handling event A");
            handleEventA(settings);
        }
    }

    private class PrivateHandlerB extends PrivateHandler
    {
        @Override
        void handleImpl (T settings)
        {
            logger.info("Handling event B");
            handleEventB(settings);
        }
    }

    private class PrivateHandlerC extends PrivateHandler
    {
        @Override
        void handleImpl (T settings)
        {
            logger.info("Handling event C");
            handleEventC(settings);
        }
    }

    protected abstract void handleEventA (T settings);

    protected abstract void handleEventB (T settings);

    protected abstract void handleEventC (T settings);

    protected abstract T readSettings ();
}
