package br.com.luvva.wet.model.prefs;

import br.com.jwheel.xml.model.PathPreferences;

import javax.enterprise.inject.Specializes;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
@Specializes
public class MyPathPreferences extends PathPreferences
{
    @Override
    public String getRootFolderName ()
    {
        return "wet";
    }
}
