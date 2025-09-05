create Procedure [dbo].[CoreListarPuesto] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de puestos
'*	Input			: 	@pIdPuesto - Id del puesto,
						@pDescripcion - Descripcion del puesto,
						@pEstado - Estado del empleado,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
	@pIdPuesto varchar(20) = null,
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
		ROW_NUMBER() OVER (ORDER BY P.IdPuesto ASC) AS Num_Fila,
			P.IdPuesto,
			P.Descripcion,
			P.Estado,
			P.UsuarioCreacion,
			P.FechaCreacion,
			P.UsuarioModificacion,
			P.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From CorePuesto P
			Where 
			(@pIdPuesto is null or P.IdPuesto = @pIdPuesto) AND
			(@pDescripcion is null or P.Descripcion like '%' + @pDescripcion + '%') AND
			(@pEstado is null or P.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
