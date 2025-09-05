create PROCEDURE [dbo].[CoreActualizarPais]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CorePais
'* Input :
		@pIdPais - IdPais del CorePais
		@pDescripcion - Descripcion del CorePais
		@pEstado - Estado del CorePais
		@pUsuarioModificacion - UsuarioModificacion del CorePais
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPais int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update CorePais
		Set 
			Descripcion = @pDescripcion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdPais = @pIdPais
END
