package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;

import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
@Singleton
public class HwTestEventHandler implements WetEventHandler
{
    @Override
    public void handleEventA ()
    {
        WeldContext.getInstance().getBean(HwTestController.class).handleEventA();
    }

    @Override
    public void handleEventB ()
    {
        WeldContext.getInstance().getBean(HwTestController.class).handleEventB();
    }

    @Override
    public void handleEventC ()
    {
        WeldContext.getInstance().getBean(HwTestController.class).handleEventC();
    }
}
