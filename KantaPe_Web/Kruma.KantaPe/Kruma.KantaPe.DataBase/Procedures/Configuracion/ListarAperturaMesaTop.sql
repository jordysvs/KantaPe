create PROCEDURE [dbo].[ListarAperturaMesaTop] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarAperturaMesaTop]
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdAperturaCancion - Id de la apertura cancion
		@pIdUsuario - Id del usuario
		@pIdCancion - Id de la cancion
		@pIdAperturaCancionTipo - Id del tipo de la apertura cancion
		@pAdministrador - Usuario administrador
		@pEstado - Estado del Apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 09-03-2017
'**********************************************************************************
*/
(
	@pNombreCompleto varchar(200) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null,
	@pIdUbicacionTipo int = null,
	@pNroUbicacion int = null
)
AS
BEGIN
			Select
				--Local
		       	CPD.Direccion as Local_Direccion,
				--Ubicacion
				U.Numero as Ubicacion_Numero,
				--Ubicacion Tipo
				UT.Descripcion as UbicacionTipo_Descripcion,
				COUNT(1) Cantidad
			From Apertura A
			INNER JOIN Local LO on
			LO.IdLocal = A.IdLocal
			INNER JOIN CorePersona EM on
			EM.IdPersona = LO.IdEmpresa
			INNER JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa
			INNER JOIN Empleado EMP on
			EMP.IdEmpleado = A.IdMozo
			INNER JOIN CorePersona MO on
			MO.IdPersona = EMP.IdPersona
			LEFT JOIN Alerta AL on
			AL.IdAlerta = A.IdAlerta
            LEFT JOIN Ubicacion U on
			U.IdUbicacion = AL.IdUbicacion
			LEFT JOIN UbicacionTipo UT on 
			UT.IdUbicacionTipo = U.IdUbicacionTipo

			Where 
			    (@pNombreCompleto is null or 
			(
			MO.Nombres like '%' + @pNombreCompleto + '%' OR
			MO.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
			MO.ApellidoMaterno like '%' + @pNombreCompleto + '%' 
			)) AND
			    (@pIdEmpresa is null or Lo.IdEmpresa = @pIdEmpresa) AND
		        (@pIdLocal is null or LO.IdDireccion = @pIdLocal) AND
				((convert(date,@pFechaInicio) is null AND convert(date,@pFechaFin) is null)  or 
			    (
				convert(date,A.FechaApertura) between convert(date,@pFechaInicio) and convert(date,@pFechaFin)
			     ))AND
				(@pIdUbicacionTipo is null or UT.IdUbicacionTipo = @pIdUbicacionTipo)AND
				(@pNroUbicacion is null or U.Numero = @pNroUbicacion)

			group by CPD.Direccion, UT.Descripcion, U.Numero
END
