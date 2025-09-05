create Procedure [dbo].[SecurityActualizarEstadoUsuario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del estado del usuario
	para el usuario
'*	Input			: 	@pIdUsuario - Codigo del usuario,
						@pEstado - Estado del usuario,
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update SecurityUsuario
	set 
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdUsuario = @pIdUsuario
End
