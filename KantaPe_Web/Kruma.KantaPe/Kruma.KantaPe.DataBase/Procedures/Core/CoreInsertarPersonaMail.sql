create PROCEDURE [dbo].[CoreInsertarPersonaMail]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CorePersonaMail
'* Input :
		@pIdPersona - IdPersona del CorePersonaMail
		@pMail - Mail del CorePersonaMail
		@pIdTipoMail - IdTipoMail del CorePersonaMail
		@pPrincipal - Principal del CorePersonaMail
		@pEstado - Estado del CorePersonaMail
		@pUsuarioCreacion - UsuarioCreacion del CorePersonaMail
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null,
	@pMail varchar(50) = null,
	@pIdMailTipo int = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null,
	@pIdMail int out
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
		Select @pIdMail = IsNull(Max(IdMail),0)+1 
		From CorePersonaMail
		Where IdMail > 0 AND
		IdPersona = @pIdPersona

		Insert Into CorePersonaMail
		(
			IdPersona,
			IdMail,
			Mail,
			IdMailTipo,
			Principal,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdPersona,
			@pIdMail,
			@pMail,
			@pIdMailTipo,
			@pPrincipal,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
