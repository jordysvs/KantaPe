create PROCEDURE [dbo].[ListarHoraReporte] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarHoraReporte]
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
	@pIdLocal int = null,
	@pFecha datetime = null,
	@pHoraInicio int = null, 
	@pHoraFin int = null,
	@pIdUbicacionTipo int = null,
	@pNroUbicacion int = null
)
AS
BEGIN
			Select			
				CONVERT(DATE,A.FechaApertura) as Fecha,
				DATEPART(HH, A.FechaApertura) as Hora,
				DATEPART(HH, A.FechaFinal) as HoraFinal
			From Ubicacion U
			INNER JOIN UbicacionTipo UT on 
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			INNER JOIN Local LO on
			LO.IdLocal = U.IdLocal
			INNER JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa
			INNER JOIN AperturaUbicacion AU on
			AU.IdUbicacion = U.IdUbicacion
			INNER JOIN Apertura A on
			A.IdApertura = AU.IdApertura
			Where 
			    (@pIdEmpresa is null or Lo.IdEmpresa = @pIdEmpresa) AND
		        (@pIdLocal is null or LO.IdDireccion = @pIdLocal) AND
				(@pFecha IS NULL AND (CONVERT (DATE, A.FechaApertura) = CONVERT (date, GETDATE())) OR
				(CONVERT(DATE,A.FechaApertura) = CONVERT (DATE,@pFecha))) AND
				((@pHoraInicio is null AND @pHoraFin is null)  or 
			    (
				DATEPART(HH, A.FechaApertura) between @pHoraInicio and @pHoraFin
			     ))AND
				(@pIdUbicacionTipo is null or U.IdUbicacionTipo = @pIdUbicacionTipo)and
				(@pNroUbicacion is null or U.Numero = @pNroUbicacion)

			Group by CONVERT(DATE,A.FechaApertura), DATEPART(HH, A.FechaApertura),DATEPART(HH, A.FechaFinal)
			Order by CONVERT(DATE,A.FechaApertura), DATEPART(HH, A.FechaApertura),DATEPART(HH, A.FechaFinal) asc
	END
