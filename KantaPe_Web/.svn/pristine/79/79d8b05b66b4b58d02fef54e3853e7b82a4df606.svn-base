create PROCEDURE [dbo].[ListarAperturaCancionSolicitud]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de AperturaCancionSolicitud
'*	Input			: 	@pIdGenero - Id del AperturaCancionSolicitud,
						@pDescripcion - Descripcion del AperturaCancionSolicitud,
						@pEstado - Estado del AperturaCancionSolicitud,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 30/10/2016
'**********************************************************************************
*/
(
	@pIdAperturaCancionSolicitud int = null,
	@pDescripcion varchar(100) = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY G.Descripcion ASC) AS Num_Fila,
			G.IdAperturaCancionSolicitud,
			G.Descripcion,
			G.Estado,
			G.UsuarioCreacion,
			G.FechaCreacion,
			G.UsuarioModificacion,
			G.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From AperturaCancionSolicitud G
			Where 
			(@pIdAperturaCancionSolicitud is null or G.IdAperturaCancionSolicitud = @pIdAperturaCancionSolicitud) AND
			(@pDescripcion is null or G.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pEstado is null or G.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
