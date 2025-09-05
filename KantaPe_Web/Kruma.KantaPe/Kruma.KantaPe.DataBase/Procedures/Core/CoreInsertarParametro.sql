create procedure [dbo].[CoreInsertarParametro]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del parametro
	para el usuario
'*	Input			:	@pIdModulo - Codigo del modulo,
						@pIdParametro - Codigo del parámetro,
						@pDescripcion - Descripción del parámetro,
						@pValor - Valor del parámetro
						@pEstado - Estado del parámetro,
						@pUsuarioCreacion - Usuario de creación
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
@pIdModulo				char(8),
@pIdParametro			varchar(20),
@pDescripcion			varchar(100),
@pValor					varchar(100),
@pEstado				char(1),
@pUsuarioCreacion		varchar(20)
)
AS

Insert into CoreParametro(
IdModulo,
IdParametro,
Descripcion,
Valor,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdModulo,
@pIdParametro,
@pDescripcion,
@pValor,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
