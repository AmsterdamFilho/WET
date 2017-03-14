package br.com.luvva.wet.model.prefs;

import br.com.jwheel.cdi.Custom;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Custom
public class Preferences
{
    private SimpleBooleanProperty enabled      = new SimpleBooleanProperty(true);
    private SimpleBooleanProperty useExtension = new SimpleBooleanProperty(true);

    public boolean isEnabled ()
    {
        return enabled.get();
    }

    public SimpleBooleanProperty enabledProperty ()
    {
        return enabled;
    }

    public void setEnabled (boolean enabled)
    {
        this.enabled.set(enabled);
    }

    public boolean isUseExtension ()
    {
        return useExtension.get();
    }

    public SimpleBooleanProperty useExtensionProperty ()
    {
        return useExtension;
    }

    public void setUseExtension (boolean useExtension)
    {
        this.useExtension.set(useExtension);
    }
}
