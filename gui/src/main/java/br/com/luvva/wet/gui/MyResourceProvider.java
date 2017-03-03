package br.com.luvva.wet.gui;

import br.com.jwheel.core.service.java.ResourceProvider;

import javax.inject.Singleton;
import java.net.URL;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class MyResourceProvider extends ResourceProvider
{
    public URL mainSceneFxml ()
    {
        return getFxml("mainScene");
    }

    public String getMainSceneCSS ()
    {
        return getCss("mainScene");
    }

    @Override
    protected String root ()
    {
        return "wet-front";
    }
}
