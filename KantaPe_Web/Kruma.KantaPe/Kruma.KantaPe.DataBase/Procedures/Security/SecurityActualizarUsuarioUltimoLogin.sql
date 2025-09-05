create PROCEDURE [dbo].[SecurityActualizarUsuarioUltimoLogin]
/*
'**********************************************************************************
'* Procedimiento almacenado encargado de validar si existe el usuario
'* Input			: @pIdUsuario - Codigo del usuario
'* Output			: <Ninguno>
'* Creado Por		: John Castillo
'* Fec Creación		: 07/08/2015
'**********************************************************************************
*/
(
@pIdUsuario		varchar(20),
@pUsuarioModificacion varchar(20)
)
AS
Begin

	declare @vFechaLogin datetime

	select @vFechaLogin = FechaLogin from SecurityUsuario where IdUsuario = @pIdUsuario

	Update SecurityUsuario
	set 
	FechaUltimoLogin = ISNULL(@vFechaLogin,getdate()),
	FechaLogin = getdate(),
	UsuarioModificacion = @pUsuarioModificacion

	where IdUsuario = @pIdUsuario
End
