create Procedure [dbo].[SecurityActualizarUsuario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del usuario
	para el usuario
'*	Input			: 	@pIdUsuario - Codigo del usuario
						@pClave - Clave del usuario
						@pUsuarioRed - Usuario de red
						@pIdPersona - Id de la persona
						@pFlagExpiracion - Flag de expiracion del usuario
						@pFechaExpiracion - Fecha de expiracion del usuario
						@pEstado - Estado del usuario
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20),
	@pClave varchar(50),
	@pUsuarioRed varchar(20),
	@pIdPersona int,
	@pFlagExpiracion char(1),
	@pFechaExpiracion datetime,
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update SecurityUsuario
	set 
	Clave = @pClave,
	UsuarioRed = @pUsuarioRed,
	FlagExpiracion = @pFlagExpiracion,
	FechaExpiracion = @pFechaExpiracion,
	IdPersona = @pIdPersona,
	FechaCambioClave = CASE WHEN Clave != @pClave THEN GETDATE() ELSE FechaCambioClave END,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdUsuario = @pIdUsuario
End
