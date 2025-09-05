create Procedure [dbo].[ActualizarAperturaCancion]
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
	@pIdAperturaCancion int,
	@pIdUsuario varchar(20),
	@pIdLocalCancion int,
	@pIdAperturaCancionTipo int,
	@pOrden int,
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update AperturaCancion
	set 
	IdUsuario = @pIdUsuario,
	IdLocalCancion = @pIdLocalCancion,
	IdAperturaCancionTipo = @pIdAperturaCancionTipo,
	Orden = @pOrden,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdLocal = @pIdLocal AND
	IdApertura = @pIdApertura AND
	IdAperturaCancion = @pIdAperturaCancion
End
