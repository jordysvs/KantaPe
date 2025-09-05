create PROCEDURE [dbo].[ActualizarUnidadMedida]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de UnidadMedida
'* Input :
		@pIdUnidadMedida - IdUnidadMedida del UnidadMedida
		@pDescripcion - Descripcion del UnidadMedida
		@pEstado - Estado del UnidadMedida
		@pUsuarioCreacion - UsuarioCreacion del UnidadMedida
		@pFechaCreacion - FechaCreacion del UnidadMedida
		@pUsuarioModificacion - UsuarioModificacion del UnidadMedida
		@pFechaModificacion - FechaModificacion del UnidadMedida
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdUnidadMedida int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update UnidadMedida
		Set Descripcion = @pDescripcion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdUnidadMedida = @pIdUnidadMedida
END
