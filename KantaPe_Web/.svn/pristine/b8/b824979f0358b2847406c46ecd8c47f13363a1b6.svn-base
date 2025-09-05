create PROCEDURE [dbo].[ObtenerUltimoTurno]
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
	@pIdApertura int = null
)
AS
BEGIN
		Select Top 1 T.IdTurno
		From TurnoDetalle T
		JOIN AperturaCancion AC
		ON T.IdApertura = AC.IdApertura
		Where 
			(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
			(@pIdApertura is null or AC.IdApertura = @pIdApertura) 
		Order by T.FechaCreacion desc 
END
