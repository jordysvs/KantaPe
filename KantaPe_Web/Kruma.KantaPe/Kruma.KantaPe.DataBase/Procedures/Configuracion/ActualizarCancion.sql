create PROCEDURE [dbo].[ActualizarCancion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de canción
'*	Input			: 	@pIdCancion - Id de canción,
						@pTitulo - Titulo de cancion,
						@pIdArtista - Id del artista,
						@pEstado - Estado de canción,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 12/07/2016
'**********************************************************************************
*/
(
@pIdCancion				int,
@pDescripcion			varchar(100),
@pUsuarioModificacion	varchar(20),
@pEstado char(1)
)
As
Begin
	update Cancion
	set 
	Descripcion = @pDescripcion,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdCancion = @pIdCancion
End
