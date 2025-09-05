create Procedure [dbo].[InsertarUbicacion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de la ubicación
'*	Input			:	@pIdLocal - Id del local,
						@pIdUbicacionTipo - Id del tipo de ubicación,
						@pNumero - Numero de ubicación,
						@pCapacidad - Capacidad de la ubicación,
						@pEstado - Estado del artista,
						@pUsuarioCreacion - Usuario creación
'*	Output			: @pIdUbicacion - Id de la ubicación,
'*	Creado Por		: John Castillo
'*	Fec Creación		: 03/08/2016
'**********************************************************************************
*/
(
@pIdUbicacion				int out,
@pIdUbicacionTipo			int,
@pIdLocal					int,
@pNumero					int,
@pCapacidad					int,
@pEstado					char(1),
@pUsuarioCreacion			varchar(20)
)
AS

select @pIdUbicacion = ISNULL(MAX(IdUbicacion),0)+1 from Ubicacion Where IdUbicacion > 0

Insert into Ubicacion(
IdLocal,
IdUbicacion,
IdUbicacionTipo,
Numero,
Capacidad,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdLocal,
@pIdUbicacion,
@pIdUbicacionTipo,
@pNumero,
@pCapacidad,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
