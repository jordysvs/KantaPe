create PROCEDURE [dbo].[CoreActualizarPersonaDireccion]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CorePersonaDireccion
'* Input :
		@pIdPersona - IdPersona del CorePersonaDireccion
		@pIdDireccion - IdDireccion del CorePersonaDireccion
		@pIdUbigeo - IdUbigeo del CorePersonaDireccion
		@pNombre - Nombre del CorePersonaDireccion
		@pDireccion - Direccion del CorePersonaDireccion
		@pLatitud - Latitud del CorePersonaDireccion
		@pLogitud - Logitud del CorePersonaDireccion
		@pPrincipal - Principal del CorePersonaDireccion
		@pEstado - Estado del CorePersonaDireccion
		@pUsuarioModificacion - UsuarioModificacion del CorePersonaDireccion
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdDireccion int = null, 
	@pIdUbigeo int = null, 
	@pNombre varchar(50) = null, 
	@pDireccion varchar(100) = null, 
	@pLatitud varchar(50) = null, 
	@pLongitud varchar(50) = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update CorePersonaDireccion
		Set 
			IdUbigeo = @pIdUbigeo,
			Nombre = @pNombre,
			Direccion = @pDireccion,
			Latitud = @pLatitud,
			Longitud = @pLongitud,
			Principal = @pPrincipal,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdPersona= @pIdPersona AND
			IdDireccion= @pIdDireccion
END
