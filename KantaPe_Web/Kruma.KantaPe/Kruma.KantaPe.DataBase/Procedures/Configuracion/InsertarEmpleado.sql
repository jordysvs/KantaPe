create PROCEDURE [dbo].[InsertarEmpleado]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Empleado
'* Input :
		@pIdPersona - IdPersona del Empleado
		@pIdEmpresa - IdEmpresa del Empleado
		@pIdLocal - IdLocal del Empleado
		@pIdArea - IdArea del Empleado
		@pIdPuesto - IdPuesto del Empleado
		@pFechaIngreso - FechaIngreso del Empleado
		@pEstado - Estado del Empleado
'* Output : 
		@pIdEmpleado - IdEmpleado del Empleado
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 26-02-2017
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdEmpresa int = null, 
	@pIdLocal int = null, 
	@pIdArea int = null, 
	@pIdPuesto int = null, 
	@pFechaIngreso DateTime = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null,
	@pIdEmpleado int out
)
AS
BEGIN
		Select @pIdEmpleado = IsNull(Max(IdEmpleado),0)+1 From Empleado Where IdEmpleado > 0
	
		Insert Into Empleado
		(
			IdEmpleado,
			IdPersona,
			IdEmpresa,
			IdLocal,
			IdArea,
			IdPuesto,
			FechaIngreso,
			Estado,
		    UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdEmpleado,
			@pIdPersona,
			@pIdEmpresa,
			@pIdLocal,
			@pIdArea,
			@pIdPuesto,
			@pFechaIngreso,
			@pEstado,
			@pUsuarioCreacion,
			GETDATE(),
			@pUsuarioCreacion,
			GETDATE()
		)
END
