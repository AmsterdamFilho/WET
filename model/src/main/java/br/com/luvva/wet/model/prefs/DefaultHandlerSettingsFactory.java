package br.com.luvva.wet.model.prefs;

import br.com.jwheel.xml.model.FromXmlPreferences;
import br.com.jwheel.xml.service.PreferencesFactoryFromXml;
import br.com.luvva.wet.model.actions.EmptyAction;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public final class DefaultHandlerSettingsFactory implements PreferencesFactoryFromXml<DefaultHandlerSettings>
{
    private @Inject DefaultHandlerSettingsDao dao;

    @Produces
    @FromXmlPreferences
    private DefaultHandlerSettings produce ()
    {
        return produce(dao);
    }

    @Override
    public DefaultHandlerSettings produceDefault ()
    {
        DefaultHandlerSettings settings = new DefaultHandlerSettings();
        settings.setRobotActionA(new EmptyAction());
        settings.setRobotActionB(new EmptyAction());
        settings.setRobotActionC(new EmptyAction());
        return settings;
    }
}
