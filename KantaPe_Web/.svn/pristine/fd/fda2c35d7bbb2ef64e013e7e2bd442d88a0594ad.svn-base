create PROCEDURE [dbo].[ActualizarSolicitudCancion]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de SolicitudCancion
'* Input :
		@pIdSolicitudCancion - IdSolicitudCancion del SolicitudCancion
		@pCancion - Cancion del SolicitudCancion
		@pArtista - Artista del SolicitudCancion
		@pAlbum - Album del SolicitudCancion
		@pIdioma - Idioma del SolicitudCancion
		@pGenero - Genero del SolicitudCancion
		@pYoutube - Youtube del SolicitudCancion
		@pEstado - Estado del SolicitudCancion
'* Output : Ninguno
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 26-02-2017
'**********************************************************************************
*/
(
	@pIdSolicitudCancion int = null, 
	@pCancion varchar(100) = null, 
	@pArtista varchar(100) = null, 
	@pAlbum varchar(100) = null, 
	@pIdioma varchar(100) = null, 
	@pGenero varchar(100) = null, 
	@pYoutube varchar(100) = null, 
	@pEstado varchar(1) = null,
	@pMotivo varchar(500) = null,
	@pUsuarioModificacion varchar(100) = null
)
AS
BEGIN
		Update SolicitudCancion
		Set 
			Cancion = @pCancion,
			Artista = @pArtista,
			Album = @pAlbum,
			Idioma = @pIdioma,
			Genero = @pGenero,
			Youtube = @pYoutube,
			Estado = @pEstado,
			Motivo = @pMotivo,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = GETDATE()
		Where
			IdSolicitudCancion= @pIdSolicitudCancion
END
