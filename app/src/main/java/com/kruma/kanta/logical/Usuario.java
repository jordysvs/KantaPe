package com.kruma.kanta.logical;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.util.common.ProcessResult;

/**
 * Created by Enrique on 26/07/2016.
 */
public class Usuario {

    public static void Insertar(
            com.kruma.kanta.entidad.Usuario obj_pUsuario,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        //Se inicializa el servicio
        com.kruma.kanta.service.IUsuario IUsuario = new com.kruma.core.service.ServiceManager(
                com.kruma.kanta.entidad.Constante.SERVICE_USUARIO,
                com.kruma.kanta.service.IUsuario.class
        ).getClient();

        //Insercion del usuario
        IUsuario.Insertar(
                obj_pUsuario,
                new ServiceCallback<
                                        ProcessResult>() {

                    @Override
                    public void success(com.kruma.core.util.common.ProcessResult obj_pProcessResult) {
                        obj_pCallback.success(obj_pProcessResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void Obtener(
            String int_pUsuario,
            final ProcessCallback<
                                com.kruma.kanta.entidad.Usuario> obj_pCallback) {

        //Obtiene el id del usuario
        String str_pIdUsuario =
                int_pUsuario == null ? com.kruma.kanta.entidad.Constante.NULL_TYPE : int_pUsuario;

        //Se inicializa el servicio
        com.kruma.kanta.service.IUsuario IUsuario = new com.kruma.core.service.ServiceManager(
                com.kruma.kanta.entidad.Constante.SERVICE_USUARIO,
                com.kruma.kanta.service.IUsuario.class
        ).getClient();

        //Se obtiene el usuario
        IUsuario.Obtener(str_pIdUsuario,
                new ServiceCallback<
                                        com.kruma.kanta.entidad.Usuario>() {

                    @Override
                    public void success(com.kruma.kanta.entidad.Usuario obj_pUsuario) {
                        obj_pCallback.success(obj_pUsuario);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void Modificar(
            com.kruma.kanta.entidad.Usuario obj_pUsuario,
            final ProcessCallback<
                                ProcessResult> obj_pCallback) {

        // Se inicializa el servicio
        com.kruma.kanta.service.IUsuario IUsuario = new com.kruma.core.service.ServiceManager(
                com.kruma.kanta.entidad.Constante.SERVICE_USUARIO,
                com.kruma.kanta.service.IUsuario.class
        ).getClient();

        // Se modifica el usuario
        IUsuario.Modificar(obj_pUsuario,
                new ServiceCallback<ProcessResult>() {

                    @Override
                    public void success(com.kruma.core.util.common.ProcessResult obj_pProcessResult) {
                        obj_pCallback.success(obj_pProcessResult);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }
}
