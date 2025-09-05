create procedure [dbo].[CoreInsertarArea]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del area
'*	Input			:	@pIdArea - Id del area,
						@pDEscripcion - Descripcion del area,
						@pEstado - Estado del area,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
@pIdArea				int out,
@pCodigo				varchar(20),
@pDescripcion			varchar(100),
@pComision				bit,
@pIdJefe				int,
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdArea = ISNULL(MAX(IdArea),0)+1 from CoreArea Where IdArea > 0

Insert into CoreArea(
IdArea,
Codigo,
Descripcion,
Comision,
IdJefe,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdArea,
@pCodigo,
@pDescripcion,
@pComision,
@pIdJefe,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
