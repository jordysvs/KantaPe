create PROCEDURE [dbo].[InsertarInsumo]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Insumo
'* Input :
		@pCodigo - Codigo del Insumo
		@pDescripcion - Descripcion del Insumo
		@pIdUnidadMedida - IdUnidadMedida del Insumo
		@pEstado - Estado del Insumo
		@pUsuarioCreacion - UsuarioCreacion del Insumo
		@pFechaCreacion - FechaCreacion del Insumo
		@pUsuarioModificacion - UsuarioModificacion del Insumo
		@pFechaModificacion - FechaModificacion del Insumo
'* Output : 
		@pIdInsumo - IdInsumo del Insumo
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pCodigo varchar(20) = null, 
	@pDescripcion varchar(100) = null, 
	@pIdUnidadMedida int = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdInsumo int out
)
AS
BEGIN
		Select @pIdInsumo = IsNull(Max(IdInsumo),0)+1 From Insumo Where IdInsumo > 0

		Insert Into Insumo
		(
			IdInsumo,
			Codigo,
			Descripcion,
			IdUnidadMedida,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdInsumo,
			@pCodigo,
			@pDescripcion,
			@pIdUnidadMedida,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
