package com.kruma.core.security;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.kruma.core.configuration.App;
import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.security.entity.Constante;
import com.kruma.core.security.entity.SecurityResult;
import com.kruma.core.security.entity.ValidationResult;
import com.kruma.core.security.service.ISecurity;
import com.kruma.core.util.common.ProcessCallback;
import com.kruma.core.service.entity.ServiceCallback;
import com.kruma.core.util.common.ProcessResult;
import com.kruma.kanta.LoginActivity;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.entidad.Usuario;

/**
 * Created by John on 15/06/2016.
 */
public class SecurityManager {

    //region VARIABLES
    private static final String TAG = "SecurityManager";
    private static final String APP_PREFERENCES =
            ConfigurationManager.getDefault().getApplicationManager().getItem("NombreSistema").getValue();
    private static final String USERNAME = "USERNAME";
    private static final String ISLOGGEDIN = "ISLOGGEDIN";
    //endregion

    //region SESSION
    public static Boolean ValidarSession() {
        Boolean bln_Logged = isLoggedIn();
        if (!bln_Logged)
            goToLogin();
        return bln_Logged;
    }

    public static void CrearSession(String str_pUsuario) {
        clearSession();
        SharedPreferences.Editor obj_Editor = getEditor();
        obj_Editor.putString(getStringKey(USERNAME), str_pUsuario);
        obj_Editor.putBoolean(getStringKey(ISLOGGEDIN), true);
        obj_Editor.apply();
    }

    public static void CerrarSesion() {
        clearSession();
        goToLogin();
    }

    public static String getUsuario() {

        return getSharedPreferences().getString(getStringKey(USERNAME), null);
    }

    public static String getKey(String str_pKey) {
        //if (ValidarSession())
        return getSharedPreferences().getString(getStringKey(str_pKey), null);
        //return null;
    }
    public static Integer getKeyInteger(String str_pKey) {
        //if (ValidarSession())
        Integer int_Resultado = null;
        try{
            int_Resultado = Integer.parseInt(getSharedPreferences().getString(getStringKey(str_pKey), null));
        }
        catch(Exception ex){
            int_Resultado = null;
        }
        return int_Resultado;
    }

    public static Double getKeyDouble(String str_pKey) {
        //if (ValidarSession())
        Double int_Resultado = null;
        try{
            int_Resultado = Double.parseDouble(getSharedPreferences().getString(getStringKey(str_pKey), null));
        }
        catch(Exception ex){
            int_Resultado = null;
        }
        return int_Resultado;
    }

    public static void setKey(String str_pKey, String str_pValue) {
        //if (ValidarSession()) {
        SharedPreferences.Editor obj_Editor = getEditor();
        obj_Editor.putString(getStringKey(str_pKey), str_pValue);
        obj_Editor.apply();
        //}
    }

    //endregion

    //region METODOS PUBLICOS
    public static void AutenticacionUsuario(
            final String str_pUsuario,
            final String str_pPassword,
            final ProcessCallback<SecurityResult> obj_pCallback) {

        ISecurity ISecurity = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.security.service.ISecurity.class
        ).getClient();

        ISecurity.autenticacionUsuario(str_pUsuario, str_pPassword,
                new ServiceCallback<SecurityResult>() {

                    @Override
                    public void success(com.kruma.core.security.entity.SecurityResult obj_pSecurityResult) {
                        try {
                            if (obj_pSecurityResult.getValidationResult() != ValidationResult.Authenticated)
                                throw new Exception(obj_pSecurityResult.getMessage());

                            //CrearSession(str_pUsuario.toUpperCase());
                            obj_pCallback.success(obj_pSecurityResult);
                            // goToMain();

                        } catch (Exception obj_pExcepcion) {
                            clearSession();
                            failure(new ProcessResult(obj_pExcepcion));
                        }
                    }

                    @Override
                    public void failure(com.kruma.core.util.common.ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void ActualizarToken(
            final String str_pUsuario,
            final ProcessCallback<ProcessResult> obj_pCallback) {

        ISecurity ISecurity = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.security.service.ISecurity.class
        ).getClient();

        com.kruma.kanta.entidad.Usuario obj_Usuario = new Usuario();
        obj_Usuario.setIdUsuario(str_pUsuario);
        obj_Usuario.setIdToken(FirebaseInstanceId.getInstance().getToken());

        ISecurity.actualizarToken(obj_Usuario,
                new ServiceCallback<ProcessResult>() {

                    @Override
                    public void success(com.kruma.core.util.common.ProcessResult obj_pProcessResult) {
                        try {
                            //CrearSession(str_pUsuario.toUpperCase());
                            obj_pCallback.success(obj_pProcessResult);
                            //goToMain();

                        } catch (Exception obj_pExcepcion) {
                            clearSession();
                            failure(new ProcessResult(obj_pExcepcion));
                        }
                    }

                    @Override
                    public void failure(com.kruma.core.util.common.ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }


    public static void AutenticacionUsuarioToken(
            final String str_pUsuario,
            final String str_pPassword,
            final ProcessCallback<SecurityResult> obj_pCallback) {

        ISecurity ISecurity = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.security.service.ISecurity.class
        ).getClient();

        com.kruma.kanta.entidad.Usuario obj_Usuario = new Usuario();
        obj_Usuario.setIdUsuario(str_pUsuario);
        obj_Usuario.setClave(str_pPassword);
        obj_Usuario.setIdToken(FirebaseInstanceId.getInstance().getToken());

        ISecurity.autenticacionUsuarioToken(obj_Usuario,
                new ServiceCallback<SecurityResult>() {

                    @Override
                    public void success(com.kruma.core.security.entity.SecurityResult obj_pSecurityResult) {
                        try {
                            if (obj_pSecurityResult.getValidationResult() != ValidationResult.Authenticated)
                                throw new Exception(obj_pSecurityResult.getMessage());

                            //CrearSession(str_pUsuario.toUpperCase());
                            obj_pCallback.success(obj_pSecurityResult);
                            //goToMain();

                        } catch (Exception obj_pExcepcion) {
                            clearSession();
                            failure(new ProcessResult(obj_pExcepcion));
                        }
                    }

                    @Override
                    public void failure(com.kruma.core.util.common.ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    public static void CambiarContrasenia(
            String str_pUsuario,
            String str_pMail,
            final ProcessCallback<ProcessResult> obj_pCallback) {

        ISecurity ISecurity = new com.kruma.core.service.ServiceManager(
                Constante.SERVICE_NAME,
                com.kruma.core.security.service.ISecurity.class
        ).getClient();

        ISecurity.cambiarContrasenia(str_pUsuario, str_pMail,
                new ServiceCallback<ProcessResult>() {
                    @Override
                    public void success(ProcessResult obj_pResultado) {
                        obj_pCallback.success(obj_pResultado);
                    }

                    @Override
                    public void failure(ProcessResult obj_pResultado) {
                        obj_pCallback.failure(obj_pResultado);
                    }
                });
    }

    //endregion

    //region METODOS PRIVADOS
    private static String getStringKey(String str_pKey) {
        return String.format("%1$s.%2$s", APP_PREFERENCES, str_pKey);
    }

    private static void clearSession() {
        SharedPreferences.Editor obj_Editor = getEditor();
        obj_Editor.clear();
        obj_Editor.commit();
    }

    private static void goToLogin() {
        Intent it_Login = new Intent(App.getContext(), LoginActivity.class);
        it_Login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it_Login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getContext().startActivity(it_Login);
    }

    public static void goToMain() {
        Intent it_Main = new Intent(App.getContext(), MainActivity.class);
        it_Main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it_Main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getContext().startActivity(it_Main);
    }

    public static void goToMainFacebook() {
        Intent it_Main = new Intent(App.getContext(), MainActivity.class);
        it_Main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it_Main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        it_Main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getContext().startActivity(it_Main);
    }
    private static boolean isLoggedIn() {
        SharedPreferences obj_SharedPreferencies = getSharedPreferences();
        if (obj_SharedPreferencies.contains(getStringKey(ISLOGGEDIN)))
            return obj_SharedPreferencies.getBoolean(getStringKey(ISLOGGEDIN), false);
        else return false;
    }

    private static SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }

    private static SharedPreferences getSharedPreferences() {
        return App.getContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }
    //endregion
}
