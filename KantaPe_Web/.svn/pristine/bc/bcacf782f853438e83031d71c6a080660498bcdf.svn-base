create PROCEDURE [dbo].[ListarTurno]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Turno
'* Input :
		@pIdLocal - IdLocal del Turno
		@pIdTurno - IdTurno del Turno
		@pFechaTurno - FechaTurno del Turno
		@pEstado - Estado del Turno
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Turno
'* Creado Por : Diego Mendoza
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdTurno int = null, 
	@pFechaTurno DateTime = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdTurno ASC) AS Num_Fila,
				T.IdTurno,
				T.IdLocal,
				T.FechaTurno,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From Turno T
			Where 
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdTurno is null or T.IdTurno = @pIdTurno) AND
				(@pFechaTurno is null or T.FechaTurno like '%' + @pFechaTurno + '%') AND
				(@pEstado is null or T.Estado like '%' + @pEstado + '%') 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
