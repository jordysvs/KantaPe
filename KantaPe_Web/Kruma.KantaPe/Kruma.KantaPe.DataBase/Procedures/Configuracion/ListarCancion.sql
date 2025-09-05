create PROCEDURE [dbo].[ListarCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de géneros
'*	Input			: 	@pIdCancionSimple - Id del género,
						@pDescripcion - Descripcion del género,
						@pEstado - Estado del auto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
	@pIdCancion int = null,
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
		ROW_NUMBER() OVER (ORDER BY C.Descripcion ASC) AS Num_Fila,
			C.IdCancion,
			C.Descripcion,
			C.Estado,
			C.UsuarioCreacion,
			C.FechaCreacion,
			C.UsuarioModificacion,
			C.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From Cancion C
			Where 
			(@pIdCancion is null or C.IdCancion = @pIdCancion) AND
			(@pDescripcion is null or C.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pEstado is null or C.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
