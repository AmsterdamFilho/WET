package br.com.luvva.wet.service;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public interface KeyListener
{
    void setWetService (WetService wetService);

    boolean start ();

    void shutDown ();
}
