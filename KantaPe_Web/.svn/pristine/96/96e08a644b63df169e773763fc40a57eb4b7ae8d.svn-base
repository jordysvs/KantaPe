create  PROCEDURE [dbo].[ListarArtista]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de artistas
'*	Input			: 	@pIdArtista - Id del artista,
						@pNombre - Nombre del artista,
						@pEstado - Estado del artista,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 02/07/2016
'**********************************************************************************
*/
(
	@pIdArtista int = null,
	@pNombre varchar(100) = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY A.Nombre ASC) AS Num_Fila,
			A.IdArtista,
			A.Nombre,
			A.Estado,
			A.UsuarioCreacion,
			A.FechaCreacion,
			A.UsuarioModificacion,
			A.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From Artista A
			Where 
			(@pIdArtista is null or A.IdArtista = @pIdArtista) AND
			(@pNombre is null or A.Nombre like '%' + @pNombre + '%') AND 
			(@pEstado is null or A.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
