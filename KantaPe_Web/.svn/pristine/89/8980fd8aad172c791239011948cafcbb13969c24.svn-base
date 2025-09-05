create PROCEDURE [dbo].[InsertarAperturaCancion]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Apertura
'* Input :
		@pIdLocal - Id de local
		@pIdApertura - Id de la apertura
		@pIdUsuario - Id del usuario
		@pIdCancion - Id de la canción
		@pIdAperturaCancionTipo - Id del tipo de cancion
		@pEstado - Estado de la apertura de la cancion
'* Output : 
		@pIdAperturaCancion - Id de la cancion de la apertura
'* Creado Por : John Castillo
'* Fecha Creación : 06-10-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdApertura int = null,
	@pIdAperturaCancionSolicitud int = null,
	@pIdUsuario varchar(20) = null, 
	@pIdLocalCancion int = null, 
	@pIdAperturaCancionTipo int = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdAperturaCancion int out
)
AS
BEGIN
		declare @vOrden int
		select @vOrden = IsNull(MAX(Orden),0)+1
		from AperturaCancion
		Where 
		IdLocal = @pIdLocal AND
		IdApertura = @pIdApertura

		Select @pIdAperturaCancion = IsNull(Max(IdAperturaCancion),0)+1 
		From AperturaCancion 
		Where IdAperturaCancion > 0 AND
		IdLocal = @pIdLocal AND
		IdApertura = @pIdApertura

		Insert Into AperturaCancion
		(
			IdLocal,
			IdApertura,
			IdAperturaCancionSolicitud,
			IdAperturaCancion,
			IdUsuario,
			IdLocalCancion,
			IdAperturaCancionTipo,
			Orden,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdLocal,
			@pIdApertura,
			@pIdAperturaCancionSolicitud,
			@pIdAperturaCancion,
			@pIdUsuario,
			@pIdLocalCancion,
			@pIdAperturaCancionTipo,
			@vOrden,
			@pEstado,
			@pUsuarioCreacion,
			[dbo].getdatesys(),
			@pUsuarioCreacion,
			[dbo].getdatesys()
		)
END
