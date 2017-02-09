package br.com.luvva.wet.service;

import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.jwheel.core.service.java.SystemUtils;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class KeyListenerFactory
{
    @Produces
    KeyListener produce ()
    {
        if (SystemUtils.isWindows())
        {
            return WeldContext.getInstance().getBean(WindowsKeyListener.class);
        }
        return WeldContext.getInstance().getBean(UnsupportedOsKeyListener.class);
    }
}
