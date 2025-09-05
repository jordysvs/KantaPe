create PROCEDURE [dbo].[ListarUbicacionTipo]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de tipo de ubicaciones
'*	Input			: 	@pIdUbicacionTipo - Id tipo de ubicación,
						@pDescripcion - Descripción del tipo de ubicación,
						@pEstado - Estado del tipo de ubicación,
						@pNumPagina - Número de página,
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 03/08/2016
'**********************************************************************************
*/
(
	@pIdUbicacionTipo int = null,
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
			T.IdUbicacionTipo,
			T.Descripcion,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From UbicacionTipo T
			Where 
			(@pIdUbicacionTipo is null or T.IdUbicacionTipo = @pIdUbicacionTipo) AND
			(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
