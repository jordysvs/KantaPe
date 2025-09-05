create PROCEDURE [dbo].[ListarSolicitudCancion]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de SolicitudCancion
'* Input :
		@pIdSolicitudCancion - IdSolicitudCancion del SolicitudCancion
		@pCancion - Cancion del SolicitudCancion
		@pArtista - Artista del SolicitudCancion
		@pAlbum - Album del SolicitudCancion
		@pIdioma - Idioma del SolicitudCancion
		@pGenero - Genero del SolicitudCancion
		@pYoutube - Youtube del SolicitudCancion
		@pEstado - Estado del SolicitudCancion
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de SolicitudCancion
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 23-02-2017
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
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdSolicitudCancion ASC) AS Num_Fila,
				T.IdSolicitudCancion,
				T.Cancion,
				T.Artista,
				T.Album,
				T.Idioma,
				T.Genero,
				T.Youtube,
				T.Estado,
				T.UsuarioCreacion,
				T.UsuarioModificacion,
				T.FechaCreacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From SolicitudCancion T
			Where 
			
				--(T.Estado !='A') AND
				(@pIdSolicitudCancion is null or T.IdSolicitudCancion = @pIdSolicitudCancion) AND
				(@pCancion is null or T.Cancion like '%' + @pCancion + '%') AND
				(@pArtista is null or T.Artista like '%' + @pArtista + '%') AND
				(@pAlbum is null or T.Album like '%' + @pAlbum + '%') AND
				(@pIdioma is null or T.Idioma like '%' + @pIdioma + '%') AND
				(@pGenero is null or T.Genero like '%' + @pGenero + '%') AND
				(@pYoutube is null or T.Youtube like '%' + @pYoutube + '%') AND
				(@pEstado is null or T.Estado like '%' + @pEstado + '%') AND
				(T.Estado='P')  

		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
