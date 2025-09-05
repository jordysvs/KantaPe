create procedure [dbo].[SecurityInsertarPerfilUsuario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del perfil del usuario
	para el usuario
'*	Input			: 	@pIdModulo - Codigo del modulo,
						@pIdUsuario - Codigo del usuario,
						@pIdPerfil - Codigo del perfil,
						@pFlagExpiracion - Flag de expiración del perfil,
						@pFechaExpiracion - Fecha de expiracion del perfil,
						@pEstado - estado del perfil del usuario,
						@pUsuarioCreacion - Usuario de creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdModulo char(8),
	@pIdUsuario varchar(20),
	@pIdPerfil varchar(20),
	@pFlagExpiracion char(1),
	@pFechaExpiracion datetime,
	@pEstado char(1),
	@pUsuarioCreacion varchar(20)
)
as
insert into SecurityPerfilUsuario
(
	IdModulo,
	IdPerfil,
	IdUsuario,
	FlagExpiracion,
	FechaExpiracion,
	Estado,
	UsuarioCreacion,
	FechaCreacion,
	UsuarioModificacion,
	FechaModificacion
)
values
(
	@pIdModulo,
	@pIdPerfil,
	@pIdUsuario,
	@pFlagExpiracion,
	@pFechaExpiracion,
	@pEstado,
	@pUsuarioCreacion,
	GetDate(),
	@pUsuarioCreacion,
	GetDate()
)
