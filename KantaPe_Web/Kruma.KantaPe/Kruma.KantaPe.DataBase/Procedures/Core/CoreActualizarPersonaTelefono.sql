create PROCEDURE [dbo].[CoreActualizarPersonaTelefono]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CorePersonaTelefono
'* Input :
		@pIdPersona - IdPersona del CorePersonaTelefono
		@pIdTelefono - IdTelefono del CorePersonaTelefono
		@pIdTipoTelefono - IdTipoTelefono del CorePersonaTelefono
		@pNumero - Numero del CorePersonaTelefono
		@pPrincipal - Principal del CorePersonaTelefono
		@pEstado - Estado del CorePersonaTelefono
		@pUsuarioModificacion - UsuarioModificacion del CorePersonaTelefono
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdTelefono int = null, 
	@pIdTelefonoTipo int = null, 
	@pNumero varchar(50) = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
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

		--Actualizacion del telefono de la persona
		Update CorePersonaTelefono
		Set 
			IdTelefonoTipo = @pIdTelefonoTipo,
			Numero = @pNumero,
			Principal = @pPrincipal,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdPersona= @pIdPersona AND
			IdTelefono= @pIdTelefono
END
