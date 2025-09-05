create PROCEDURE [dbo].[ActualizarTurnoDetalle]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de TurnoDetalle
'* Input :
		@pIdLocal - IdLocal del TurnoDetalle
		@pIdTurno - IdTurno del TurnoDetalle
		@pIdApertura - IdApertura del TurnoDetalle
		@pIdAperturaCancion - IdAperturaCancion del TurnoDetalle
		@pEstado - Estado del TurnoDetalle
'* Output : Ninguno
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
	@pUsuarioModificacion varchar(25) = null
)
AS
BEGIN
		Update TurnoDetalle
		Set 
			IdLocal = @pIdLocal,
			IdTurno = @pIdTurno,
			IdApertura = @pIdApertura,
			IdAperturaCancion = @pIdAperturaCancion,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = [dbo].getDateSys()
		Where
			IdLocal= @pIdLocal AND
			IdTurno= @pIdTurno
END
