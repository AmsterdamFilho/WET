package br.com.luvva.wet.model.prefs;

import br.com.jwheel.xml.model.FromXmlPreferences;
import br.com.jwheel.xml.service.PreferencesFactoryFromXml;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class PreferencesFactory implements PreferencesFactoryFromXml<Preferences>
{
    private @Inject PreferencesDao dao;

    @Produces
    @FromXmlPreferences
    public Preferences produce ()
    {
        return produce(dao);
    }

    @Override
    public Preferences produceDefault ()
    {
        Preferences preferences = new Preferences();
        preferences.setEnabled(true);
        preferences.setUseExtension(false);
        return preferences;
    }
}
