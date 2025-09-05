create PROCEDURE [dbo].[InsertarTokenNotificacion]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de TokenNotificacion
'* Input :
		@pIdUsuario - IdUsuario del TokenNotificacion
		@pTitulo - Titulo del TokenNotificacion
		@pMensaje - Mensaje del TokenNotificacion
		@pEstado - Estado del TokenNotificacion
'* Output : 
		@pIdToken - IdToken del TokenNotificacion
		@pFecha - Fecha del TokenNotificacion
'* Creado Por : John Castillo`
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20) = null, 
	@pTitulo varchar(100) = null, 
	@pMensaje varchar(200) = null, 
	@pResultado varchar(500) = null,
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdToken varchar(200) = null,
	@pFecha DateTime out
)
AS
BEGIN

		Select @pFecha = getdate()

		Insert Into TokenNotificacion
		(
			IdToken,
			Fecha,
			IdUsuario,
			Titulo,
			Mensaje,
			Resultado,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdToken,
			@pFecha,
			@pIdUsuario,
			@pTitulo,
			@pMensaje,
			@pResultado,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END;
