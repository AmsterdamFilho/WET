package br.com.luvva.wet.model.prefs;

import br.com.jwheel.core.model.cdi.Custom;
import br.com.luvva.wet.model.actions.RobotAction;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class DefaultHandlerSettings
{
    private RobotAction robotActionA;
    private RobotAction robotActionB;
    private RobotAction robotActionC;

    public RobotAction getRobotActionA ()
    {
        return robotActionA;
    }

    public void setRobotActionA (RobotAction robotActionA)
    {
        this.robotActionA = robotActionA;
    }

    public RobotAction getRobotActionB ()
    {
        return robotActionB;
    }

    public void setRobotActionB (RobotAction robotActionB)
    {
        this.robotActionB = robotActionB;
    }

    public RobotAction getRobotActionC ()
    {
        return robotActionC;
    }

    public void setRobotActionC (RobotAction robotActionC)
    {
        this.robotActionC = robotActionC;
    }
}
