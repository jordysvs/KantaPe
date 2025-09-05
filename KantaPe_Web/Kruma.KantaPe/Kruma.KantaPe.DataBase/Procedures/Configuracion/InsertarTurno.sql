create PROCEDURE [dbo].[InsertarTurno]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Turno
'* Input :
		@pFechaTurno - FechaTurno del Turno
		@pEstado - Estado del Turno
'* Output : 
		@pIdLocal - IdLocal del Turno
		@pIdTurno - IdTurno del Turno
'* Creado Por : Diego Mendoza
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pFechaTurno DateTime = null, 
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdTurno int out
)
AS
BEGIN

		Select @pIdTurno = IsNull(Max(IdTurno),0)+1 From Turno Where IdTurno > 0

		Insert Into Turno
		(
			IdLocal,
			IdTurno,
			FechaTurno,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdLocal,
			@pIdTurno,
			@pFechaTurno,
			@pEstado,
			@pUsuarioCreacion,
			[dbo].getDateSys(),
			@pUsuarioCreacion,
			[dbo].getDateSys()
		)
END
