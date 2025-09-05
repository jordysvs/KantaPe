create PROCEDURE [dbo].[ListarUnidadMedida]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de UnidadMedida
'* Input :
		@pIdUnidadMedida - IdUnidadMedida del UnidadMedida
		@pDescripcion - Descripcion del UnidadMedida
		@pEstado - Estado del UnidadMedida
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de UnidadMedida
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdUnidadMedida int = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdUnidadMedida ASC) AS Num_Fila,
				T.IdUnidadMedida,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From UnidadMedida T
			Where 
				(@pIdUnidadMedida is null or T.IdUnidadMedida = @pIdUnidadMedida) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
