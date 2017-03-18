package br.com.luvva.wet.service;

import br.com.jwheel.weld.WeldContext;

import javax.annotation.PostConstruct;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class Main
{
    @PostConstruct
    private void init ()
    {
        WeldContext.getInstance().getAny(WetService.class).start();
    }

    public static void main (String args[])
    {
        WeldContext.getInstance().getAny(Main.class);
    }
}
