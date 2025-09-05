create Procedure [dbo].[CoreActualizarTipoDocumento]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del tipo de documento
'*	Input			: 	@pIdTipoDocumento - Id del tipo de documento
						@pCodigo - Código del tipo de documento
						@pDescripcion - Descripcion del tipo de documento
						@pEstado - Estado del area
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
	@pIdTipoDocumento int,
	@pCodigo varchar(20),
	@pDescripcion varchar(100),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CoreTipoDocumento
	set 
	Codigo = @pCodigo,
	Descripcion = @pDescripcion,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdTipoDocumento = @pIdTipoDocumento
End
