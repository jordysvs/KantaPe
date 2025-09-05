create Procedure [dbo].[CoreActualizarEmpleado]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del empleado
	para el usuario
'*	Input			: 	@pIdEmpleado - Id del empleado
						@pIdPersona - Id de la persona
						@pIdArea - Id del area,
						@pIdPuesto - Id del puesto,
						@pEstado - Estado del empleado
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
	@pIdEmpleado int,
	@pIdPersona int,
	@pIdArea int,
	@pIdPuesto int,
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CoreEmpleado
	set 
	IdPersona = @pIdPersona,
	IdArea = @pIdArea,
	IdPuesto = @pIdPuesto,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdEmpleado = @pIdEmpleado
End
