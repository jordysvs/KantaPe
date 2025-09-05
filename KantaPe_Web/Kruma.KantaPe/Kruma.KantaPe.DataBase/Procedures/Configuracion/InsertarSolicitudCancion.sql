create Procedure [dbo].[InsertarSolicitudCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de solicitud canción
'*	Input			:	@pIdSolicitudCancion - Id de solicitud canción,
						@pCancion - Nombre de la canción,
						@pArtista - Nombre del artista,
						@pAlbum - Nombre del álbum,
						@pIdioma - Nombre del idioma,
						@pGenero - Nombre del género,
						@pYoutube - Link de youtube,
						@pEstado - Estado de solicitud canción,
						@pUsuarioCreacion - Usuario creación
'*	Output			:	<Ninguno>
'*	Creado Por		:	Carlos Gómez
'*	Fec Creación	:	24/08/2016
'**********************************************************************************
*/
(
@pIdSolicitudCancion		int out,
@pCancion					varchar(100),
@pArtista					varchar(100),
@pAlbum						varchar(100),
@pIdioma					varchar(100),
@pGenero					varchar(100),
@pYoutube					varchar(100),
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdSolicitudCancion = ISNULL(MAX(IdSolicitudCancion),0)+1 from SolicitudCancion Where IdSolicitudCancion > 0

Insert into SolicitudCancion(
IdSolicitudCancion,
Cancion,
Artista,
Album,
Idioma,
Genero,
Youtube,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdSolicitudCancion,
@pCancion,
@pArtista,
@pAlbum,
@pIdioma,
@pGenero,
@pYoutube,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
