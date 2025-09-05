create PROCEDURE [dbo].[ActualizarLocalCancion_Old]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de la canción del local
'*	Input			: 	@pIdLocal - Id del local,
						@pIdCancion - Id de canción,
						@pEstado - Estado de canción,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 12/07/2016
'**********************************************************************************
*/
(
@pIdLocal				int,
@pIdCancion				int,
@pEstado				char(1),
@pUsuarioModificacion	varchar(20)
)
As
Begin
	update LocalCancion
	set 
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdLocal = @pIdLocal AND
	IdCancion = @pIdCancion
End
