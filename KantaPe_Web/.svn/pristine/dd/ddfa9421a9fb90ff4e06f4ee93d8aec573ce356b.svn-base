create PROCEDURE [dbo].[ListarIdioma]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de idiomas
'*	Input			: 	@pIdIdioma - Id del idioma,
						@pDescripcion - Descripcion del idioma,
						@pEstado - Estado del auto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
	@pIdIdioma int = null,
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
		ROW_NUMBER() OVER (ORDER BY I.Descripcion ASC) AS Num_Fila,
			I.IdIdioma,
			I.Descripcion,
			I.Estado,
			I.UsuarioCreacion,
			I.FechaCreacion,
			I.UsuarioModificacion,
			I.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From Idioma I
			Where 
			(@pIdIdioma is null or I.IdIdioma = @pIdIdioma) AND
			(@pDescripcion is null or I.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pEstado is null or I.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
