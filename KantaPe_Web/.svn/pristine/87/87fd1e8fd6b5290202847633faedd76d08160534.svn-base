create PROCEDURE [dbo].[CoreActualizarPersona]
/*
'**********************************************************************************
'*	Procedimiento almacenado de actualización de la persona
	para el usuario
'*	Input			: 	@pIdPersona - Codigo de la persona
						@pApellidoPaterno - Apellido paterno de la persona
						@pApellidoMaterno - Apellido materno de la persona
						@pNombres - Nombres de la persona
						@pMail - mail del la persona
						@pCelular - Celular de la persona,
						@pEstado - Estado de la persona
						@pUsuarioModificacion - Usuario de modificacion
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 09/08/2015
'**********************************************************************************
*/
(
	@pIdTipoDocumento int,
	@pNumeroDocumento varchar(20),
	@pIdPersona int,
	@pNombres varchar(50),
	@pApellidoPaterno varchar(50),
	@pApellidoMaterno varchar(50),
	@pRazonSocial varchar(50),
	@pNombreComercial varchar(50),
	@pIdEstadoCivil int,
	@pGenero char(1),
	@pFechaNacimiento datetime,
	@pEstado char(1),
	@pUsuarioModificacion varchar(20)
)
As
Begin
	update CorePersona
	set 
	IdTipoDocumento = @pIdTipoDocumento,
	NumeroDocumento = @pNumeroDocumento,
	Nombres = @pNombres,
	ApellidoPaterno = @pApellidoPaterno,
	ApellidoMaterno = @pApellidoMaterno,
	RazonSocial = @pRazonSocial,
	NombreComercial = @pNombreComercial,
	IdEstadoCivil = @pIdEstadoCivil,
	Genero = @pGenero,
	FechaNacimiento = @pFechaNacimiento,
	Estado = @pEstado,
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = GETDATE()
	where
	IdPersona = @pIdPersona
End
