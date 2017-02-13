package br.com.luvva.wet.service;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.jwheel.core.service.cdi.WeldContext;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class WindowsKeyListener implements WetKeyListener
{
    private @Inject Logger          logger;
    private @Inject WetEventHandler eventHandler;

    private GlobalKeyboardHook keyboardHook;

    @Override
    public boolean startListening ()
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
                if (isActionEventA(event))
                {
                    eventHandler.handleEventA();
                }
                else if (isActionEventB(event))
                {
                    eventHandler.handleEventB();
                }
                else if (isActionEventC(event))
                {
                    eventHandler.handleEventC();
                }
                else if (isExitEvent(event))
                {
                    WeldContext.getInstance().getBean(WetService.class).stop();
                }
                else
                {
                    eventHandler.handleUnregisteredEvent(event.toString());
                }
            }
        });
        return true;
    }

    @Override
    public void stopListening ()
    {
        keyboardHook.shutdownHook();
    }

    private boolean isActionEventA (GlobalKeyEvent e)
    {
        return e.isMenuPressed() && e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() ==
                GlobalKeyEvent.VK_A;
    }

    private boolean isActionEventB (GlobalKeyEvent e)
    {
        return e.isMenuPressed() && e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() ==
                GlobalKeyEvent.VK_B;
    }

    private boolean isActionEventC (GlobalKeyEvent e)
    {
        return e.isMenuPressed() && e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() ==
                GlobalKeyEvent.VK_C;
    }

    private boolean isExitEvent (GlobalKeyEvent e)
    {
        return e.isMenuPressed() && e.isControlPressed() && e.isShiftPressed() && e.getVirtualKeyCode() ==
                GlobalKeyEvent.VK_ESCAPE;
    }
}
