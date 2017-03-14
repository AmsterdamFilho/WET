package br.com.luvva.wet.service.handler;

import br.com.jwheel.cdi.Custom;
import br.com.jwheel.cdi.WeldContext;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;

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
        return WeldContext.getInstance().getDefault(DefaultHandlerSettings.class);
    }
}
