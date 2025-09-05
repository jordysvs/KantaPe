create PROCEDURE [dbo].[ListarLocalTemporal]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Local
'* Input :
		@pIdEmpresa - IdEmpresa del Local
'* Output : Lista de Local
'* Creado Por : Vicente Gonzales
'* Fecha Creación : 03-06-2017
'**********************************************************************************
*/
(
	@pIdEmpresa int = null
)
AS
BEGIN
			Select
				T.IdLocal,
				T.IdEmpresa,
				T.IdDireccion,
				T.Estado,
				T.HoraInicio,
				T.HoraFin,
				T.Radio,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,

				PD.IdPersona as CorePersonaDireccion_IdPersona,
				PD.IdDireccion as CorePersonaDireccion_IdDireccion,
				PD.IdUbigeo as CorePersonaDireccion_IdUbigeo,
				PD.Nombre as CorePersonaDireccion_Nombre,
				PD.Direccion as CorePersonaDireccion_Direccion,
				PD.Latitud as CorePersonaDireccion_Latitud,
				PD.Longitud as CorePersonaDireccion_Longitud,
				PD.Principal as CorePersonaDireccion_Principal
			From Local T
			inner join CorePersonaDireccion PD on
			PD.IdDireccion = T.IdDireccion AND
			PD.Estado = 'A'
			
			Where 
				(@pIdEmpresa is null or T.IdEmpresa = @pIdEmpresa) 
END
