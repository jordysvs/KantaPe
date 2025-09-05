create PROCEDURE [dbo].[CoreActualizarPersonaMail]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CorePersonaMail
'* Input :
		@pIdPersona - IdPersona del CorePersonaMail
		@pMail - Mail del CorePersonaMail
		@pIdTipoMail - IdTipoMail del CorePersonaMail
		@pPrincipal - Principal del CorePersonaMail
		@pEstado - Estado del CorePersonaMail
		@pUsuarioModificacion - UsuarioModificacion del CorePersonaMail
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdMail int = null,
	@pMail varchar(50) = null, 
	@pIdMailTipo int = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN

		--Si el mail es principal
		IF @pPrincipal = 'S' AND @pEstado = 'A'
		BEGIN
			--Se actualiza las direcciones como no principal
			Update CorePersonaMail
			Set Principal = 'N'
			Where IdPersona = @pIdPersona
		END

		--Insercion del mail de la persona
		Update CorePersonaMail
		Set 
			IdMailTipo = @pIdMailTipo,
			Mail = @pMail,
			Principal = @pPrincipal,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdPersona = @pIdPersona AND
			IdMail = @pIdMail
END
