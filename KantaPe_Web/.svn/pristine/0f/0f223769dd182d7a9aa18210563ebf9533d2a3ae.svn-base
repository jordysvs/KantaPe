create  PROCEDURE [dbo].[ListarAlbum]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de albumes
'*	Input			: 	@pIdAlbum - Id del album,
						@pIdArtista - Id del artista
						@pTitulo - Titulo del album,
						@pEstado - Estado del auto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 03/07/2016
'**********************************************************************************
*/
(
	@pIdAlbum int = null,
	@pIdArtista int = null,
	@pArtistaNombre varchar(100) = null,
	@pTitulo varchar(100) = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY AT.Nombre ASC, A.Titulo ASC) AS Num_Fila,
			A.IdAlbum,
			A.IdArtista,
			A.Titulo,
			A.Estado,
			A.UsuarioCreacion,
			A.FechaCreacion,
			A.UsuarioModificacion,
			A.FechaModificacion,
			AT.Nombre as Artista_Descripcion,
			COUNT(*) OVER() Total_Filas
			From Album A
			Left Join Artista AT on
			AT.IdArtista = A.IdArtista
			Where 
			(@pIdAlbum is null or A.IdAlbum = @pIdAlbum) AND
			(@pIdArtista is null or A.IdArtista = @pIdArtista) AND
			(@pArtistaNombre is null or AT.Nombre like '%' + @pArtistaNombre + '%') AND
			(@pTitulo is null or A.Titulo like '%' + @pTitulo + '%') AND 
			(@pEstado is null or A.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
