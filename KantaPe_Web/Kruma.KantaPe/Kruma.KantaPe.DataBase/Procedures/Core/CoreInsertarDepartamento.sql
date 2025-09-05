create PROCEDURE [dbo].[CoreInsertarDepartamento]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de CoreDepartamento
'* Input :
		@pDescripcion - Descripcion del CoreDepartamento
		@pEstado - Estado del CoreDepartamento
		@pUsuarioCreacion - UsuarioCreacion del CoreDepartamento
'* Output : 
		@pIdDepartamento - IdDepartamento del CoreDepartamento
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdDepartamento int out
)
AS
BEGIN
		Select @pIdDepartamento = IsNull(Max(IdDepartamento),0)+1 From CoreDepartamento Where IdDepartamento > 0

		Insert Into CoreDepartamento
		(
			IdDepartamento,
			Descripcion,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdDepartamento,
			@pDescripcion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
