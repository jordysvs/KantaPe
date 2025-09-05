create PROCEDURE [dbo].[CoreInsertarProvincia]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CoreProvincia
'* Input :
		@pDescripcion - Descripcion del CoreProvincia
		@pEstado - Estado del CoreProvincia
		@pUsuarioCreacion - UsuarioCreacion del CoreProvincia
'* Output : 
		@pIdProvincia - IdProvincia del CoreProvincia
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdProvincia int out
)
AS
BEGIN
		Select @pIdProvincia = IsNull(Max(IdProvincia),0)+1 From CoreProvincia Where IdProvincia > 0

		Insert Into CoreProvincia
		(
			IdProvincia,
			Descripcion,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdProvincia,
			@pDescripcion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
