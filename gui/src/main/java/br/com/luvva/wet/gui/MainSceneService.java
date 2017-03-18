package br.com.luvva.wet.gui;

import br.com.jwheel.xml.model.FromXmlPreferences;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettings;
import br.com.luvva.wet.model.prefs.DefaultHandlerSettingsDao;
import br.com.luvva.wet.model.prefs.Preferences;
import br.com.luvva.wet.model.prefs.PreferencesDao;
import javafx.application.Platform;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class MainSceneService
{
    private @Inject @FromXmlPreferences Preferences            preferences;
    private @Inject @FromXmlPreferences DefaultHandlerSettings settings;

    private @Inject PreferencesDao            preferencesDao;
    private @Inject DefaultHandlerSettingsDao settingsDao;

    private @Inject Logger logger;

    public Preferences getPreferences ()
    {
        return preferences;
    }

    public DefaultHandlerSettings getSettings ()
    {
        return settings;
    }

    public void persistPreferences ()
    {
        try
        {
            preferencesDao.merge(preferences);
        }
        catch (IOException e)
        {
            logger.error("Could not persist preferences!", e);
        }
    }

    public void persistSettings ()
    {
        try
        {
            settingsDao.merge(settings);
        }
        catch (IOException e)
        {
            logger.error("Could not persist default handler settings!", e);
        }
    }

    public void exit ()
    {
        Platform.exit();
    }
}
