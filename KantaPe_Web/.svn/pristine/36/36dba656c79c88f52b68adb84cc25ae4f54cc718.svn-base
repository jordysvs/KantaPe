create Procedure [dbo].[CoreListarArea] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de areas
'*	Input			: 	@pIdArea - Id del area,
						@pDescripcion - Descripcion del area,
						@pEstado - Estado del empleado,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
	@pIdArea varchar(20) = null,
	@pCodigo varchar(20) = null,
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
		ROW_NUMBER() OVER (ORDER BY A.IdArea ASC) AS Num_Fila,
			A.IdArea,
			A.Codigo,
			A.Descripcion,
			A.Comision,
			A.IdJefe,
			A.Estado,
			A.UsuarioCreacion,
			A.FechaCreacion,
			A.UsuarioModificacion,
			A.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From CoreArea A
			Where 
			(@pIdArea is null or A.IdArea = @pIdArea) AND
			(@pCodigo is null or A.Codigo like '&' + @pCodigo + '%') AND
			(@pDescripcion is null or A.Descripcion like '&' + @pDescripcion + '%') AND
			(@pEstado is null or A.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
