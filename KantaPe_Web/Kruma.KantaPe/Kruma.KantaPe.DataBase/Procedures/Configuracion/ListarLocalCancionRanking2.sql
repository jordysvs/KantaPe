create PROCEDURE [dbo].[ListarLocalCancionRanking2]
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
	Select top (select Convert(int, rtrim(valor)) from [dbo].CoreParametro where IdParametro = 'CANCIONESSOLICITADAS')
            cantidad as Cantidad,
			Cancion_IdLocalCancion as Cancion_IdLocalCancion,
			Cancion_IdEmpresa as Cancion_IdEmpresa,
			Cancion_IdLocal as Cancion_IdLocal,
			Artista_Nombre as Artista_Nombre,
			Album_IdAlbum as Album_IdAlbum,
			Album_Titulo as Album_Titulo,
			Genero_IdGenero as Genero_IdGenero,
			Genero_Descripcion as Genero_Descripcion,
			Idioma_IdIdioma as Idioma_IdIdioma,
			Idioma_Descripcion as Idioma_Descripcion,
			Cancion_Descripcion as Cancion_Descripcion,
			--Local
		    Local_Direccion as Local_Direccion
            From 
				(select 
						C.IdLocalCancion as Cancion_IdLocalCancion,
						C.IdEmpresa as Cancion_IdEmpresa,
						C.IdLocal as Cancion_IdLocal,
						AT.IdArtista as Artista_IdArtista,
						AT.Nombre as Artista_Nombre,
						AL.IdAlbum as Album_IdAlbum,
						AL.Titulo as Album_Titulo,
						GN.IdGenero as Genero_IdGenero,
						GN.Descripcion as Genero_Descripcion,
						ID.IdIdioma as Idioma_IdIdioma,
						ID.Descripcion as Idioma_Descripcion,
						CPD.Direccion as Local_Direccion,
						CAS.Descripcion as Cancion_Descripcion, 
						count(1) as Cantidad 
				from AperturaCancion AC
				inner join LocalCancion C on 
				C.IdLocalCancion = AC.IdLocalCancion
				inner join Cancion CAS on 
				CAS.idcancion = C.idcancion
				Join Artista AT on
				AT.IdArtista = C.IdArtista
				INNER Join Album AL on
				AL.IdAlbum = C.IdAlbum
				INNER Join Genero GN on
				GN.IdGenero = C.IdGenero
				INNER Join Idioma ID on
				ID.IdIdioma = C.IdIdioma
				INNER JOIN Local LO on
				LO.IdLocal = AC.IdLocal
				INNER JOIN CorePersona EM on
				EM.IdPersona = LO.IdEmpresa
				INNER JOIN CorePersonaDireccion CPD on
				CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa
				
			where 
			(@pIdEmpresa is null or C.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or C.IdLocal = @pIdLocal) AND
			 (@pPalabraClave is null or 
					(CAS.Descripcion like '%' + @pPalabraClave + '%') OR
					(AT.Nombre like '%' + @pPalabraClave + '%') OR
					(GN.Descripcion like '%' + @pPalabraClave + '%') OR
					(ID.Descripcion like '%' + @pPalabraClave + '%'))
			AND
			(@pIdGenero is null or GN.IdGenero = @pIdGenero) AND
			(@pIdIdioma is null or ID.IdIdioma = @pIdIdioma) 
			group by	C.IdLocalCancion ,
						C.IdEmpresa ,
						C.IdLocal ,
						AT.IdArtista ,
						AT.Nombre ,
						AL.IdAlbum ,
						AL.Titulo ,
						GN.IdGenero ,
						GN.Descripcion ,
						ID.IdIdioma ,
						ID.Descripcion ,
						CPD.Direccion,
						CAS.Descripcion
			)A		
		   ORDER BY Cantidad desc
END
