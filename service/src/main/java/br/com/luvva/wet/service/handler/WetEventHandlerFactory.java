package br.com.luvva.wet.service.handler;

import br.com.jwheel.cdi.WeldContext;
import br.com.luvva.wet.model.prefs.Preferences;
import org.slf4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class WetEventHandlerFactory
{
    private @Inject Preferences preferences;
    private @Inject Logger      logger;

    @Produces
    public WetEventHandler produce ()
    {
        if (preferences.isUseExtension())
        {
            try
            {
                return WeldContext.getInstance().getWithQualifiers(WetEventHandler.class, new
                        AnnotationLiteral<Extension>() {});
            }
            catch (Exception e)
            {
                logger.error("Could not instantiate extension!", e);
                return new DoomedToFailEventHandler();
            }
        }
        else
        {
            return WeldContext.getInstance().getAny(DefaultEventHandler.class);
        }
    }
}
