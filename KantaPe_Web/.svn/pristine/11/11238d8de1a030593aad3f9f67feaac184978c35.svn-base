create PROCEDURE [dbo].[ActualizarOferta]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de la oferta
'* Input :
		@pIdLocal - Id del local de la ubicación
		@pIdUbicacion - Id de la ubicación
		@pEstado - Estado de la ubicación
		@pUsuarioModificacion - UsuarioModificacion de la ubicación
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdOferta int = null, 
	@pNombre varchar(50) = null,
	@pDescripcion varchar(100) = null,
	@pFechaOferta datetime = null,
	@pFechaVencimiento datetime = null,
	@pIdImagen int = null,
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update Oferta
		Set 
			Nombre = @pNombre,
			Descripcion = @pDescripcion,
			FechaOferta = @pFechaOferta,
			FechaVencimiento = @pFechaVencimiento,
			IdImagen = @pIdImagen,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal AND
			IdOferta = @pIdOferta
END
