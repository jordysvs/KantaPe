create PROCEDURE [dbo].[ActualizarUbicacion]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación de la ubicación
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
	@pIdUbicacion int = null,
	@pIdUbicacionTipo int = null,
	@pNumero int = null,
	@pCapacidad int = null,
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update Ubicacion
		Set 
			IdUbicacionTipo = @pIdUbicacionTipo,
			Numero = @pNumero,
			Capacidad = @pCapacidad,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal AND
			IdUbicacion = @pIdUbicacion
END
