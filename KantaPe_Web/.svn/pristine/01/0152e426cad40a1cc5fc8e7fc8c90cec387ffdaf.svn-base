create Procedure [dbo].[CoreActualizarArea]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del area
'*	Input			: 	@pIdArea - Codigo del area
						@pDescripcion - Descripcion del area
						@pEstado - Estado del area
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 02/06/2015
'**********************************************************************************
*/
(
	@pIdArea int,
	@pCodigo varchar(20),
	@pDescripcion varchar(100),
	@pComision bit,
	@pIdJefe int,
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CoreArea
	set 
	Codigo = @pCodigo,
	Descripcion = @pDescripcion,
	Comision = @pComision,
	IdJefe = @pIdJefe,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdArea = @pIdArea
End
