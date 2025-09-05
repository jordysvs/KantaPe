create Procedure [dbo].[ActualizarEmpleado]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del género
'*	Input			: 	@pIdGenero - Id del género,
						@pDescripcion - Descripción del género,
						@pEstado - Estado del genero,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
@pIdEmpleado int = null,
@pIdPersona	int = null,
@pIdEmpresa int = null,   
@pIdLocal int = null,
@pIdArea int = null, 
@pIdPuesto int = null,
@pFechaIngreso datetime = null,        
@pEstado					char(1),
@pUsuarioModificacion		varchar(20)
)
As
Begin
	update Empleado
	set 
	IdPersona =@pIdPersona,
	IdEmpresa = @pIdEmpresa,
	IdLocal = @pIdLocal,
	IdArea = @pIdArea,
	IdPuesto = @pIdPuesto,
	FechaIngreso = @pFechaIngreso,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdEmpleado = @pIdEmpleado
End
