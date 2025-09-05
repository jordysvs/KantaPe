create PROCEDURE [dbo].[CerrarApertura]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Apertura
'* Input :
		@pIdLocal - IdLocal del Apertura
		@pIdApertura - IdApertura del Apertura
		@pUsuarioModificacion - UsuarioModificacion del Apertura
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN

		Update Apertura
		Set 
			FechaFinAL = getdate(),
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal AND
			IdApertura = @pIdApertura
END
