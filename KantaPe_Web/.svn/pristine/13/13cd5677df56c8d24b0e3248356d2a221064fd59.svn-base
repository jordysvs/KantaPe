create PROCEDURE [dbo].[ListarAperturaDashBoard]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Apertura
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdMozo - Id del mozo
		@pIdUbicacionTipo - Id de tipo de ubicación
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Apertura
'* Creado Por : John Castillo
'* Fecha Creación : 19-08-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null,
	@pIdMozo int = null, 
	@pIdUbicacionTipo int = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY UT.Descripcion ASC, U.Numero ASC) AS Num_Fila,

				--Ubicacion
				U.IdLocal,
				U.IdUbicacion,
				U.IdUbicacionTipo,
				U.Numero,
				U.Capacidad,
				U.Estado,
				UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
				UT.Descripcion as UbicacionTipo_Descripcion,

				--Apertura
				AP.IdApertura as Apertura_IdApertura,
				AP.IdLocal as Apertura_IdLocal,
				AP.IdMozo as Apertura_IdMozo,
				AP.FechaApertura as Apertura_FechaApertura,
				AP.FechaFinal as Apertura_FechaFinal,
				AP.Total as Apertura_Total,
				AP.IdAlerta as Apertura_IdAlerta,
				AP.Estado as Apertura_Estado,
				US.IdUsuario as Usuario_IdUsuario,
				PEU.IdPersona as Usuario_Persona_IdPersona,
				PEU.Nombres as Usuario_Persona_Nombres,
				PEU.ApellidoPaterno as Usuario_Persona_ApellidoPaterno,
				PEU.ApellidoMaterno as Usuario_Persona_ApellidoMaterno,
				PEU.IdTipoDocumento as Usuario_Persona_IdTipoDocumento,
				PEU.NumeroDocumento as Usuario_Persona_NumeroDocumento,

				--Local
				L.IdLocal as Local_IdLocal,
				L.IdEmpresa as Local_IdEmpresa,
				L.IdDireccion as Local_IdDireccion,
				PD.IdPersona as PersonaDireccion_IdPersona,
				PD.IdDireccion as PersonaDireccion_IdDireccion,
				PD.IdUbigeo as PersonaDireccion_IdUbigeo,
				PD.Nombre as PersonaDireccion_Nombre,
				PD.Direccion as PersonaDireccion_Direccion,
				PE.IdPersona as Persona_IdPersona,
				PE.IdTipoDocumento as Persona_IdTipoDocumento,
				PE.NumeroDocumento as Persona_NumeroDocumento,
				PE.RazonSocial as Persona_RazonSocial,
				PE.NombreComercial as Persona_NombreComercial,
				EM.IdEmpleado as Empleado_IdEmpleado,
				EM.IdPersona as Empleado_IdPersona,
				PEM.IdPersona as Empleado_Persona_IdPersona,
				PEM.Nombres as Empleado_Persona_Nombres,
				PEM.ApellidoPaterno as Empleado_Persona_ApellidoPaterno,
				PEM.ApellidoMaterno as Empleado_Persona_ApellidoMaterno,
				PEM.IdTipoDocumento as Empleado_Persona_IdTipoDocumento,
				PEM.NumeroDocumento as Empleado_Persona_NumeroDocumento,

				--Alerta
				A.IdLocal as Alerta_IdLocal,
				A.IdUbicacion as Alerta_IdUbicacion,
				AL.IdAlerta as Alerta_IdAlerta,
				AL.IdAlertaTipo as Alerta_IdAlertaTipo,
				AL.FechaAlerta as Alerta_FechaAlerta,
				AL.FechaAtencion as Alerta_FechaAtencion,
				AL.IdUsuario as Alerta_IdUsuario,
				AT.IdAlertaTipo as AlertaTipo_IdAlertaTipo,
				AT.Descripcion as AlertaTipo_Descripcion,
				AUS.IdUsuario as Alerta_Usuario_IdUsuario,
				AUS.IdPersona as Alerta_Usuario_IdPersona,
				APEU.IdPersona as Alerta_Usuario_Persona_IdPersona,
				APEU.Nombres as Alerta_Usuario_Persona_Nombres,
				APEU.ApellidoPaterno as Alerta_Usuario_Persona_ApellidoPaterno,
				APEU.ApellidoMaterno as Alerta_Usuario_Persona_ApellidoMaterno,
				APEU.IdTipoDocumento as Alerta_Usuario_Persona_IdTipoDocumento,
				APEU.NumeroDocumento as Alerta_Usuario_Persona_NumeroDocumento,

				COUNT(*) OVER() Total_Filas
			From Ubicacion U
			inner join UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			left join 
			(
				select ALER.IdLocal,ALER.IdUbicacion,ALER.IdAlerta
				From
				(select 
				ROW_NUMBER() OVER (
					PARTITION BY A.IdLocal,A.IdUbicacion 
					ORDER BY A.FechaAlerta ASC) as Num_Fila,
				A.IdLocal,A.IdUbicacion,A.IdAlerta
				from Alerta A
				 where
				A.Estado = 'P' AND
				A.FechaAtencion is null AND
				(A.FechaAlerta >= dateadd(hour,-1,[dbo].getdatesys()) AND
				A.FechaAlerta <= [dbo].getdatesys()) AND
				A.IdLocal = @pIdLocal 
				) ALER
				where ALER.Num_Fila = 1
			)ALE on
			ALE.IdLocal = U.IdLocal AND
			ALE.IdUbicacion = U.IdUbicacion
			left join Alerta AL on
			--AL.IdLocal = U.IdLocal AND
			AL.IdUbicacion = U.IdUbicacion AND
			AL.IdAlerta = ALE.IdAlerta
			--(AL.Estado = 'A' OR AL.Estado = 'P')
			--AL.Estado = 'P'
			--AL.Estado = 'A'
			left join AlertaTipo AT on
			AT.IdAlertaTipo = AL.IdAlertaTipo AND
			AT.Estado = 'A'
			left join SecurityUsuario AUS on
			AUS.IdUsuario = AL.IdUsuario
			left join CorePersona APEU on
			APEU.IdPersona = AUS.IdPersona

			left join
			(
				select APU.IdLocal, APU.IdApertura,APU.IdMozo,APU.IdUbicacion, APU.IdUsuario
				FROM (
					select ROW_NUMBER() OVER (
					PARTITION BY A.IdApertura ORDER BY A.FechaApertura ASC) as Num_Fila,
					A.IdLocal,A.IdApertura,A.IdMozo,AU.IdUbicacion, AUS.IdUsuario
					from AperturaUbicacion AU 
					inner join AperturaUsuario AUS on
					AUS.IdLocal = AU.IdLocal AND
					AUS.IdApertura = AU.IDApertura AND
					AUS.Administrador = 'S' AND
					AUS.Estado = 'A'
					inner join Apertura A on
					A.IdLocal = AU.IdLocal AND
					A.IdApertura = AU.IdApertura AND
					A.Estado = 'A'
					Where
					A.IdLocal = @pIdLocal AND
					--[dbo].setDateSys(A.FechaApertura) >= [dbo].getdatesys() - 30 AND
					--[dbo].setDateSys(A.FechaApertura) <= [dbo].getdatesys() AND
					A.FechaApertura >= [dbo].getdatesys() - 30 AND
					A.FechaApertura <= [dbo].getdatesys() AND
					A.FechaFinal is null)
				APU where APU.Num_Fila = 1
			) A on
			A.IdLocal = U.IdLocal AND
			A.IdUbicacion = U.IdUbicacion
			left join Apertura AP on
			AP.IdLocal = A.IdLocal AND
			AP.IdApertura = A.IdApertura
			left join SecurityUsuario US on
			US.IdUsuario = A.IdUsuario
			left join CorePersona PEU on
			PEU.IdPersona = US.IdPersona

			inner join Local L on
			L.IdLocal = U.IdLocal AND
			L.Estado = 'A'
			inner join CorePersonaDireccion PD on
			PD.IdPersona = L.IdEmpresa AND
			PD.IdDireccion = L.IdDireccion AND
			PD.Estado = 'A'
			inner join CorePersona PE on
			PE.IdPersona = L.IdEmpresa AND
			PE.Estado = 'A'
			left join Empleado EM on
			EM.IdEmpleado = A.IdMozo AND
			EM.Estado = 'A'
			left join CorePersona PEM on
			PEM.IdPersona = EM.IdPersona AND
			PEM.Estado = 'A'
			Where 
				U.Estado = 'A' AND
				U.IdLocal = @pIdLocal AND
				(@pIdMozo is null or A.IdMozo = @pIdMozo) AND
				(@pIdUbicacionTipo is null or U.IdUbicacionTipo = @pIdUbicacionTipo) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
