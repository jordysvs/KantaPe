create PROCEDURE [dbo].[ListaUbicacionReporte] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListaUbicacionReporte]
'* Input :
		@pNombreCompleto - Nombre completo
		@pIdEmpresa - Id de la empresa
		@pIdLocal - Id del local
		@pIdUsuario - Id del usuario
		@pIdCancion - Id de la cancion
		@pIdAperturaCancionTipo - Id del tipo de la apertura cancion
		@pAdministrador - Usuario administrador
		@pEstado - Estado del Apertura
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 20-03-2017
'**********************************************************************************
*/
(
	@pIdEmpresa int = null,
	@pIdLocal int = null
)
AS
BEGIN
			Select 
			U.IdUbicacion as Ubicacion_IdUbicacion,
			U.Numero as Ubicacion_Numero,
			UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
			UT.Descripcion as UbicacionTipo_Descripcion
			From
			Ubicacion U
			INNER JOIN UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			INNER JOIN Local LO on
			LO.IdLocal = U.IdLocal
			INNER JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion AND
			CPD.IdPersona = LO.IdEmpresa
			
			
			Where 
			    (@pIdEmpresa is null or LO.IdEmpresa = @pIdEmpresa) AND
		        (@pIdLocal is null or LO.IdDireccion = @pIdLocal)

				order by UT.Descripcion ,U.Numero
	END
