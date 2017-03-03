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
    static final String LEFT_MOUSE_BUTTON   = "leftMouseButton";
    static final String MIDDLE_MOUSE_BUTTON = "middleMouseButton";
    static final String RIGHT_MOUSE_BUTTON  = "rightMouseButton";

    URL mainSceneFxml ()
    {
        return getFxml("mainScene");
    }

    String getMainSceneCSS ()
    {
        return getCss("mainScene");
    }

    @Override
    protected String root ()
    {
        return "wet-gui";
    }
}
