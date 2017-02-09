package br.com.luvva.wet.service;

import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
class WetService
{
    private @Inject Logger      logger;
    private @Inject KeyListener keyListener;

    private boolean run = true;

    void start ()
    {
        keyListener.setWetService(this);
        if (keyListener.start())
        {
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
                logger.debug("Service interrupted.", e);
            }
            finally
            {
                keyListener.shutDown();
                logger.info("keyListener has been shut down properly!");
            }
        }
    }

    public void exit ()
    {
        run = false;
        logger.info("Service requested to exit...");
    }
}
