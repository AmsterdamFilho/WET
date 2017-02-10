package br.com.luvva.wet.service;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public interface WetEventHandler
{
    void handleEventA ();

    void handleEventB ();

    void handleEventC ();

    void handleUnregisteredEvent (String event);
}
