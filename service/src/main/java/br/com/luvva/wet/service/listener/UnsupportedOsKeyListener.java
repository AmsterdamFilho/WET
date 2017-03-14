package br.com.luvva.wet.service.listener;

import br.com.jwheel.cdi.Custom;
import br.com.luvva.wet.service.handler.WetEventHandler;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class UnsupportedOsKeyListener implements WetKeyListener
{
    private @Inject Logger logger;

    @Override
    public boolean startListening (WetEventHandler eventHandler)
    {
        logger.error("Unsupported operation system!");
        return false;
    }

    @Override
    public void stopListening ()
    {
    }
}
