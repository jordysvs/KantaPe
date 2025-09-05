create Procedure [dbo].[InsertarCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de género
'*	Input			:	@pIdCancionSimple - Id del género,
						@pDescripcion - Descripcion del género,
						@pEstado - Estado del género,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 01/07/2016
'**********************************************************************************
*/
(
@pIdCancion					int out,
@pDescripcion				varchar(100),
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdCancion = ISNULL(MAX(IdCancion),0)+1 from Cancion Where IdCancion > 0

Insert into Cancion(
IdCancion,
Descripcion,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdCancion,
@pDescripcion,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
