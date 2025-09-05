CREATE Procedure [dbo].[ActualizarAlbum]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del Album
'*	Input			: 	@pIdAlbum - Id del Album,
						@pIdArtista - Id del artista,
						@pTitulo - Titulo del album,
						@pEstado - Estado del album,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 03/07/2016
'**********************************************************************************
*/
(
	@pIdAlbum int,
	@pIdArtista int,
	@pTitulo varchar(100),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update Album
	set 
	IdArtista = @pIdArtista,
	Titulo = @pTitulo,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdAlbum = @pIdAlbum
End
