create PROCEDURE [dbo].[InsertarAperturaUbicacion]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de la ubicación de la Apertura
'* Input :
		@pIdLocal - Id del Local
		@pIdApertura - Id de la Apertura
		@pIdUbicacion - Id de la Ubicacion
		@pEstado - Estado del Apertura
		@pUsuarioCreacion - UsuarioCreacion del Apertura
'* Creado Por : John Castillo
'* Fecha Creación : 06-10-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdApertura int = null,
	@pIdUbicacion int = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null
)
AS
BEGIN
		Insert Into AperturaUbicacion
		(
			IdLocal,
			IdApertura,
			IdUbicacion,
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
			@pIdUbicacion,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
