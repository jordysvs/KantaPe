create Procedure [dbo].[InsertarOferta]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de la oferta
'*	Input			:	@pIdLocal - Id del local,
						@pNombre - Nombre de la oferta,
						@pDescripcion - Descripción de la oferta,
						@pFechaOferta - Fecha de la oferta,
						@pFechaVencimiento - Fecha de vencimiento,
						@pEstado - Estado del artista,
						@pUsuarioCreacion - Usuario creación
'*	Output			:	@pIdOferta - Id de la oferta,
'*	Creado Por		: John Castillo
'*	Fec Creación		: 08/08/2016
'**********************************************************************************
*/
(
@pIdLocal					int = null,
@pNombre					varchar(100) = null,
@pDescripcion				varchar(500) = null,
@pFechaOferta				datetime = null,
@pFechaVencimiento			datetime = null,
@pIdImagen					int = null,
@pEstado					char(1) = null,
@pUsuarioCreacion			varchar(20) = null,
@pIdOferta					int out
)
AS

select @pIdOferta = ISNULL(MAX(IdOferta),0)+1 
from Oferta Where IdLocal = @pIdLocal AND IdOferta > 0

Insert into Oferta(
IdLocal,
IdOferta,
Nombre,
Descripcion,
FechaOferta,
FechaVencimiento,
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
@pIdOferta,
@pNombre,
@pDescripcion,
@pFechaOferta,
@pFechaVencimiento,
@pIdImagen,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
