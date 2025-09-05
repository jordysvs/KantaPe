create PROCEDURE [dbo].[CoreActualizarDepartamento]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de CoreDepartamento
'* Input :
		@pIdDepartamento - IdDepartamento del CoreDepartamento
		@pDescripcion - Descripcion del CoreDepartamento
		@pEstado - Estado del CoreDepartamento
		@pUsuarioModificacion - UsuarioModificacion del CoreDepartamento
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdDepartamento int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update CoreDepartamento
		Set 
			Descripcion = @pDescripcion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdDepartamento = @pIdDepartamento
END
