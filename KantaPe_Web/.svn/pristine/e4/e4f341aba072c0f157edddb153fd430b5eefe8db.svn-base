create Procedure [dbo].[SecurityListarPerfilUsuario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de los perfiles del usuario
	para el usuario
'*	Input			: 	@pIdModulo - Codigo del modulo
						@pIdUsuario - Codigo del usuario
						@pIdPerfil - Codigo del perfil
						@pEstado - Estado del usuario perfil
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdUsuario varchar(20) = null,
	@pIdPerfil varchar(20) = null,
	@pEstado char(1) = null
	
)
As
Begin
	Select 
	PU.IdModulo,
	PU.IdPerfil,
	PU.IdUsuario,
	PU.FlagExpiracion,
	PU.FechaExpiracion,
	PU.Estado,
	PU.UsuarioCreacion,
	PU.FechaCreacion,
	PU.UsuarioModificacion,
	PU.FechaModificacion,
	p.IdModulo as SecurityPerfil_IdModulo,
	P.IdPerfil as SecurityPerfil_IdPerfil,
	P.Descripcion as SecurityPerfil_Descripcion,
	P.Estado as SecurityPerfil_Estado,
	P.UsuarioCreacion as SecurityPerfil_UsuarioCreacion,
	P.FechaCreacion as SecurityPerfil_FechaCreacion,
	P.UsuarioModificacion as SecurityPerfil_UsuarioModificacion,
	M.IdModulo as Modulo_IdModulo,
	M.Descripcion as Modulo_Descripcion,
	M.Estado as Modulo_Estado
	from SecurityPerfilUsuario PU
	inner join SecurityPerfil P on
	P.IdModulo = PU.IdModulo AND
	P.IdPerfil = PU.IdPerfil AND
	P.Estado = 'A'
	inner join CoreModulo M on
	M.IdModulo = P.IdModulo AND
	M.Estado = 'A'
	Where 
	(PU.IdUsuario = @pIdUsuario) AND
	(@pIdModulo is null or PU.IdModulo = @pIdModulo) AND
	(@pIdPerfil is null or PU.IdPerfil = @pIdPerfil) AND
	(@pEstado  is null or PU.Estado = @pEstado) 
End
