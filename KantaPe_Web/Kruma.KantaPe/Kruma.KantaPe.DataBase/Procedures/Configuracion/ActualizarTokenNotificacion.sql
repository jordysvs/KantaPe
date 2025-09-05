create PROCEDURE [dbo].[ActualizarTokenNotificacion]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de TokenNotificacion
'* Input :
		@pIdToken - IdToken del TokenNotificacion
		@pFecha - Fecha del TokenNotificacion
		@pIdUsuario - IdUsuario del TokenNotificacion
		@pTitulo - Titulo del TokenNotificacion
		@pMensaje - Mensaje del TokenNotificacion
		@pEstado - Estado del TokenNotificacion
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdToken varchar(200) = null, 
	@pFecha DateTime = null, 
	@pIdUsuario varchar(20) = null, 
	@pTitulo varchar(100) = null, 
	@pResultado varchar(500) = null,
	@pMensaje varchar(200) = null, 
	@pEstado varchar(1) = null,
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update TokenNotificacion
		Set 
			IdUsuario = @pIdUsuario,
			Titulo = @pTitulo,
			Mensaje = @pMensaje,
			Resultado = @pResultado,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdToken= @pIdToken AND
			Fecha= @pFecha
END;
