create PROCEDURE [dbo].[CoreInsertarPersonaDireccion]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CorePersonaDireccion
'* Input :
		@pIdPersona - IdPersona del CorePersonaDireccion
		@pIdUbigeo - IdUbigeo del CorePersonaDireccion
		@pNombre - Nombre del CorePersonaDireccion
		@pDireccion - Direccion del CorePersonaDireccion
		@pLatitud - Latitud del CorePersonaDireccion
		@pLogitud - Logitud del CorePersonaDireccion
		@pPrincipal - Principal del CorePersonaDireccion
		@pEstado - Estado del CorePersonaDireccion
		@pUsuarioCreacion - UsuarioCreacion del CorePersonaDireccion
'* Output : 
		@pIdDireccion - IdDireccion del CorePersonaDireccion
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null,
	@pIdUbigeo int = null, 
	@pNombre varchar(50) = null, 
	@pDireccion varchar(100) = null, 
	@pLatitud varchar (50)= null, 
	@pLongitud varchar(50) = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null,
	@pIdDireccion int out
)
AS
BEGIN
		Select @pIdDireccion = IsNull(Max(IdDireccion),0)+1 
		From CorePersonaDireccion 
		Where IdDireccion > 0 AND
		IdPersona = @pIdPersona

		Insert Into CorePersonaDireccion
		(
			IdPersona,
			IdDireccion,
			IdUbigeo,
			Nombre,
			Direccion,
			Latitud,
			Longitud,
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
			@pIdDireccion,
			@pIdUbigeo,
			@pNombre,
			@pDireccion,
			@pLatitud,
			@pLongitud,
			@pPrincipal,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
