create PROCEDURE [dbo].[SecurityInsertarPerfil]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de perfil
'* Input :
		@pIdModulo - IdModulo del perfil
		@pIdPerfil - IdPerfil del perfil
		@pDescripcion - Descripcion del perfil
		@pEstado - Estado del perfil
		@pUsuarioCreacion - UsuarioCreacion del perfil
'* Creado Por : John Castillo
'* Fecha Creación : 23-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdPerfil varchar(20) = null,
	@pDescripcion varchar(50) = null, 
	@pEstado char(1) = null, 
	@pUsuarioCreacion varchar(20) = null
)
AS
BEGIN
		Insert Into SecurityPerfil
		(
			IdModulo,
			IdPerfil,
			Descripcion,
			Sistema,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdModulo,
			@pIdPerfil,
			@pDescripcion,
			'N',
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
