create procedure [dbo].[CoreInsertarEmpleado]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del empleado
	para el usuario
'*	Input			:	@pIdEmpleado - Id del empleado,
						@pIdPersona	- Id de la persona,
						@pIdArea - Id del area,
						@pIdPuesto - Id del puesto,
						@pEstado - Estado del empleado,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
@pIdEmpleado			int out,
@pIdPersona				int,
@pIdArea				int,
@pIdPuesto				int,
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdEmpleado = ISNULL(MAX(IdEmpleado),0)+1 from CoreEmpleado Where IdEmpleado > 0

Insert into CoreEmpleado(
IdEmpleado,
IdPersona,
IdArea,
IdPuesto,
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
@pIdArea,
@pIdPuesto,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
