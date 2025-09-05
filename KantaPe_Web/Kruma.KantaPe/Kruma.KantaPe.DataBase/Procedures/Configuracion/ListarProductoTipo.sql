create PROCEDURE [dbo].[ListarProductoTipo]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de tipo de productos
'*	Input			: 	@pIdProductoTipo - Id tipo de producto,
						@pDescripcion - Descripción del tipo de producto,
						@pEstado - Estado del tipo de producto,
						@pNumPagina - Número de página,
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 18/08/2016
'**********************************************************************************
*/
(
	@pIdProductoTipo int = null,
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
		ROW_NUMBER() OVER (ORDER BY T.Descripcion ASC) AS Num_Fila,
			T.IdProductoTipo,
			T.Descripcion,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From ProductoTipo T
			Where 
			(@pIdProductoTipo is null or T.IdProductoTipo = @pIdProductoTipo) AND
			(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
