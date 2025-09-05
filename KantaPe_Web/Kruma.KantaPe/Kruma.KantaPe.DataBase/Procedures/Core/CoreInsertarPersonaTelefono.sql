create PROCEDURE [dbo].[CoreInsertarPersonaTelefono]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CorePersonaTelefono
'* Input :
		@pIdPersona - IdPersona del CorePersonaTelefono
		@pNumero - Numero del CorePersonaTelefono
		@pPrincipal - Principal del CorePersonaTelefono
		@pEstado - Estado del CorePersonaTelefono
		@pUsuarioCreacion - UsuarioCreacion del CorePersonaTelefono
'* Output : 
		@pIdTelefono - IdTelefono del CorePersonaTelefono
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int  = null,
	@pNumero varchar(50) = null, 
	@pIdTelefonoTipo int = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdTelefono int out
)
AS
BEGIN

		--Si el telefono es principal
		IF @pPrincipal = 'S' AND @pEstado = 'A'
		BEGIN
			--Se actualiza las direcciones como no principal
			Update CorePersonaTelefono
			Set Principal = 'N'
			Where IdPersona = @pIdPersona
		END

		--Insercion del telefono de la persona
		Select @pIdTelefono = IsNull(Max(IdTelefono),0)+1 
		From CorePersonaTelefono 
		Where IdTelefono > 0 AND
		IdPersona = @pIdPersona

		Insert Into CorePersonaTelefono
		(
			IdPersona,
			IdTelefono,
			IdTelefonoTipo,
			Numero,
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
			@pIdTelefono,
			@pIdTelefonoTipo,
			@pNumero,
			@pPrincipal,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
