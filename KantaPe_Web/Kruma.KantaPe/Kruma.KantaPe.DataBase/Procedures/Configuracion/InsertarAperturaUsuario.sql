create PROCEDURE [dbo].[InsertarAperturaUsuario]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Apertura
'* Input :
		@pIdLocal - Id del Local
		@pIdApertura - Id de la Apertura
		@pIdUsuario - Id del Usuario
		@pAdministrador - El Usuario es administrador
		@pLatitud - Latitud de ubicacion del usuario
		@pLongitud - Longitud de ubicacion del usuario
		@pEstado - Estado del Apertura
		@pUsuarioCreacion - UsuarioCreacion del Apertura
'* Creado Por : John Castillo
'* Fecha Creación : 06-10-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdApertura int = null,
	@pIdUsuario varchar(20) = null, 
	@pAdministrador char(1) = null, 
	@pFechaIngreso datetime = null,
	@pLatitud varchar(50) = null,
	@pLongitud varchar(50) = null,
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null,
	@pIdAperturaUsuario int output 
)
AS
BEGIN

		select @pIdAperturaUsuario = ISNULL(MAX(IdAperturaUsuario),0)+1 
		from AperturaUsuario 
		Where 
		IdLocal = @pIdLocal AND
		IdApertura = @pIdApertura AND
		IdAperturaUsuario > 0

		Insert Into AperturaUsuario
		(
			IdLocal,
			IdApertura,
			IdAperturaUsuario,
			IdUsuario,
			Administrador,
			FechaIngreso,
			FechaFinal,
			Latitud,
			Longitud,
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
			@pIdAperturaUsuario,
			@pIdUsuario,
			@pAdministrador,
			getdate(),
			null,
			@pLatitud,
			@pLongitud,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
