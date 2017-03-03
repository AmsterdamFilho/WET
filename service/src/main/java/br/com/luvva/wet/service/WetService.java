package br.com.luvva.wet.service;

import br.com.luvva.wet.service.handler.WetEventHandler;
import br.com.luvva.wet.service.listener.WetKeyListener;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
class WetService
{
    private @Inject Logger          logger;
    private @Inject WetKeyListener  keyListener;
    private @Inject WetEventHandler eventHandler;

    private boolean run = true;

    void start ()
    {
        if (eventHandler.initOk() && keyListener.startListening(eventHandler))
        {
            Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
            try
            {
                while (run)
                {
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e)
            {
                // does not reach here if the process is terminated by the user or OS
                logger.error("Service interrupted.", e);
            }
        }
    }

    private void stop ()
    {
        keyListener.stopListening();
        logger.info("keyListener has stopped listening!");
        run = false;
    }
}
