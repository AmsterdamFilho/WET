package br.com.luvva.wet.service;

import br.com.jwheel.core.service.cdi.WeldContext;
import br.com.luvva.wet.model.Preferences;
import org.slf4j.Logger;

import javax.enterprise.inject.Default;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.awt.*;

import static java.awt.event.InputEvent.BUTTON2_MASK;
import static java.awt.event.KeyEvent.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class DefaultEventHandler implements WetEventHandler
{
    private @Inject Logger logger;

    @Override
    public void handle ()
    {
        Preferences preferences = WeldContext.getInstance().getBean(Preferences.class,
                new AnnotationLiteral<Default>() {});
        if (preferences.isEnabled())
        {
            try
            {
                Robot robot = new Robot();
                robot.keyPress(VK_O);
                robot.keyRelease(VK_O);
                robot.keyPress(VK_K);
                robot.keyRelease(VK_K);
                robot.keyPress(VK_ENTER);
                robot.keyRelease(VK_ENTER);
                robot.mousePress(BUTTON2_MASK);
                Thread.sleep(300);
                robot.mouseRelease(BUTTON2_MASK);
                logger.info("Event handled successfully!");
            }
            catch (Exception e)
            {
                logger.error("Error handling event!", e);
            }
        }
    }
}
