create PROCEDURE [dbo].[ActualizarInsumo]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Insumo
'* Input :
		@pIdInsumo - IdInsumo del Insumo
		@pCodigo - Codigo del Insumo
		@pDescripcion - Descripcion del Insumo
		@pIdUnidadMedida - IdUnidadMedida del Insumo
		@pEstado - Estado del Insumo
		@pUsuarioModificacion - UsuarioModificacion del Insumo
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdInsumo int = null, 
	@pCodigo varchar(20) = null, 
	@pDescripcion varchar(100) = null, 
	@pIdUnidadMedida int = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update Insumo
		Set
			Codigo = @pCodigo,
			Descripcion = @pDescripcion,
			IdUnidadMedida = @pIdUnidadMedida,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdInsumo = @pIdInsumo
END
