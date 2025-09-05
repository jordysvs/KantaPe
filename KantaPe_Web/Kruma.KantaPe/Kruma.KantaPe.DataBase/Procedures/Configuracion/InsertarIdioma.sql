create Procedure [dbo].[InsertarIdioma]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de idioma
'*	Input			:	@pIdIdioma - Id del idioma,
						@pDescripcion - Descripcion del idioma,
						@pEstado - Estado del idioma,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 01/07/2016
'**********************************************************************************
*/
(
@pIdIdioma					int out,
@pDescripcion				varchar(100),
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdIdioma = ISNULL(MAX(IdIdioma),0)+1 from Idioma Where IdIdioma > 0

Insert into Idioma(
IdIdioma,
Descripcion,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdIdioma,
@pDescripcion,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
