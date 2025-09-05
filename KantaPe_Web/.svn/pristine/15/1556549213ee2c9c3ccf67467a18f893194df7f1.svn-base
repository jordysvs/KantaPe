create Procedure [dbo].[CoreActualizarParametro]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del parámetro
	para el usuario
'*	Input			: 	@pIdModulo - Codigo del modulo
						@pIdParametro - Codigo del parametro
						@pDescripcion - Descripcion del parametro
						@pValor	- Valor del parametro
						@pEstado - Estado del parametro
						@pUsuarioCreacion - Usuario de creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdModulo char(8),
	@pIdParametro varchar(20),
	@pDescripcion varchar(100),
	@pValor	varchar(100),
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CoreParametro
	set 
	Descripcion = @pDescripcion,
	Valor = @pValor,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdModulo = @pIdModulo AND
	IdParametro = @pIdParametro
End
