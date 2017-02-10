package br.com.luvva.wet.model;

import br.com.jwheel.core.model.cdi.Custom;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class Preferences
{
    private boolean enabled;
    private boolean testMode;

    public boolean isTestMode ()
    {
        return testMode;
    }

    public void setTestMode (boolean testMode)
    {
        this.testMode = testMode;
    }

    public boolean isEnabled ()
    {
        return enabled;
    }

    public void setEnabled (boolean enabled)
    {
        this.enabled = enabled;
    }
}
