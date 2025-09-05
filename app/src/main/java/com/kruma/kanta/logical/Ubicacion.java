package com.kruma.kanta.logical;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.entidad.Constante;

/**
 * Created by Enrique on 26/07/2016.
 */
public class Ubicacion {


    public static void Obtener(
            Integer int_pIdLocal,
            Integer int_pIdUbicacion,
            final ProcessCallback<com.kruma.kanta.entidad.Ubicacion> obj_pCallback) {
        //Obtiene el id del LOCAL

        String str_IdLocal = int_pIdLocal == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdLocal.toString();
        String str_IdUbicacion = int_pIdUbicacion == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pIdUbicacion.toString();

        //Se inicializa el servicio
        com.kruma.kanta.service.IUbicacion IUbicacion = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_UBICACION,
                com.kruma.kanta.service.IUbicacion.class
        ).getClient();

        //Se obtiene el usuario
        IUbicacion.Obtener(str_IdLocal, str_IdUbicacion,
                new ServiceCallback<
                                        com.kruma.kanta.entidad.Ubicacion>() {

                    @Override
                    public void success(com.kruma.kanta.entidad.Ubicacion obj_pUbicacion) {
                        obj_pCallback.success(obj_pUbicacion);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void ObtenerQR(
            String str_pQR,
            final ProcessCallback<com.kruma.kanta.entidad.Ubicacion> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IUbicacion IUbicacion = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_UBICACION,
                com.kruma.kanta.service.IUbicacion.class
        ).getClient();

        //Se obtiene el usuario
        IUbicacion.ObtenerQR(str_pQR,
                new ServiceCallback<
                        com.kruma.kanta.entidad.Ubicacion>() {

                    @Override
                    public void success(com.kruma.kanta.entidad.Ubicacion obj_pUbicacion) {
                        obj_pCallback.success(obj_pUbicacion);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
}
