create PROCEDURE [dbo].[ListarApertura] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Apertura
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdMozo - Id del mozo
		@pFechaInicio - Fecha de inicio de apertura
		@pFechaFinal - Fecha final de apertura
		@pIdAlerta - Id de alerta de la apertura
		@pIdUbicacion - Id de ubicación de la apertura
		@pActual - Flag Actual la apertura actual
		@pEstado - Estado del Apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Apertura
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pIdMozo int = null, 
	@pFechaInicio DateTime = null, 
	@pFechaFin DateTime = null, 
	@pIdAlerta int = null, 
	@pIdUbicacion int = null, 
	@pActual int = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.FechaApertura DESC) AS Num_Fila,
				T.IdApertura,
				T.IdLocal,
				T.IdMozo,
				T.FechaApertura,
				T.FechaFinal,
				T.Total,
				T.IdAlerta,
				T.Ronda,
				T.FlagTurno,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
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
				ASU.IdUsuario as Apertura_Usuario_IdUsuario,
				ASU.IdPersona as Apertura_Usuario_IdPersona,
				APE.IdPersona as Apertura_Persona_IdPersona,
				APE.Nombres as Apertura_Persona_Nombres,
				APE.ApellidoPaterno as Apertura_Persona_ApellidoPaterno,
				APE.ApellidoMaterno as Apertura_Persona_ApellidoMaterno,
				COUNT(*) OVER() Total_Filas
			From Apertura T
			inner join Local L on
			L.IdLocal = T.IdLocal AND
			L.Estado = 'A'
			inner join CorePersonaDireccion PD on
			PD.IdPersona = L.IdEmpresa AND
			PD.IdDireccion = L.IdDireccion AND
			PD.Estado = 'A'
			inner join CorePersona PE on
			PE.IdPersona = L.IdEmpresa AND
			PE.Estado = 'A'
			inner join Empleado EM on
			EM.IdEmpleado = T.IdMozo AND
			EM.Estado = 'A'
			inner join CorePersona PEM on
			PEM.IdPersona = EM.IdPersona AND
			PEM.Estado = 'A'
			left join AperturaUsuario AUS on
			AUS.IdApertura = T.IdApertura AND
			AUS.Estado = 'A' AND
			AUS.Administrador = 'S'
			left join SecurityUsuario ASU on
			ASU.IdUsuario = AUS.IdUsuario
			left join CorePersona APE on
			APE.IdPersona = ASU.IdPersona
			Where 
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdApertura is null or T.IdApertura = @pIdApertura) AND
				(@pIdMozo is null or T.IdMozo = @pIdMozo) AND
				(@pFechaInicio is null or T.FechaApertura >= @pFechaInicio) AND
				(@pFechaFin is null or T.FechaApertura <= @pFechaFin) AND
				(@pIdAlerta is null or T.IdAlerta = @pIdAlerta) AND
				(@pEstado is null or T.Estado = @pEstado) and
				(@pIdUbicacion is null or EXISTS(
					Select IdUbicacion 
					from AperturaUbicacion
					where 
					IdLocal = T.IdLocal AND
					IdApertura = T.IdApertura AND
					IdUbicacion = @pIdUbicacion AND
					Estado = 'A')) AND
				(@pActual is null or (
					T.FechaApertura >= [dbo].getdatesys() - 30 AND
					T.FechaApertura <= [dbo].getdatesys() AND
					T.FechaFinal is null))
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
