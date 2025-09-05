package com.kruma.core.configuration.manager;

import com.kruma.core.configuration.entity.ServiceConfiguration;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by John on 22/06/2016.
 */
@Root(name = "Services")
public class ServiceManager {

    //region VARIABLES
    @ElementList(entry = "Service", type = ServiceConfiguration.class, inline = true)
    public List<ServiceConfiguration> Services;
    //endregion

    //region CONSTRUCTORES
    public ServiceManager() {
    }
    //endregion

    //region PROPIEDADES
    public List<ServiceConfiguration> getServices() {
        return this.Services;
    }

    public void setServices(List<ServiceConfiguration> lst_pServices) {
        Services = lst_pServices;
    }
    //endregion

    //region METODOS PUBLICOS
    public ServiceConfiguration getItem(String str_pName) {
        for (ServiceConfiguration obj_Configuracion : this.Services)
            if (obj_Configuracion.getName().toLowerCase().trim().equals(str_pName.toLowerCase().trim()))
                return obj_Configuracion;
        return null;
    }
    //endregion
}