package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.luvva.wet.model.Preferences;

import javax.enterprise.inject.Default;
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
    private @Inject @Default Preferences preferences;

    @Produces
    public WetEventHandler produce ()
    {
        if (preferences.isTestMode())
        {
            return WeldContext.getInstance().getBean(HwTestEventHandler.class, new AnnotationLiteral<Custom>() {});
        }
        else
        {
            return WeldContext.getInstance().getBean(DefaultEventHandler.class, new AnnotationLiteral<Custom>() {});
        }
    }
}
