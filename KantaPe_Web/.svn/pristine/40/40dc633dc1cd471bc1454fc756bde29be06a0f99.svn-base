create PROCEDURE [dbo].[InsertarLocalCancion_old]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de la canción del local
'*	Input			: 	@pIdLocal - Id del local,
						@pIdCancion - Id de canción,
						@pEstado - Estado de canción,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 01/08/2016
'**********************************************************************************
*/
(
@pIdLocal			int,
@pIdCancion			int,
@pEstado			char(1),
@pUsuarioCreacion	varchar(20)
)
As
Begin
	Insert into LocalCancion
	(
	IdLocal,
	IdCancion,
	Estado,
	UsuarioCreacion,
	FechaCreacion,
	UsuarioModificacion,
	FechaModificacion
	)
	values
	(
	@pIdLocal,
	@pIdCancion,
	@pEstado,
	@pUsuarioCreacion,
	getdate(),
	@pUsuarioCreacion,
	getdate()
	)
End
