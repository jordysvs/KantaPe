create PROCEDURE [dbo].[ActualizarApertura]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Apertura
'* Input :
		@pIdLocal - IdLocal del Apertura
		@pIdApertura - IdApertura del Apertura
		@pIdMozo - IdMozo del Apertura
		@pFechaApertura - FechaApertura del Apertura
		@pFechaFinal - FechaFinal del Apertura
		@pTotal - Total del Apertura
		@pIdAlerta - IdAlerta del Apertura
		@pEstado - Estado del Apertura
		@pUsuarioModificacion - UsuarioModificacion del Apertura
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pIdMozo int = null, 
	@pFechaApertura DateTime = null, 
	@pFechaFinal DateTime = null, 
	@pTotal decimal = null, 
	@pIdAlerta int = null, 
	@pRonda int = null,
	@pFlagTurno varchar(1) = null,
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update Apertura
		Set 
			IdLocal = @pIdLocal,
			IdApertura = @pIdApertura,
			IdMozo = @pIdMozo,
			FechaApertura = @pFechaApertura,
			FechaFinal = @pFechaFinal,
			Total = @pTotal,
			Ronda = @pRonda,
			FlagTurno = @pFlagTurno,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = [dbo].getdatesys()
		Where
			IdLocal = @pIdLocal AND
			IdApertura = @pIdApertura
END
