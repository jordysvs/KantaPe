create Procedure [dbo].[InsertarArtista]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de artista
'*	Input			:	@pIdArtista - Id del artista,
						@pNombre - Nombre del artista,
						@pEstado - Estado del artista,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 02/07/2016
'**********************************************************************************
*/
(
@pIdArtista					int out,
@pNombre					varchar(100),
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdArtista = ISNULL(MAX(IdArtista),0)+1 from Artista Where IdArtista > 0

Insert into Artista(
IdArtista,
Nombre,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdArtista,
@pNombre,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
