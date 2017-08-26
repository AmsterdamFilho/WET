package br.com.luvva.wet.gui;

import br.com.jwheel.utils.ResourceProvider;

import java.net.URL;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class MyResourceProvider extends ResourceProvider
{
    URL mainSceneFxml ()
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
        return "wet-gui";
    }
}
