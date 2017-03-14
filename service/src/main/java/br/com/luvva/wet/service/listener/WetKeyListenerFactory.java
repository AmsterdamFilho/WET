package br.com.luvva.wet.service.listener;

import br.com.jwheel.cdi.WeldContext;

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
        DefaultKeyListener defaultKeyListener = WeldContext.getInstance().getAny(DefaultKeyListener.class);
        if (defaultKeyListener.isOsSupported())
        {
            return defaultKeyListener;
        }
        return WeldContext.getInstance().getAny(UnsupportedOsKeyListener.class);
    }
}
