create Procedure [dbo].[CoreActualizarPuesto]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del puesto
'*	Input			: 	@pIdPuesto - Id del puesto
						@pDescripcion - Descripcion del puesto
						@pEstado - Estado del puesto
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
	@pIdPuesto int,
	@pDescripcion varchar(100),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CorePuesto
	set 
	Descripcion = @pDescripcion,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdPuesto = @pIdPuesto
End
