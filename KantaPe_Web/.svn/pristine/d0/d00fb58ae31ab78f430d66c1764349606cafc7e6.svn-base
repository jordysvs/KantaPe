create PROCEDURE [dbo].[CoreListarUbigeo] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Ubigeo
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
	@pIdUbigeo int = null, 
	@pIdPais int = null, 
	@pIdDepartamento int = null, 
	@pIdProvincia int = null, 
	@pIdDistrito int = null, 
	@pEstado char(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdUbigeo ASC) AS Num_Fila,
				T.IdUbigeo,
				T.IdPais,
				T.IdDepartamento,
				T.IdProvincia,
				T.IdDistrito,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CoreUbigeo T
			Where 
				((@pIdUbigeo is null AND 
				(
				((@pIdPais is null AND T.IdPais is null) OR (@pIdPais is null OR T.IdPais = @pIdPais)) AND
				((@pIdDepartamento is null AND T.IdDepartamento is null) OR (@pIdDepartamento is null OR T.IdDepartamento = @pIdDepartamento)) AND
				((@pIdProvincia is null AND T.IdProvincia is null) OR (@pIdProvincia is null OR T.IdProvincia = @pIdProvincia)) AND
				((@pIdDistrito is null AND T.IdDistrito is null) OR (@pIdDistrito is null OR T.IdDistrito = @pIdDistrito))
				)) OR T.IdUbigeo = @pIdUbigeo) AND
				(@pEstado is null OR T.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
