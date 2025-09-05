create PROCEDURE [dbo].[InsertarLocalCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de album
'*	Input			:	@pIdCancion - Id del canción,
						@pTitulo - Titulo de cancion,
						@pIdArtista - Id del artista,
						@pEstado - Estado del Album,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 12/07/2016
'**********************************************************************************
*/
(
@pIdLocalCancion		int out,
@pIdCancion				int,
@pIdArtista				int,
@pIdAlbum				int,
@pIdGenero				int,
@pIdIdioma				int,
@pDecada				varchar(10),
@pVersion				varchar(100),
@pNombreArchivo			varchar(255),
@pAnio					int,
@pLetra					varchar(max),
@pDuracion				int,
@pYoutube				varchar(255),
@pIdCancionSolicitud	int,
@pEstado				char(1),
@pIdEmpresa             int,
@pIdLocal               int,
@pUsuarioCreacion		varchar(20)
)
AS

select @pIdLocalCancion = ISNULL(MAX(IdLocalCancion),0)+1 from LocalCancion Where IdLocalCancion > 0

Insert into LocalCancion(
IdLocalCancion,
IdCancion,
IdArtista,
IdAlbum,
IdGenero,
IdIdioma,
Decada,
Version,
NombreArchivo,
FechaRegistro,
Anio,
Letra,
Duracion,
Youtube,
IdCancionSolicitud,
Estado,
IdEmpresa,
IdLocal,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdLocalCancion,
@pIdCancion,
@pIdArtista,
@pIdAlbum,
@pIdGenero,
@pIdIdioma,
@pDecada,
@pVersion,
@pNombreArchivo,
GETDATE(),
@pAnio,
@pLetra,
@pDuracion,
@pYoutube,
@pIdCancionSolicitud,
@pEstado,
@pIdEmpresa,
@pIdLocal,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
