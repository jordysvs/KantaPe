package com.kruma.core.configuration.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/**
 * Created by John on 22/06/2016.
 */
public class ApplicationConfiguration {

    //region VARIABLES
    @Attribute
    public String Name;

    @Text
    public String Value;
    //endregion

    //region PROPIEDADES
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
    //endregion
}
