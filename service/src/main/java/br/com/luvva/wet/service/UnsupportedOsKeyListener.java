package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
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
    public boolean startListening ()
    {
        logger.error("Unsupported operation system!");
        return false;
    }

    @Override
    public void stopListening ()
    {
    }
}
