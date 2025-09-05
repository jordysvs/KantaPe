create PROCEDURE [dbo].[ListarGenero]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de géneros
'*	Input			: 	@pIdGenero - Id del género,
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
	@pIdGenero int = null,
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
			G.IdGenero,
			G.Descripcion,
			G.Estado,
			G.UsuarioCreacion,
			G.FechaCreacion,
			G.UsuarioModificacion,
			G.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From Genero G
			Where 
			(@pIdGenero is null or G.IdGenero = @pIdGenero) AND
			(@pDescripcion is null or G.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pEstado is null or G.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
