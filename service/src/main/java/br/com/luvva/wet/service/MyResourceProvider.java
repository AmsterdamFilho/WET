package br.com.luvva.wet.service;

import br.com.jwheel.core.service.java.ResourceProvider;

import javax.inject.Singleton;
import java.io.InputStream;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Singleton
public class MyResourceProvider extends ResourceProvider
{
    InputStream hwTestFxml ()
    {
        return getFxml("hw-test");
    }

    @Override
    protected String root ()
    {
        return "wet-service";
    }
}
