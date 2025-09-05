create PROCEDURE [dbo].[InsertarEmpresa]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de la empresa
	para el usuario
'*	Input			:	@pIdEmpresa - Id de la empresa,
						@pEstado - Estado de la empresa,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
@pIdEmpresa				int,
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

Insert into Empresa(
IdEmpresa,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdEmpresa,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
