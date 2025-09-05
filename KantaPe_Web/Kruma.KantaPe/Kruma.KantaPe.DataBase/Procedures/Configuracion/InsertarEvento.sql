create Procedure [dbo].[InsertarEvento]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del evento
'*	Input			:	@pIdLocal - Id del local,
						@pNombre - Nombre del evento,
						@pDescripcion - Descripción del evento,
						@pFechaEvento - Fecha del evento,
						@pEstado - Estado del evento,
						@pUsuarioCreacion - Usuario creación
'*	Output			:	@pIdOferta - Id del evento,
'*	Creado Por		: John Castillo
'*	Fec Creación		: 08/08/2016
'**********************************************************************************
*/
(
@pIdLocal					int,
@pNombre					varchar(100),
@pDescripcion				varchar(500),
@pFechaEvento				datetime,
@pIdImagen					int,
@pEstado					char(1),
@pUsuarioCreacion			varchar(20),
@pIdEvento					int out
)
AS

select @pIdEvento = ISNULL(MAX(IdEvento),0)+1 
from Evento Where IdLocal = @pIdLocal AND IdEvento > 0

Insert into Evento(
IdLocal,
IdEvento,
Nombre,
Descripcion,
FechaEvento,
IdImagen,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdLocal,
@pIdEvento,
@pNombre,
@pDescripcion,
@pFechaEvento,
@pIdImagen,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
