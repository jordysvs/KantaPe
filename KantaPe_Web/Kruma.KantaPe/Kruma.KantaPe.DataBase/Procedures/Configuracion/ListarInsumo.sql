create PROCEDURE [dbo].[ListarInsumo]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Insumo
'* Input :
		@pIdInsumo - IdInsumo del Insumo
		@pCodigo - Codigo del Insumo
		@pDescripcion - Descripcion del Insumo
		@pIdUnidadMedida - IdUnidadMedida del Insumo
		@pEstado - Estado del Insumo
		@pUsuarioCreacion - UsuarioCreacion del Insumo
		@pFechaCreacion - FechaCreacion del Insumo
		@pUsuarioModificacion - UsuarioModificacion del Insumo
		@pFechaModificacion - FechaModificacion del Insumo
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Insumo
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdInsumo int = null, 
	@pCodigo varchar(20) = null, 
	@pDescripcion varchar(100) = null, 
	@pIdUnidadMedida int = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdInsumo ASC) AS Num_Fila,
				T.IdInsumo,
				T.Codigo,
				T.Descripcion,
				T.IdUnidadMedida,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				UM.IdUnidadMedida as UnidadMedida_IdUnidadMedida,
				UM.Descripcion as UnidadMedida_Descripcion,
				COUNT(*) OVER() Total_Filas
			From Insumo T
			inner join UnidadMedida UM ON
			UM.IdUnidadMedida = T.IdUnidadMedida
			Where 
				(@pIdInsumo is null or T.IdInsumo = @pIdInsumo) AND
				(@pCodigo is null or T.Codigo like '%' + @pCodigo + '%') AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pIdUnidadMedida is null or T.IdUnidadMedida = @pIdUnidadMedida) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
