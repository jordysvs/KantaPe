create PROCEDURE [dbo].[InsertarToken]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Token
'* Input :
		@pIdToken - IdToken del Token
		@pEstado - Estado del Token
'* Output : 
		@pIdUsuario - IdUsuario del Token
'* Creado Por : John Castillo
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20) = null,
	@pIdToken varchar(200) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null
)
AS
BEGIN
		Insert Into Token
		(
			IdUsuario,
			IdToken,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdUsuario,
			@pIdToken,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END;
