create PROCEDURE [dbo].[CoreActualizarProvincia]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CoreProvincia
'* Input :
		@pIdProvincia - IdProvincia del CoreProvincia
		@pDescripcion - Descripcion del CoreProvincia
		@pEstado - Estado del CoreProvincia
		@pUsuarioModificacion - UsuarioModificacion del CoreProvincia
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdProvincia int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update CoreProvincia
		Set 
			IdProvincia = @pIdProvincia,
			Descripcion = @pDescripcion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdProvincia= @pIdProvincia
END
