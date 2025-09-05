create PROCEDURE [dbo].[InsertarAlerta]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Alerta
'* Input :
		@pIdLocal - IdLocal del Alerta
		@pIdUbicacion - IdUbicacion del Alerta
		@pIdAlertaTipo - IdAlertaTipo del Alerta
		@pFechaAlerta - FechaAlerta del Alerta
		@pIdUsuario - IdUsuario del Alerta
		@pEstado - Estado del Alerta
		@pUsuarioCreacion - UsuarioCreacion del Alerta
'* Output : 
		@pIdAlerta - IdAlerta del Alerta
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdUbicacion int = null, 
	@pIdAlertaTipo int = null, 
	@pFechaAlerta DateTime = null, 
	@pIdUsuario varchar(20) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdAlerta int out
)
AS
BEGIN
		Select @pIdAlerta = IsNull(Max(IdAlerta),0)+1 
		From Alerta 
		Where 
		IdAlerta > 0 AND
		IdLocal = @pIdLocal AND
		IdUbicacion = @pIdUbicacion
		
		Insert Into Alerta
		(
			IdLocal,
			IdUbicacion,
			IdAlerta,
			IdAlertaTipo,
			FechaAlerta,
			IdUsuario,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdLocal,
			@pIdUbicacion,
			@pIdAlerta,
			@pIdAlertaTipo,
			[dbo].getdatesys(),
			@pIdUsuario,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
