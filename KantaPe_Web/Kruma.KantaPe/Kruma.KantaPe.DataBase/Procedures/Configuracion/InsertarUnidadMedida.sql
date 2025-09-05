create PROCEDURE [dbo].[InsertarUnidadMedida]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de UnidadMedida
'* Input :
		@pDescripcion - Descripcion del UnidadMedida
		@pEstado - Estado del UnidadMedida
		@pUsuarioCreacion - UsuarioCreacion del UnidadMedida
'* Output : 
		@pIdUnidadMedida - IdUnidadMedida del UnidadMedida
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdUnidadMedida int out
)
AS
BEGIN
		Select @pIdUnidadMedida = IsNull(Max(IdUnidadMedida),0)+1 From UnidadMedida Where IdUnidadMedida > 0

		Insert Into UnidadMedida
		(
			IdUnidadMedida,
			Descripcion,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdUnidadMedida,
			@pDescripcion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
