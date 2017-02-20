package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;
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
    private @Inject Logger          logger;
    private @Inject WetEventHandler eventHandler;

    private Provider provider;

    @Override
    public boolean startListening ()
    {
        try
        {
            provider = Provider.getCurrentProvider(false);
            provider.register(KeyStroke.getKeyStroke("control shift alt A"), hotKey -> eventHandler.handleEventA());
            provider.register(KeyStroke.getKeyStroke("control shift alt B"), hotKey -> eventHandler.handleEventB());
            provider.register(KeyStroke.getKeyStroke("control shift alt C"), hotKey -> eventHandler.handleEventC());
            provider.register(KeyStroke.getKeyStroke("control shift alt ESCAPE"), hotKey -> WeldContext.getInstance()
                    .getBean(WetService.class).stop());
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

    public boolean isOsSUpported ()
    {
        return true;
    }
}
