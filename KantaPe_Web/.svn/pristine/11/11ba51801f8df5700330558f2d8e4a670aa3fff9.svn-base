create Procedure [dbo].[CoreListarUbigeoProvincia] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de provincias
'*	Input			: 	@pIdProvincia - Id de la provincia,
						@pIdPais - Id del pais,
						@pIdDepartamento - Id del departamento,
						@pEstado - Estado del departamento,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: Kruma
'*	Fec Creación	: 20/08/2015
'**********************************************************************************
*/
(
	@pIdProvincia int = null,
	@pIdPais int = null,
	@pIdDepartamento int = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY P.Descripcion ASC) AS Num_Fila,
			CU.IdPais,
			CU.IdDepartamento,
			CU.IdProvincia,
			CU.Estado,
			P.IdProvincia as Provincia_IdProvincia,
			P.Descripcion as Provincia_Descripcion,
			COUNT(*) OVER() Total_Filas
			From CoreUbigeo CU
			inner join CoreProvincia P
			on CU.IdProvincia = P.IdProvincia
			Where 
			(@pIdProvincia is null or CU.IdProvincia = @pIdProvincia) AND
			(@pIdDepartamento is null or CU.IdDepartamento = @pIdDepartamento) AND
			(@pEstado is null or CU.Estado = @pEstado) 
			Group By
			CU.IdPais,
			CU.IdDepartamento,
			CU.IdProvincia,
			CU.Estado,
			P.IdProvincia,
			P.Descripcion
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
