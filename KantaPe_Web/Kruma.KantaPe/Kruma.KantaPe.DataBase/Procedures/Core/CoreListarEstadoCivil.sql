create PROCEDURE [dbo].[CoreListarEstadoCivil]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CoreEstadoCivil
'* Input :
		@pIdEstadoCivil - IdEstadoCivil del CoreEstadoCivil
		@pDescripcion - Descripcion del CoreEstadoCivil
		@pEstado - Estado del CoreEstadoCivil
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CoreEstadoCivil
'* Creado Por : Kruma
'* Fecha Creación : 21-07-2016
'**********************************************************************************
*/
(
	@pIdEstadoCivil int = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdEstadoCivil ASC) AS Num_Fila,
				T.IdEstadoCivil,
				T.Descripcion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CoreEstadoCivil T
			Where 
				(@pIdEstadoCivil is null or T.IdEstadoCivil = @pIdEstadoCivil) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
