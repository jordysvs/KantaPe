create PROCEDURE [dbo].[CoreListarPais]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CorePais
'* Input :
		@pIdPais - IdPais del CorePais
		@pDescripcion - Descripcion del CorePais
		@pEstado - Estado del CorePais
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CorePais
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPais int = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdPais ASC) AS Num_Fila,
				T.IdPais,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CorePais T
			Where 
				(@pIdPais is null or T.IdPais = @pIdPais) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
