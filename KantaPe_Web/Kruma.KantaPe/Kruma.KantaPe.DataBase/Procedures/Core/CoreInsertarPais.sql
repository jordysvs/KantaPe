create PROCEDURE [dbo].[CoreInsertarPais]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CorePais
'* Input :
		@pDescripcion - Descripcion del CorePais
		@pEstado - Estado del CorePais
		@pUsuarioCreacion - UsuarioCreacion del CorePais
'* Output : 
		@pIdPais - IdPais del CorePais
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdPais int out
)
AS
BEGIN
		Select @pIdPais = IsNull(Max(IdPais),0)+1 From CorePais Where IdPais > 0

		Insert Into CorePais
		(
			IdPais,
			Descripcion,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdPais,
			@pDescripcion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
