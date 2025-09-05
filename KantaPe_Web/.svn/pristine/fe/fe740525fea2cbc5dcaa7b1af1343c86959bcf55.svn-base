create PROCEDURE [dbo].[InsertarTurnoDetalle]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de TurnoDetalle
'* Input :
		@pEstado - Estado del TurnoDetalle
'* Output : 
		@pIdLocal - IdLocal del TurnoDetalle
		@pIdTurno - IdTurno del TurnoDetalle
		@pIdApertura - IdApertura del TurnoDetalle
		@pIdAperturaCancion - IdAperturaCancion del TurnoDetalle
'* Creado Por : Diego Mendoza
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdTurno int = null,
	@pIdApertura int = null,
	@pIdAperturaCancion int = null,
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null
)
AS
BEGIN

		Insert Into TurnoDetalle
		(
			IdLocal,
			IdTurno,
			IdApertura,
			IdAperturaCancion,
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
			@pIdApertura,
			@pIdAperturaCancion,
			@pEstado,
			@pUsuarioCreacion,
			[dbo].getDateSys(),
			@pUsuarioCreacion,
			[dbo].getDateSys()
		)
END
