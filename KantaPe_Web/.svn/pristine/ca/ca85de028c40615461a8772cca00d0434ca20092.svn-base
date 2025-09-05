create PROCEDURE [dbo].[CoreListarDepartamento]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CoreDepartamento
'* Input :
		@pIdDepartamento - IdDepartamento del CoreDepartamento
		@pDescripcion - Descripcion del CoreDepartamento
		@pEstado - Estado del CoreDepartamento
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CoreDepartamento
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdDepartamento int = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdDepartamento ASC) AS Num_Fila,
				T.IdDepartamento,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CoreDepartamento T
			Where 
				(@pIdDepartamento is null or T.IdDepartamento = @pIdDepartamento) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
