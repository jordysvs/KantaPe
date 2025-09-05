package com.kruma.core.configuration.manager;

import com.kruma.core.configuration.entity.ApplicationConfiguration;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by John on 22/06/2016.
 */
@Root(name = "AppSettings")
public class ApplicationManager {

    //region VARIABLES
    @ElementList(entry = "Key", type = ApplicationConfiguration.class, inline = true)
    public List<ApplicationConfiguration> Keys;
    //endregion

    //region CONSTRUCTORES
    public ApplicationManager() {
    }
    //endregion

    //region PROPIEDADES
    public List<ApplicationConfiguration> getKeys() {
        return this.Keys;
    }

    public void setConfigurations(List<ApplicationConfiguration> lst_pKeys) {
        this.Keys = lst_pKeys;
    }
    //endregion

    //region METODOS PUBLICOS
    public ApplicationConfiguration getItem(String str_pName) {
        for (ApplicationConfiguration obj_Key : this.Keys)
            if (obj_Key.getName().toLowerCase().trim().equals(str_pName.toLowerCase().trim()))
                return obj_Key;
        return null;
    }
    //endregion
}
