CREATE PROCEDURE [DBO].[ActualizarAlerta]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de Alerta
'* Input :
		@pIdLocal - IdLocal del Alerta
		@pIdUbicacion - IdUbicacion del Alerta
		@pIdAlerta - IdAlerta del Alerta
		@pEstado - Estado del Alerta
		@pUsuarioModificacion - UsuarioModificacion del Alerta
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdUbicacion int = null, 
	@pIdAlerta int = null, 
	@pIdAlertaTipo int = null,
	@pFechaAlerta datetime = null,
	@pFechaAtencion datetime = null,
	@pIdUsuario varchar(20) = null,
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update Alerta
		Set 
			IdAlertaTipo = @pIdAlertaTipo,
			FechaAlerta = @pFechaAlerta,
			FechaAtencion = @pFechaAtencion,
			IdUsuario = @pIdUsuario,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal AND
			IdUbicacion = @pIdUbicacion AND
			IdAlerta = @pIdAlerta
END
