create Procedure [dbo].[ActualizarGenero]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del género
'*	Input			: 	@pIdGenero - Id del género,
						@pDescripcion - Descripción del género,
						@pEstado - Estado del genero,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
@pIdGenero					int out,
@pDescripcion				varchar(100),
@pEstado					char(1),
@pUsuarioModificacion		varchar(20)
)
As
Begin
	update Genero
	set 
	Descripcion = @pDescripcion,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdGenero = @pIdGenero
End
