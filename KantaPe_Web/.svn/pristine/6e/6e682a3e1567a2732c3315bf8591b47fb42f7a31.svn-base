create PROCEDURE [dbo].[SecurityInsertarGrupoDetalle]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de SecurityGrupoDetalle
'* Input :
		@pIdModulo - IdModulo del SecurityGrupoDetalle
		@pIdGrupo - IdGrupo del SecurityGrupoDetalle
		@pIdDetalle - IdDetalle del SecurityGrupoDetalle
		@pDescripcion - Descripcion del SecurityGrupoDetalle
		@pIdDetallePadre - IdDetallePadre del SecurityGrupoDetalle
		@pOrden - Orden del SecurityGrupoDetalle
		@pURL - URL del SecurityGrupoDetalle
		@pFlagVisible - FlagVisible del SecurityGrupoDetalle
		@pEstado - Estado del SecurityGrupoDetalle
		@pUsuarioCreacion - UsuarioCreacion del SecurityGrupoDetalle
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8),
	@pIdDetalle char(8),
	@pIdGrupo char(8),
	@pDescripcion varchar(50) = null, 
	@pIdDetallePadre varchar(8) = null, 
	@pURL varchar(500) = null, 
	@pFlagVisible varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null,
	@pIdImagen int out
)
AS
BEGIN
		declare @vOrden int

		select @vOrden = ISNULL(MAX(Orden),0) 
		from SecurityGrupoDetalle 
		where 
		IdModulo = @pIdModulo AND
		IdGrupo = @pIdGrupo AND 
		IdDetalle = @pIdDetalle AND Estado = 'A'

		select @pIdImagen = IsNull(MAX(IdImagen),0)+1 from SecurityGrupoDetalle;

		Insert Into SecurityGrupoDetalle
		(
			IdModulo,
			IdGrupo,
			IdDetalle,
			Descripcion,
			IdDetallePadre,
			Orden,
			URL,
			FlagVisible,
			IdImagen,
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
			@pDescripcion,
			@pIdDetallePadre,
			@vOrden,
			@pURL,
			@pFlagVisible,
			@pIdImagen,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
