create PROCEDURE [dbo].[SecurityActualizarGrupoDetalleProceso]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de SecurityGrupoDetalleProceso
'* Input :
		@pIdModulo - IdModulo del SecuityGrupoDetalleProceso
		@pIdGrupo - IdGrupo del SecurityGrupoDetalleProceso
		@pIdDetalle - IdDetalle del SecurityGrupoDetalleProceso
		@pIdProceso - IdProceso del SecurityGrupoDetalleProceso
		@pDescripcion - Descripcion del SecurityGrupoDetalleProceso
		@pNombreControl - NombreControl del SecurityGrupoDetalleProceso
		@pEstado - Estado del SecurityGrupoDetalleProceso
		@pUsuarioModificacion - UsuarioModificacion del SecurityGrupoDetalleProceso
'* Output : Ninguno
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdGrupo char(8) = null, 
	@pIdDetalle char(8) = null, 
	@pIdProceso int = null, 
	@pDescripcion varchar(50) = null, 
	@pNombreControl varchar(50) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update SecurityGrupoDetalleProceso
		Set 
			Descripcion = @pDescripcion,
			NombreControl = @pNombreControl,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdModulo = @pIdModulo AND
			IdGrupo= @pIdGrupo AND
			IdDetalle= @pIdDetalle AND
			IdProceso= @pIdProceso
END
