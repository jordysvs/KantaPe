create Procedure [dbo].[InsertarAlbum]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de album
'*	Input			:	@pIdAlbum - Id del album,
						@pIdArtista - Id del artista,
						@pTitulo - Titulo del Album,
						@pEstado - Estado del Album,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 03/07/2016
'**********************************************************************************
*/
(
@pIdAlbum				int out,
@pIdArtista				int,
@pTitulo				varchar(100),
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdAlbum = ISNULL(MAX(IdAlbum),0)+1 from Album Where IdAlbum > 0

Insert into Album(
IdAlbum,
IdArtista,
Titulo,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdAlbum,
@pIdArtista,
@pTitulo,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
