package br.com.luvva.wet.model.prefs;

import br.com.jwheel.xml.dao.GenericXStreamDao;
import br.com.jwheel.xml.service.SimpleBooleanPropertyConverter;
import com.thoughtworks.xstream.XStream;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class PreferencesDao extends GenericXStreamDao<Preferences>
{
    @Override
    protected XStream createXStream ()
    {
        XStream xStream = super.createXStream();
        xStream.registerConverter(new SimpleBooleanPropertyConverter());
        return xStream;
    }
}
