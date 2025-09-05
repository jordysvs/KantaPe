create PROCEDURE [dbo].[ReporteTiempoAtencion] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ReporteTiempoAtencion]
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
	@pNroUbicacion int = null,
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY EM.NombreComercial  DESC) AS Num_Fila,
					
                (select DATEDIFF( minute ,Al.FechaAlerta , Al.FechaAtencion ) ) as DiferenciaFechas,
				--Apertura
				A.FechaApertura,			
				--Empresa
				EM.NombreComercial as Empresa_NombreComercial,
				--Local
		       	CPD.Direccion as Local_Direccion,
				--Mozo
				MO.ApellidoPaterno + ' '+ MO.ApellidoMaterno+', '+ MO.Nombres as Mozo_NombreCompleto,
				--Ubicacion
				U.Numero as Ubicacion_Numero,
				--Ubicacion Tipo
				UT.Descripcion as UbicacionTipo_Descripcion,
				--Alerta
				AL.IdAlerta as Alerta_IdAlerta,
				Al.FechaAlerta as Alerta_FechaAlerta,
				Al.FechaAtencion as Alerta_FechaAtencion,
				--Aleta Tipo
				AT.Descripcion as AlertaTipo_Descripcion,
				COUNT(*) OVER() Total_Filas
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
			LEFT JOIN AlertaTipo AT on
			AT.IdAlertaTipo = AL.IdAlertaTipo
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
				((CONVERT (DATE,@pFechaInicio) is null AND CONVERT (DATE,@pFechaFin) is null)  or 
			    (
				CONVERT (DATE,A.FechaApertura) between CONVERT (DATE,@pFechaInicio) and CONVERT (DATE,@pFechaFin)
			     ))AND
				(@pIdUbicacionTipo is null or UT.IdUbicacionTipo = @pIdUbicacionTipo)AND
				(@pNroUbicacion is null or U.Numero = @pNroUbicacion)
			
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
