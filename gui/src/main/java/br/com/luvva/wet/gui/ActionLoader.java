package br.com.luvva.wet.gui;

import br.com.luvva.wet.model.actions.RobotAction;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public interface ActionLoader
{
    RobotAction getAction (DefaultHandlerSettings settings);

    void setAction (DefaultHandlerSettings settings, RobotAction action);
}
