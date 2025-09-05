create PROCEDURE [dbo].[SecurityActualizarGrupoDetalleOrden]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación del orden del SecurityGrupoDetalle
'* Input :
		@pIdModulo - IdModulo del SecurityGrupoDetalle
		@pIdGrupo - IdGrupo del SecurityGrupoDetalle
		@pIdGrupoAnterior - IdGrupo del SecurityGrupoDetalle
		@pIdDetalle - IdDetalle del SecurityGrupoDetalle
		@pDescripcion - Descripcion del SecurityGrupoDetalle
		@pIdDetallePadre - IdDetallePadre del SecurityGrupoDetalle
		@pOrden - Orden del SecurityGrupoDetalle
		@pURL - URL del SecurityGrupoDetalle
		@pFlagVisible - FlagVisible del SecurityGrupoDetalle
		@pEstado - Estado del SecurityGrupoDetalle
		@pUsuarioModificacion - UsuarioModificacion del SecurityGrupoDetalle
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdGrupo char(8) = null, 
	@pIdGrupoAnterior char(8) = null,
	@pIdDetalle char(8) = null, 
	@pDescripcion varchar(50) = null, 
	@pIdDetallePadre varchar(8) = null, 
	@pOrden int = null, 
	@pURL varchar(500) = null, 
	@pFlagVisible varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
	
	IF @pIdGrupo != @pIdGrupoAnterior
	BEGIN
		--Se obtiene los perfiles del grupo detalle
		select IdPerfil,IdGrupo,IdDetalle,Estado,UsuarioCreacion,FechaCreacion,UsuarioModificacion,FechaModificacion 
		into #TmpSecurityPerfilGrupoDetalleAcceso
		from SecurityPerfilGrupoDetalleAcceso
		where 
		IdModulo = @pIdModulo AND
		IdGrupo = @pIdGrupoAnterior AND 
		IdDetalle = @pIdDetalle

		--Se elimina los accesos del perfil
		delete from SecurityPerfilGrupoDetalleAcceso
		where 
		IdModulo = @pIdModulo AND
		IdGrupo = @pIdGrupoAnterior AND 
		IdDetalle = @pIdDetalle
	END
	--Se actualiza el grupo detalle
	Update SecurityGrupoDetalle
	Set 
		IdGrupo = @pIdGrupo,
		Descripcion = @pDescripcion,
		IdDetallePadre = @pIdDetallePadre,
		Orden = @pOrden,
		URL = @pURL,
		FlagVisible = @pFlagVisible,
		Estado = @pEstado,
		UsuarioModificacion = @pUsuarioModificacion,
		FechaModificacion = getdate()
	Where
		IdModulo = @pIdModulo AND
		IdGrupo= @pIdGrupoAnterior AND
		IdDetalle= @pIdDetalle

	IF @pIdGrupo != @pIdGrupoAnterior
	BEGIN
	--Se inserta los accesos del perfil
	insert into SecurityPerfilGrupoDetalleAcceso
	(IdModulo,IdPerfil,IdGrupo,IdDetalle,Estado,UsuarioCreacion,FechaCreacion,UsuarioModificacion,FechaModificacion)
	select IdModulo,IdPerfil,@pIdGrupo,IdDetalle,Estado,UsuarioCreacion,FechaCreacion,UsuarioModificacion,FechaModificacion
	from #TmpSecurityPerfilGrupoDetalleAcceso

	END
		
END
