create Procedure [dbo].[ActualizarAperturaUsuario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de la canción de la apertura
'*	Input			: 	@pIdLocal - Id del local,
						@pIdApertura - Id de la apertura,
						@pTitulo - Titulo del album,
						@pEstado - Estado del album,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 06/10/2016
'**********************************************************************************
*/
(
	@pIdLocal int,
	@pIdApertura int,
	@pIdAperturaUsuario int,
	@pIdUsuario varchar(20),
	@pAdministrador char(1),
	@pLatitud varchar(50),
	@pLongitud varchar(50),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update AperturaUsuario
	set 
	Administrador = @pAdministrador,
	Latitud = @pLatitud,
	Longitud = @pLongitud,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdLocal = @pIdLocal AND
	IdApertura = @pIdApertura AND
	IdAperturaUsuario = @pIdAperturaUsuario AND
	IdUsuario = @pIdUsuario
End
