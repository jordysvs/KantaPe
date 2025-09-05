create PROCEDURE [dbo].[SecurityActualizarGrupo]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de SecurityGrupo
'* Input :
		@pIdGrupo - IdGrupo del SecurityGrupo
		@pDescripcion - Descripcion del SecurityGrupo
		@pOrden - Orden del SecurityGrupo
		@pEstado - Estado del SecurityGrupo
		@pUsuarioModificacion - UsuarioModificacion del SecurityGrupo
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdGrupo char(8) = null, 
	@pDescripcion varchar(50) = null, 
	@pOrden int = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update SecurityGrupo
		Set 
			Descripcion = @pDescripcion,
			Orden = @pOrden,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdModulo = @pIdModulo AND
			IdGrupo= @pIdGrupo
END
