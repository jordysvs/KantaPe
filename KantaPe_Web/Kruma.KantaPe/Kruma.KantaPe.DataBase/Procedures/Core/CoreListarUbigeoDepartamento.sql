create Procedure [dbo].[CoreListarUbigeoDepartamento] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de departamento
'*	Input			: 	@pIdDepartamento - Id del departamento,
						@pIdPais - Id del pais,
						@pEstado - Estado del departamento,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: Kruma
'*	Fec Creación	: 1/07/2016
'**********************************************************************************
*/
(
	@pIdDepartamento int = null,
	@pIdPais int = null,
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
			CU.Estado,
			D.IdDepartamento as Departamento_IdDepartamento,
			D.Descripcion as Departamento_Descripcion,
			COUNT(*) OVER() Total_Filas
			From CoreUbigeo CU
			inner join CoreDepartamento D
			on CU.IdDepartamento = D.IdDepartamento
			Where 
			(@pIdDepartamento is null or CU.IdDepartamento = @pIdDepartamento) AND
			(@pIdPais is null or CU.IdPais = @pIdPais) AND
			(@pEstado is null or CU.Estado = @pEstado) 
			Group By
			CU.IdPais,
			CU.IdDepartamento,
			CU.Estado,
			D.IdDepartamento,
			D.Descripcion
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
