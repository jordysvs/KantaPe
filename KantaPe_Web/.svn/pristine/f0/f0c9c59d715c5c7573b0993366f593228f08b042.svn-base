create PROCEDURE [dbo].[ListarTiempoAtencionMozoTop] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarTiempoAtencionMozoTop]
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdAperturaCancion - Id de la apertura cancion
		@pIdUsuario - Id del usuario
		@pIdCancion - Id de la cancion
		@pIdAperturaCancionTipo - Id del tipo de la apertura cancion
		@pAdministrador - Usuario administrador
		@pEstado - Estado del Apertura
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 17-03-2017
'**********************************************************************************
*/
(
	@pNombreCompleto varchar(200) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null
)
AS
BEGIN
			Select
				--(select  avg(DiferenciaDias) from (select DATEDIFF( minute ,AL.FechaAlerta , Al.FechaAtencion) as DiferenciaDias) t) as Diferencia,	
				Sum(DATEDIFF( minute ,AL.FechaAlerta , Al.FechaAtencion) ) as DiferenciaFecha,		
				----Empresa
				--EM.NombreComercial as Empresa_NombreComercial,
				--Local
		       	CPD.Direccion as Local_Direccion,
				--Mozo
				MO.ApellidoPaterno + ' '+ MO.ApellidoMaterno+', '+ MO.Nombres as Mozo_NombreCompleto,
				count(1) as Cantidad
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
			left join Alerta AL on
			AL.IdAlerta = A.IdAlerta
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
				CONVERT (DATE,A.FechaApertura) between CONVERT (DATE,@pFechaInicio) And CONVERT (DATE,@pFechaFin)
			     ))
		  group by MO.ApellidoPaterno + ' '+ MO.ApellidoMaterno+', '+ MO.Nombres, CPD.Direccion
END
