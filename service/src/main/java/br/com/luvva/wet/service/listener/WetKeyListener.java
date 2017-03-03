package br.com.luvva.wet.service.listener;

import br.com.luvva.wet.service.handler.WetEventHandler;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public interface WetKeyListener
{
    boolean startListening (WetEventHandler eventHandler);

    void stopListening ();
}
