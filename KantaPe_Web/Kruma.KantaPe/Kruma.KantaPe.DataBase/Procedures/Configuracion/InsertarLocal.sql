create PROCEDURE [dbo].[InsertarLocal]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción de Local
'* Input :
		@pIdEmpresa - IdEmpresa del Local
		@pIdDireccion - IdDireccion del Local
		@pEstado - Estado del Local
		@pUsuarioCreacion - UsuarioCreacion del Local
'* Output : 
		@pIdLocal - Id Local del Local
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdEmpresa int = null, 
	@pIdDireccion int = null, 
	@pEstado varchar(1) = null, 
	@pHoraInicio int = null, 
	@pHoraFin int = null,
	@pRadio decimal(18, 2) = null,
	@pUsuarioCreacion varchar(20) = null, 
	@pIdLocal int out
)
AS
BEGIN
		Select @pIdLocal = IsNull(Max(IdLocal),0)+1 From Local Where IdLocal > 0

		Insert Into Local
		(
			IdLocal,
			IdEmpresa,
			IdDireccion,
			Estado,
			HoraInicio,
			HoraFin,
			Radio,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdLocal,
			@pIdEmpresa,
			@pIdDireccion,
			@pEstado,
			@pHoraInicio,
			@pHoraFin,
			@pRadio,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
