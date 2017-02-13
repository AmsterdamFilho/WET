package br.com.luvva.wet.service;

import br.com.luvva.wet.model.Preferences;
import org.slf4j.Logger;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class WetService
{
    private @Inject          Logger         logger;
    private @Inject          WetKeyListener keyListener;
    private @Inject @Default Preferences    preferences;

    private boolean run = true;

    void start ()
    {
        if (keyListener.startListening())
        {
            if (preferences.isTestMode())
            {
                HwTestApplication.main(null);
            }
            else
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
                    logger.error("Service interrupted.", e);
                }
            }
        }
    }

    public void stop ()
    {
        keyListener.stopListening();
        logger.info("keyListener has stopped listening!");
        run = false;
    }
}
