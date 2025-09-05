create PROCEDURE [dbo].[CoreListarProvincia]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CoreProvincia
'* Input :
		@pIdProvincia - IdProvincia del CoreProvincia
		@pDescripcion - Descripcion del CoreProvincia
		@pEstado - Estado del CoreProvincia
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CoreProvincia
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdProvincia int = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdProvincia ASC) AS Num_Fila,
				T.IdProvincia,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CoreProvincia T
			Where 
				(@pIdProvincia is null or T.IdProvincia = @pIdProvincia) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
