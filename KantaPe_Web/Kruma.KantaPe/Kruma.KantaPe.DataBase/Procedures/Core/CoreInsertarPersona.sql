create PROCEDURE [dbo].[CoreInsertarPersona]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de la persona
	para el usuario
'*	Input			:	@pIdPersona - Id de la persona,
						@pApellidoPaterno - Apellido paterno de la persona,
						@pApellidoMaterno - Apellido materno de la persona,
						@pNombres - Nombre de la persona,
						@pMail - Mail de la persona,
						@pCelular - Celular de la persona,
						@pEstado - Estado de la persona,
						@pUsuarioCreacion - Usuario creacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
@pIdTipoDocumento		int,
@pNumeroDocumento		varchar(20),
@pNombres				varchar(50),
@pApellidoPaterno		varchar(50),
@pApellidoMaterno		varchar(50),
@pRazonSocial			varchar(50),
@pNombreComercial		varchar(50),
@pFechaNacimiento		datetime,
@pIdEstadoCivil			int,
@pGenero				int,
@pEstado				char(1),
@pUsuarioCreacion		varchar(20),
@pIdPersona				int out
)
AS

select @pIdPersona = ISNULL(MAX(IdPersona),0)+1 from CorePersona Where IdPersona > 0

Insert into CorePersona(
IdPersona,
IdTipoDocumento,
NumeroDocumento,
Nombres,
ApellidoPaterno,
ApellidoMaterno,
RazonSocial,
NombreComercial,
FechaNacimiento,
Genero,
IdEstadoCivil,
Sistema,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdPersona,
@pIdTipoDocumento,
@pNumeroDocumento,
@pNombres,
@pApellidoPaterno,
@pApellidoMaterno,
@pRazonSocial,
@pNombreComercial,
@pFechaNacimiento,
@pGenero,
@pIdEstadoCivil,
'N',
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
