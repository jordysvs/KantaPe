create procedure [dbo].[CoreInsertarTipoDocumento]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del tipo de documento
'*	Input			:	@pIdTipoDocumento - Id del tipo de documento,
						@pCodigo - Código del tipo de documento,
						@pDEscripcion - Descripcion del tipo de documento,
						@pEstado - Estado del area,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
@pIdTipoDocumento		int out,
@pCodigo				varchar(20),
@pDescripcion			varchar(100),
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdTipoDocumento = ISNULL(MAX(IdTipoDocumento),0)+1 from CoreTipoDocumento Where IdTipoDocumento > 0

Insert into CoreTipoDocumento(
IdTipoDocumento,
Codigo,
Descripcion,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdTipoDocumento,
@pCodigo,
@pDescripcion,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
