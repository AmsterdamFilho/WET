package br.com.luvva.wet.service.handler;

import br.com.jwheel.cdi.Custom;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class DoomedToFailEventHandler implements WetEventHandler
{
    @Override
    public void handleEventA ()
    {

    }

    @Override
    public void handleEventB ()
    {

    }

    @Override
    public void handleEventC ()
    {

    }

    @Override
    public boolean initOk ()
    {
        return false;
    }
}
