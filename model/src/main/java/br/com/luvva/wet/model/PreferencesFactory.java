package br.com.luvva.wet.model;

import br.com.jwheel.xml.service.PreferencesFactoryFromXml;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class PreferencesFactory extends PreferencesFactoryFromXml<Preferences>
{
    private @Inject PreferencesDao dao;

    @Produces
    public Preferences produce ()
    {
        return produce(dao);
    }

    @Override
    protected void setDefaultPreferences (Preferences preferencesBean)
    {
        preferencesBean.setEnabled(true);
        preferencesBean.setTestMode(true);
    }
}
