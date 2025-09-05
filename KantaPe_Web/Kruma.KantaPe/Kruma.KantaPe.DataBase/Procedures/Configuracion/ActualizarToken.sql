create PROCEDURE [dbo].[ActualizarToken]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Token
'* Input :
		@pIdUsuario - IdUsuario del Token
		@pIdToken - IdToken del Token
		@pEstado - Estado del Token
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20) = null, 
	@pIdToken varchar(200) = null, 
	@pEstado varchar(1) = null,
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update Token
		Set 
			IdToken = @pIdToken,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdUsuario= @pIdUsuario
END;
