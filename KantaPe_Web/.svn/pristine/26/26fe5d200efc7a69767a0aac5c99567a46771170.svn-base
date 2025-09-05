create PROCEDURE [dbo].[ActualizarTurno]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Turno
'* Input :
		@pIdLocal - IdLocal del Turno
		@pIdTurno - IdTurno del Turno
		@pFechaTurno - FechaTurno del Turno
		@pEstado - Estado del Turno
'* Output : Ninguno
'* Creado Por : Diego Mendoza
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdTurno int = null, 
	@pFechaTurno DateTime = null, 
	@pEstado varchar(1) = null,
	@pUsuarioModificacion varchar(25) = null
)
AS
BEGIN
		Update Turno
		Set 
			IdLocal = @pIdLocal,
			IdTurno = @pIdTurno,
			FechaTurno = @pFechaTurno,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = [dbo].getDateSys()
		Where
			IdTurno= @pIdTurno
END
