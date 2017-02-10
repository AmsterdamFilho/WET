package br.com.luvva.wet.service;

import java.awt.*;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class RobotService
{
    private Robot robot;

    public RobotService (Robot robot)
    {
        this.robot = robot;
    }

    public void typeKey (int keyCode)
    {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
}
