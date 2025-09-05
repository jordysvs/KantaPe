create PROCEDURE [dbo].[SecurityActualizarDispositivo]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de dispositivo
'* Input :
		@pIdDispositivo - IdDispositivo del dispositivo
		@pIp - Ip del dispositivo
		@pNombre - Nombre del dispositivo
		@pEstado - Estado del dispositivo
		@pUsuarioCreacion - UsuarioCreacion del dispositivo
		@pFechaCreacion - FechaCreacion del dispositivo
		@pUsuarioModificacion - UsuarioModificacion del dispositivo
		@pFechaModificacion - FechaModificacion del dispositivo
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 23-07-2015
'**********************************************************************************
*/
(
	@pIdDispositivo int = null, 
	@pIp varchar(15) = null, 
	@pNombre varchar(100) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update SecurityDispositivo
			Set Ip = @pIp, 
			Nombre = @pNombre, 
			Estado = @pEstado, 
			UsuarioModificacion = @pUsuarioModificacion, 
			FechaModificacion = getdate()
		Where
			IdDispositivo= @pIdDispositivo
END
