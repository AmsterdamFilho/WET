package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class WindowsKeyListener implements KeyListener
{
    private @Inject Logger          logger;
    private @Inject WetEventHandler eventHandler;

    private GlobalKeyboardHook keyboardHook;
    private WetService         wetService;

    @Override
    public boolean start ()
    {
        try
        {
            keyboardHook = new GlobalKeyboardHook();
        }
        catch (UnsatisfiedLinkError | Exception throwable)
        {
            logger.error("Can't start service!", throwable);
            return false;
        }

        keyboardHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyReleased (GlobalKeyEvent event)
            {
                if (isActionEvent(event))
                {
                    eventHandler.handle();
                }
                else if (isExitEvent(event))
                {
                    wetService.exit();
                }
                else
                {
                    logger.info("Not handling event: " + event.toString());
                }
            }
        });
        return true;
    }

    @Override
    public void shutDown ()
    {
        keyboardHook.shutdownHook();
    }

    @Override
    public void setWetService (WetService wetService)
    {
        this.wetService = wetService;
    }

    private boolean isActionEvent (GlobalKeyEvent e)
    {
        // TODO: 08/02/17 define key event (there might be more than one)
        return e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() == GlobalKeyEvent.VK_0;
    }

    private boolean isExitEvent (GlobalKeyEvent e)
    {
        // TODO: 09/02/17 define exit event
        return e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE;
    }
}
