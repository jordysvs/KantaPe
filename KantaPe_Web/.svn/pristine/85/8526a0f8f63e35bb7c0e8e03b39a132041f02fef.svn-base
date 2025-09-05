create Procedure [dbo].[CoreListarUbigeoDistrito] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de distritos
'*	Input			: 	@pIdDistrito - Id del distrito,
						@pIdProvincia - Id de la provincia,
						@pEstado - Estado del departamento,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: Gian Pierre Escobar
'*	Fec Creación	: 20/08/2015
'**********************************************************************************
*/
(
	@pIdDistrito int = null,
	@pIdPais int = null,
	@pIdDepartamento int = null,
	@pIdProvincia int = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY D.Descripcion ASC) AS Num_Fila,
			CU.IdPais,
			CU.IdDepartamento,
			CU.IdProvincia,
			CU.IdDistrito,
			CU.Estado,
			D.IdDistrito as Distrito_IdDistrito,
			D.Descripcion as Distrito_Descripcion,
			COUNT(*) OVER() Total_Filas
			From CoreUbigeo CU
			inner join CoreDistrito D
			on CU.IdDistrito = D.IdDistrito
			Where 
			(@pIdPais is null or CU.IdPais = @pIdPais) AND
			(@pIdDepartamento is null or CU.IdDepartamento = @pIdDepartamento) AND
			(@pIdProvincia is null or CU.IdProvincia = @pIdProvincia) AND
			(@pIdDistrito is null or CU.IdDistrito = @pIdDistrito) AND
			(@pEstado is null or CU.Estado = @pEstado) 
			Group By
			CU.IdPais,
			CU.IdDepartamento,
			CU.IdProvincia,
			CU.IdDistrito,
			CU.Estado,
			D.IdDistrito,
			D.Descripcion
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
