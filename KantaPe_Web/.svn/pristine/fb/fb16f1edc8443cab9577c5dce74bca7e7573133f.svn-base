create PROCEDURE [dbo].[ListarTurnoDetalle]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de TurnoDetalle
'* Input :
		@pIdLocal - IdLocal del TurnoDetalle
		@pIdTurno - IdTurno del TurnoDetalle
		@pIdApertura - IdApertura del TurnoDetalle
		@pIdAperturaCancion - IdAperturaCancion del TurnoDetalle
		@pEstado - Estado del TurnoDetalle
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de TurnoDetalle
'* Creado Por : Diego Mendoza
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdTurno int = null, 
	@pIdApertura int = null, 
	@pIdAperturaCancion int = null, 
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
				T.IdApertura,
				T.IdAperturaCancion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From TurnoDetalle T
			Where 
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdTurno is null or T.IdTurno = @pIdTurno) AND
				(@pIdApertura is null or T.IdApertura = @pIdApertura) AND
				(@pIdAperturaCancion is null or T.IdAperturaCancion = @pIdAperturaCancion) AND
				(@pEstado is null or T.Estado like '%' + @pEstado + '%') 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
