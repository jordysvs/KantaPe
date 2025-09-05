create PROCEDURE [dbo].[InsertarApertura]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Apertura
'* Input :
		@pIdLocal - IdLocal del Apertura
		@pIdMozo - IdMozo del Apertura
		@pIdAlerta - IdAlerta del Apertura
		@pEstado - Estado del Apertura
		@pUsuarioCreacion - UsuarioCreacion del Apertura
'* Output : 
		@pIdApertura - IdApertura del Apertura
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdMozo int = null, 
	@pIdAlerta int = null, 
	@pFechaApertura datetime = null,
	@pEstado varchar(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdApertura int out
)
AS
BEGIN
		Select @pIdApertura = IsNull(Max(IdApertura),0)+1 
		From Apertura 
		Where IdApertura > 0 AND
		IdLocal = @pIdLocal

		Insert Into Apertura
		(
			IdLocal,
			IdApertura,
			IdMozo,
			FechaApertura,
			FechaFinal,
			Total,
			IdAlerta,
			Ronda,
			FlagTurno,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdLocal,
			@pIdApertura,
			@pIdMozo,
			--@pFechaApertura,
			[dbo].getdatesys(),
			null,
			0,
			@pIdAlerta,
			1,
			'N',
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
