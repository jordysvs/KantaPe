create PROCEDURE [dbo].[ActualizarEmpresa]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de la empresa
	para el usuario
'*	Input			:	@pIdEmpresa - Id de la empresa,
						@pEstado - Estado de la empresa,
						@pUsuarioModificacion - Usuario modificación
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
@pIdEmpresa				int,
@pEstado				char(1),
@pUsuarioModificacion	varchar(20)
)
AS

Update Empresa
set 
Estado = @pEstado,
UsuarioModificacion = @pUsuarioModificacion,
FechaModificacion = getdate()
where
IdEmpresa = @pIdEmpresa
