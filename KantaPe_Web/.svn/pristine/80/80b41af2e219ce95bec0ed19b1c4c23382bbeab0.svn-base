create PROCEDURE [dbo].[ActualizarLocalCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de canción
'*	Input			: 	@pIdCancion - Id de canción,
						@pTitulo - Titulo de cancion,
						@pIdArtista - Id del artista,
						@pEstado - Estado de canción,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 12/07/2016
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
@pUsuarioModificacion	varchar(20)
)
As
Begin
	update LocalCancion
	set 
	IdCancion = @pIdCancion,
	IdArtista = @pIdArtista,
	IdAlbum = @pIdAlbum,
	IdGenero = @pIdGenero,
	IdIdioma = @pIdIdioma,
	Decada = @pDecada,
	Version = @pVersion,
	NombreArchivo = @pNombreArchivo,
	Anio = @pAnio,
	Letra = @pLetra,
	Duracion = @pDuracion,
	Youtube = @pYoutube,
	IdCancionSolicitud = @pIdCancionSolicitud,
	Estado = @pEstado,
	IdEmpresa = @pIdEmpresa,
	IdLocal = @pIdLocal,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdLocalCancion = @pIdLocalCancion
End
