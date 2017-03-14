package br.com.luvva.wet.service.listener;

import br.com.jwheel.cdi.Custom;
import br.com.luvva.wet.service.handler.WetEventHandler;
import com.tulskiy.keymaster.common.Provider;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.swing.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class DefaultKeyListener implements WetKeyListener
{
    private @Inject Logger logger;

    private Provider provider;

    @Override
    public boolean startListening (WetEventHandler eventHandler)
    {
        try
        {
            provider = Provider.getCurrentProvider(false);
            provider.register(KeyStroke.getKeyStroke("control shift alt A"), hotKey -> eventHandler.handleEventA());
            provider.register(KeyStroke.getKeyStroke("control shift alt B"), hotKey -> eventHandler.handleEventB());
            provider.register(KeyStroke.getKeyStroke("control shift alt C"), hotKey -> eventHandler.handleEventC());
            return true;
        }
        catch (Exception e)
        {
            logger.error("Error configuring listener!", e);
            return false;
        }
    }

    @Override
    public void stopListening ()
    {
        if (provider != null)
        {
            provider.reset();
            provider.stop();
        }
    }

    boolean isOsSupported ()
    {
        return true;
    }
}
