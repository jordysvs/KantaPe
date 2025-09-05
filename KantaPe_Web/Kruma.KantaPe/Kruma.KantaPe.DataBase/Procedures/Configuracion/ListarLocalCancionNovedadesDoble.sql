create PROCEDURE [dbo].[ListarLocalCancionNovedadesDoble]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de canciones
'*	Input			: 	@pIdCancion - Id de la canción,
						@pTitulo - Titulo del album,
						@pIdArtista - Id del artista,
						@pArtistaNombre - Nombre del artista
						@pIdAlbum - Id del álbum,
						@pAlbumTitulo - Titulo del album
						@pIdGenero - Id del género,
						@pIdIdioma - Id del idioma,
						@pDecada - Década de canción,
						@pAnio - Año de canción,
						@pYoutube - Enlace de cancion,
						@pIdCancionSolicitud - Id de canción solicitud,
						@pEstado - Estado de la canción,
						@pNumPagina - Número de página,
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 12/07/2016
'**********************************************************************************
*/
(
	@pIdLocalCancion int = null,
	@pTitulo varchar(300) = null,
	@pIdArtista int = null,
	@pArtistaNombre varchar(100) = null,
	@pIdAlbum int = null,
	@pAlbumTitulo varchar(100) = null,
	@pIdGenero int = null,
	@pIdIdioma int = null,
	@pDecada varchar(10) = null,
	@pAnio int = null,
	@pAnioFiltro varchar(10) = null,
	@pYoutube varchar(255) = null,
	@pIdCancionSolicitud int = null,
	@pPalabraClave1 varchar(100) = null,
	@pPalabraClave2 varchar(100) = null,
	@pEstado char(1) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY AT.Nombre ASC) AS Num_Fila,
			C.IdLocalCancion,
			C.IdEmpresa,
			C.IdLocal,
			C.IdCancion,
			C.IdArtista,
			C.IdAlbum,
			C.IdGenero,
			C.IdIdioma,
			C.Decada,
			C.Version,
			C.NombreArchivo,
			C.FechaRegistro,
			C.Anio,
			C.Letra,
			C.Duracion,
			C.Youtube,
			C.IdCancionSolicitud,
			C.Estado,
			C.UsuarioCreacion,
			C.FechaCreacion,
			C.UsuarioModificacion,
			C.FechaModificacion,
			AT.IdArtista as Artista_IdArtista,
			AT.Nombre as Artista_Nombre,
			AL.IdAlbum as Album_IdAlbum,
			AL.Titulo as Album_Titulo,
			GN.IdGenero as Genero_IdGenero,
			GN.Descripcion as Genero_Descripcion,
			ID.IdIdioma as Idioma_IdIdioma,
			ID.Descripcion as Idioma_Descripcion,
			CS.IdCancionSolicitud as CancionSolicitud_IdCancionSolicitud,
			CS.Descripcion as CancionSolicitud_Descripcion,
			CP.NombreComercial as Empresa_NombreComercial,
			CPD.Direccion as Local_Direccion,
			CAN.IdCancion as Cancion_IdCancion,
			CAN.Descripcion as Cancion_Descripcion,
			COUNT(*) OVER() Total_Filas
			From LocalCancion C
			join Cancion CAN on 
			CAN.IdCancion = C.IdCancion
			Join Artista AT on
			AT.IdArtista = C.IdArtista
			left Join Album AL on
			AL.IdAlbum = C.IdAlbum
			Join Genero GN on
			GN.IdGenero = C.IdGenero
			Join Idioma ID on
			ID.IdIdioma = C.IdIdioma
			left Join CancionSolicitud CS on
			CS.IdCancionSolicitud = C.IdCancionSolicitud
			LEFT JOIN CorePersona CP on
			CP.IdPersona = C.IdEmpresa
			LEFT JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = C.IdLocal and CPD.IdPersona=C.IdEmpresa
			Where 
			(@pIdLocalCancion is null or C.IdLocalCancion = @pIdLocalCancion) AND
			(@pTitulo is null or CAN.Descripcion like '%' + @pTitulo + '%') AND
			(@pIdArtista is null or AT.IdArtista = @pIdArtista) AND
			(@pArtistaNombre is null or AT.Nombre like '%' + @pArtistaNombre + '%') AND
			(@pIdAlbum is null or AL.IdAlbum = @pIdAlbum) AND
			(@pAlbumTitulo is null or AL.Titulo like '%' + @pAlbumTitulo + '%') AND
			(@pIdGenero is null or GN.IdGenero = @pIdGenero) AND
			(@pIdIdioma is null or ID.IdIdioma = @pIdIdioma) AND
			(@pDecada is null or C.Decada like '%' + @pDecada + '%') AND
			(@pAnio is null or C.Anio = @pAnio) AND
			(@pAnioFiltro is null or CAST(C.Anio as varchar(MAX)) like '%' + @pAnioFiltro + '%') AND
			(@pYoutube is null or C.Youtube like '%' + @pYoutube + '%') AND
			(@pIdCancionSolicitud is null or C.IdCancionSolicitud = @pIdCancionSolicitud) AND
			(@pEstado is null or C.Estado = @pEstado) AND
			(@pIdEmpresa is null or C.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or C.IdLocal = @pIdLocal) AND
			(@pPalabraClave1 is null or 
					(CAN.Descripcion like '%' + @pPalabraClave1 + '%') OR
					(AT.Nombre like '%' + @pPalabraClave1 + '%') OR
					(GN.Descripcion like '%' + @pPalabraClave1 + '%') OR
					(ID.Descripcion like '%' + @pPalabraClave1 + '%'))  AND
			(@pPalabraClave2 is null or 
					(CAN.Descripcion like '%' + @pPalabraClave2 + '%') OR
					(AT.Nombre like '%' + @pPalabraClave2 + '%') OR
					(GN.Descripcion like '%' + @pPalabraClave2 + '%') OR
					(ID.Descripcion like '%' + @pPalabraClave2 + '%'))  AND
			C.FechaCreacion >= [dbo].getdatesys() - ((select convert(int, rtrim(valor)) from [dbo].CoreParametro where IdParametro = 'DIASNOVEDADES')) AND
			C.FechaCreacion <= [dbo].getdatesys()
			

		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
