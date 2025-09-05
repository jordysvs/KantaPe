create PROCEDURE [dbo].[SecurityInsertarGrupoDetalleProceso]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de SecurityGrupoDetalleProceso
'* Input :
		@pIdModulo - IdModulo del SecurityGrupoDetalleProceso
		@pIdGrupo - IdGrupo del SecurityGrupoDetalleProceso
		@pIdDetalle - IdDetalle del SecurityGrupoDetalleProceso
		@pDescripcion - Descripcion del SecurityGrupoDetalleProceso
		@pNombreControl - NombreControl del SecurityGrupoDetalleProceso
		@pEstado - Estado del SecurityGrupoDetalleProceso
		@pUsuarioCreacion - UsuarioCreacion del SecurityGrupoDetalleProceso
'* Output : 
		@pIdProceso - IdProceso del SecurityGrupoDetalleProceso
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pDescripcion varchar(50) = null, 
	@pNombreControl varchar(50) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdModulo char(8) = null,
	@pIdGrupo varchar(8) = null,
	@pIdDetalle varchar(8) = null,
	@pIdProceso int out
)
AS
BEGIN
		Select @pIdProceso = IsNull(Max(IdProceso),0)+1 
		From SecurityGrupoDetalleProceso 
		Where 
		IdModulo = @pIdModulo AND
		IdGrupo = @pIdGrupo AND
		IdDetalle = @pIdDetalle AND
		IdProceso > 0

		Insert Into SecurityGrupoDetalleProceso
		(
			IdModulo,
			IdGrupo,
			IdDetalle,
			IdProceso,
			Descripcion,
			NombreControl,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdModulo,
			@pIdGrupo,
			@pIdDetalle,
			@pIdProceso,
			@pDescripcion,
			@pNombreControl,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
