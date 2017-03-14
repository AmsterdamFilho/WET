package br.com.luvva.wet.service;

import br.com.jwheel.cdi.WeldContext;
import br.com.jwheel.logging.JwLoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class Main
{
    private @Inject JwLoggerFactory jwLoggerFactory;

    @PostConstruct
    private void init ()
    {
        jwLoggerFactory.init();
        WeldContext.getInstance().getAny(WetService.class).start();
    }

    public static void main (String args[])
    {
        WeldContext.getInstance().getAny(Main.class);
    }
}
