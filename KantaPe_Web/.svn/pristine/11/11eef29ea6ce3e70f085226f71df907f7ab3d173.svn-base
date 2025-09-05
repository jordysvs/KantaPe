create Procedure [dbo].[ActualizarIdioma]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del idioma
'*	Input			: 	@pIdIdioma - Id del idioma,
						@pDescripcion - Descripción del idioma,
						@pEstado - Estado del idioma,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
@pIdIdioma					int out,
@pDescripcion				varchar(100),
@pEstado					char(1),
@pUsuarioModificacion		varchar(20)
)
As
Begin
	update Idioma
	set 
	Descripcion = @pDescripcion,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdIdioma = @pIdIdioma
End
