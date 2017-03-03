package br.com.luvva.wet.service.handler;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;

import javax.enterprise.inject.Default;
import javax.enterprise.util.AnnotationLiteral;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public final class DefaultEventHandler extends RobotEventHandler<DefaultHandlerSettings>
{
    @Override
    protected void handleEventA (DefaultHandlerSettings settings)
    {
        settings.getRobotActionA().act(getRobot());
    }

    @Override
    protected void handleEventB (DefaultHandlerSettings settings)
    {
        settings.getRobotActionB().act(getRobot());
    }

    @Override
    protected void handleEventC (DefaultHandlerSettings settings)
    {
        settings.getRobotActionC().act(getRobot());
    }

    @Override
    protected DefaultHandlerSettings readSettings ()
    {
        return WeldContext.getInstance().getBean(DefaultHandlerSettings.class, new AnnotationLiteral<Default>() {});
    }
}
