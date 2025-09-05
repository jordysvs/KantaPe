create PROCEDURE [dbo].[ListarLocalCancionRanking]
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
	@pPalabraClave varchar(100) = null,
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
			--Select 
			Select top (select Convert(int, rtrim(valor)) from [dbo].CoreParametro where IdParametro = 'CANCIONESSOLICITADAS')
			ROW_NUMBER() OVER (ORDER BY AT.Nombre ASC) AS Num_Fila,
			AC.IdAperturaCancion,
			CAN.IdCancion as Cancion_IdCancion,
			CAN.Descripcion as Cancion_Descripcion,
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
			--(select CPD.Direccion as Local_Direccion,cas.descripcion as Cancion_Descripcion, count(1) as Cantidad),
			--CS.IdCancionSolicitud as CancionSolicitud_IdCancionSolicitud,
			--CS.Descripcion as CancionSolicitud_Descripcion,
			--CP.NombreComercial as Empresa_NombreComercial,
			--CPD.Direccion as Local_Direccion,
			COUNT(*) OVER() Total_Filas
			From AperturaCancion AC
			INNER JOIN LocalCancion C on
		    C.IdLocalCancion = AC.IdLocalCancion
			INNER join Cancion CAN on 
			CAN.IdCancion = C.IdCancion
			Join Artista AT on
			AT.IdArtista = C.IdArtista
			INNER Join Album AL on
			AL.IdAlbum = C.IdAlbum
			INNER Join Genero GN on
			GN.IdGenero = C.IdGenero
			INNER Join Idioma ID on
			ID.IdIdioma = C.IdIdioma
			--LEFT Join CancionSolicitud CS on
			--CS.IdCancionSolicitud = C.IdCancionSolicitud
			--LEFT JOIN CorePersona CP on--
			--CP.IdPersona = C.IdEmpresa
			--LEFT JOIN CorePersonaDireccion CPD on--
			--CPD.IdDireccion = C.IdLocal and CPD.IdPersona=C.IdEmpresa
			Where 
			(@pIdEmpresa is null or C.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or C.IdLocal = @pIdLocal) 
			group by AC.IdAperturaCancion,
			C.IdLocalCancion,
			CAN.IdCancion,
			CAN.Descripcion,
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
			AT.IdArtista ,
			AT.Nombre ,
			AL.IdAlbum ,
			AL.Titulo ,
			GN.IdGenero ,
			GN.Descripcion ,
			ID.IdIdioma ,
			ID.Descripcion
			--CS.IdCancionSolicitud ,
			--CS.Descripcion ,
			--CP.NombreComercial ,
			--CPD.Direccion
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina))
		AND (@pPalabraClave is null or 
					(tbl.Cancion_Descripcion like '%' + @pPalabraClave + '%') OR
					(tbl.Artista_Nombre like '%' + @pPalabraClave + '%') OR
					(tbl.Genero_Descripcion like '%' + @pPalabraClave + '%') OR
					(tbl.Idioma_Descripcion like '%' + @pPalabraClave + '%'))
			AND
			(@pIdGenero is null or tbl.Genero_IdGenero = @pIdGenero) AND
			(@pIdIdioma is null or tbl.Idioma_IdIdioma = @pIdIdioma) 
End
