package br.com.luvva.wet.service.handler;

import br.com.jwheel.weld.WeldContext;
import br.com.jwheel.xml.model.FromXmlPreferences;
import br.com.luvva.wet.model.prefs.Preferences;
import org.slf4j.Logger;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

/**
 * A WetEventHandler that respects the enabled setting from {@link Preferences} and handles the events according to
 * some settings
 *
 * @param <T> the settings model
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
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
        return WeldContext.getInstance().getWithQualifiers(Preferences.class,
                new AnnotationLiteral<FromXmlPreferences>() {});
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
