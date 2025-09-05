create PROCEDURE [dbo].[CoreInsertarDistrito]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CoreDistrito
'* Input :
		@pDescripcion - Descripcion del CoreDistrito
		@pEstado - Estado del CoreDistrito
		@pUsuarioCreacion - UsuarioCreacion del CoreDistrito
'* Output : 
		@pIdDistrito - IdDistrito del CoreDistrito
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pFechaCreacion DateTime = null, 
	@pUsuarioModificacion varchar(20) = null, 
	@pFechaModificacion DateTime = null, 
	@pIdDistrito int out
)
AS
BEGIN
		Select @pIdDistrito = IsNull(Max(IdDistrito),0)+1 From CoreDistrito Where IdDistrito > 0

		Insert Into CoreDistrito
		(
			IdDistrito,
			Descripcion,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdDistrito,
			@pDescripcion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
