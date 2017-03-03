package br.com.luvva.wet.model.prefs;

import br.com.jwheel.xml.dao.GenericXStreamDao;
import br.com.jwheel.xml.service.SimpleBooleanPropertyConverter;
import br.com.jwheel.xml.service.SimpleIntegerPropertyConverter;
import br.com.jwheel.xml.service.SimpleStringPropertyConverter;
import com.thoughtworks.xstream.XStream;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class DefaultHandlerSettingsDao extends GenericXStreamDao<DefaultHandlerSettings>
{
    @Override
    protected XStream createXStream ()
    {
        XStream xStream = super.createXStream();
        xStream.registerConverter(new SimpleBooleanPropertyConverter());
        xStream.registerConverter(new SimpleIntegerPropertyConverter());
        xStream.registerConverter(new SimpleStringPropertyConverter());
        return xStream;
    }
}
