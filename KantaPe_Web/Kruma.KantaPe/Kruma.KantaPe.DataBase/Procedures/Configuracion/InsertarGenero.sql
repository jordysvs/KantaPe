create Procedure [dbo].[InsertarGenero]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de género
'*	Input			:	@pIdGenero - Id del género,
						@pDescripcion - Descripcion del género,
						@pEstado - Estado del género,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 01/07/2016
'**********************************************************************************
*/
(
@pIdGenero					int out,
@pDescripcion				varchar(100),
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdGenero = ISNULL(MAX(IdGenero),0)+1 from Genero Where IdGenero > 0

Insert into Genero(
IdGenero,
Descripcion,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdGenero,
@pDescripcion,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
