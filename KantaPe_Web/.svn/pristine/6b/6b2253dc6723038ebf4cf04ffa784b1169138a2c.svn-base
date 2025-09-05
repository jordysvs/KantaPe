create Procedure [dbo].[ActualizarLocalCancionTemporal]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización del LocalCancionTemporal
'*	Input			: 	@pIdLocalCancionTemporal - Id del LocalCancionTemporal,
						@pDescripcion - Descripción del LocalCancionTemporal,
						@pEstado - Estado del LocalCancionTemporal,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
(
@pIdLocalCancionTemporal					int out,
@pIdEmpresa int,
@pIdLocal int,
@pNombreArchivo varchar(255),
@pFlagVisible char(1),
@pEstado					char(1)
)
As
Begin
	update LocalCancionTemporal
	set 
	IdEmpresa = @pIdEmpresa,
	IdLocal = @pIdLocal,
	NombreArchivo = @pNombreArchivo,
	FlagVisible = @pFlagVisible,
	Estado = @pEstado,
	FechaModificacion = GETDATE()
	where
	IdLocalCancionTemporal = @pIdLocalCancionTemporal
End
