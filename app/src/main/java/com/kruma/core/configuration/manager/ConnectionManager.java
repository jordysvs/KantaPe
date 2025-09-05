package com.kruma.core.configuration.manager;

import com.kruma.core.configuration.entity.ConnectionConfiguration;
import com.kruma.core.configuration.entity.ServiceConfiguration;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by John on 22/06/2016.
 */
@Root(name = "Connections")
public class ConnectionManager {

    //region VARIABLES
    @ElementList(entry = "ConnectionString", type = ConnectionConfiguration.class, inline = true)
    public List<ConnectionConfiguration> Connections;
    //endregion

    //region CONSTRUCTORES
    public ConnectionManager() {
    }
    //endregion

    //region PROPIEDADES
    public List<ConnectionConfiguration> getConnections() {
        return this.Connections;
    }

    public void setConnection(List<ConnectionConfiguration> lst_pConnections) {
        this.Connections = lst_pConnections;
    }
    //endregion

    //region METODOS PUBLICOS
    public ConnectionConfiguration getItem(String str_pName) {
        for (ConnectionConfiguration obj_Configuracion : this.Connections)
            if (obj_Configuracion.getName().toLowerCase().trim().equals(str_pName.toLowerCase().trim()))
                return obj_Configuracion;
        return null;
    }
    //endregion
}
