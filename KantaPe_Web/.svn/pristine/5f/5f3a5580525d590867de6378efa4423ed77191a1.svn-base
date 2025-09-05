CREATE PROCEDURE [dbo].[ActualizarLocal]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Local
'* Input :
		@pIdLocal - IdLocal del Local
		@pEstado - Estado del Local
		@pUsuarioModificacion - UsuarioModificacion del Local
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pEstado varchar(1) = null,
	@pHoraInicio int = null, 
	@pHoraFin int = null, 
	@pRadio decimal(18, 2) = null,
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update Local
		Set 
			Estado = @pEstado,
			HoraInicio = @pHoraInicio,
			HoraFin = @pHoraFin,
			Radio = @pRadio,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal
END
