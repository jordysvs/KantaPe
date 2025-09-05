create PROCEDURE [dbo].[CoreActualizarDistrito]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CoreDistrito
'* Input :
		@pIdDistrito - IdDistrito del CoreDistrito
		@pDescripcion - Descripcion del CoreDistrito
		@pEstado - Estado del CoreDistrito
		@pUsuarioModificacion - UsuarioModificacion del CoreDistrito
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdDistrito int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update CoreDistrito
		Set 
			Descripcion = @pDescripcion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdDistrito = @pIdDistrito
END
