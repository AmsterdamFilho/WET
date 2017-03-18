package br.com.luvva.wet.service.handler;

import br.com.jwheel.weld.Custom;
import br.com.jwheel.weld.WeldContext;
import br.com.jwheel.xml.model.FromXmlPreferences;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;

import javax.enterprise.util.AnnotationLiteral;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class DefaultEventHandler extends RobotEventHandler<DefaultHandlerSettings>
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
        return WeldContext.getInstance().getWithQualifiers(DefaultHandlerSettings.class,
                new AnnotationLiteral<FromXmlPreferences>() {});
    }
}
