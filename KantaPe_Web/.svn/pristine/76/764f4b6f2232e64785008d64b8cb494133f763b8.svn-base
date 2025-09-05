create Procedure [dbo].[ActualizarArtista]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del artista
'*	Input			: 	@pIdArtista - Id del artista,
						@pNombre - Nombre del artista,
						@pEstado - Estado del artista,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 02/07/2016
'**********************************************************************************
*/
(
@pIdArtista					int out,
@pNombre					varchar(100),
@pEstado					char(1),
@pUsuarioModificacion		varchar(20)
)
As
Begin
	update Artista
	set 
	Nombre = @pNombre,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdArtista = @pIdArtista
End
