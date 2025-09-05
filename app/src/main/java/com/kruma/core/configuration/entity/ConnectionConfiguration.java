package com.kruma.core.configuration.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/**
 * Created by John on 22/06/2016.
 */
public class ConnectionConfiguration {

    //region VARIABLES
    @Attribute
    public String Name;
    @Text
    public String Path;
    //endregion

    //region PROPIEDADES
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPath() {
        return this.Path;
    }

    public void setPath(String dataBaseName) {
        this.Path = dataBaseName;
    }
    //endregion
}
