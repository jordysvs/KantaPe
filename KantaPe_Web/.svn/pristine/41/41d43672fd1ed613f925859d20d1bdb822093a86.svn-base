create PROCEDURE [dbo].[CoreListarDistrito]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CoreDistrito
'* Input :
		@pIdDistrito - IdDistrito del CoreDistrito
		@pDescripcion - Descripcion del CoreDistrito
		@pEstado - Estado del CoreDistrito
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CoreDistrito
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdDistrito int = null, 
	@pDescripcion varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdDistrito ASC) AS Num_Fila,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CoreDistrito T
			Where 
				(@pIdDistrito is null or T.IdDistrito = @pIdDistrito) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
