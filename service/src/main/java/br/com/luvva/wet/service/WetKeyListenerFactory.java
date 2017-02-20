package br.com.luvva.wet.service;

import br.com.jwheel.core.service.cdi.WeldContext;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class WetKeyListenerFactory
{
    @Produces
    WetKeyListener produce ()
    {
        DefaultKeyListener defaultKeyListener = WeldContext.getInstance().getBean(DefaultKeyListener.class);
        if (defaultKeyListener.isOsSUpported())
        {
            return defaultKeyListener;
        }
        return WeldContext.getInstance().getBean(UnsupportedOsKeyListener.class);
    }
}
