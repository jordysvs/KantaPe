create procedure [dbo].[CoreInsertarPuesto]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del puesto
'*	Input			:	@pIdPuesto - Id del puesto,
						@pDEscripcion - Descripcion del puesto,
						@pEstado - Estado del puesto,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
@pIdPuesto				int out,
@pDescripcion			varchar(100),
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdPuesto = ISNULL(MAX(IdPuesto),0)+1 from CorePuesto Where IdPuesto > 0

Insert into CorePuesto(
IdPuesto,
Descripcion,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdPuesto,
@pDescripcion,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
