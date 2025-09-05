create PROCEDURE [dbo].[ListarSolicitarPedidoCarta]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Alerta
'* Input :
		@pIdLocal - IdLocal del Alerta
		@pIdUbicacion - IdUbicacion del Alerta
		@pIdAlerta - IdAlerta del Alerta
		@pIdAlertaTipo - IdAlertaTipo del Alerta
		@pFechaInicio - Fecha Inicio de la Alerta
		@pFechaFin - Fecha Fin de la Alerta
		@pIdUsuario - IdUsuario del Alerta
		@pEstado - Estado del Alerta
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Alerta
'* Creado Por : John Castillo
'* Fecha Creación : 25-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdUbicacion int = null, 
	@pIdAlerta int = null, 
	@pIdAlertaTipo int = null, 
	@pFechaInicio DateTime = null, 
	@pFechaFin DateTime = null, 
	@pIdUsuario varchar(20) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.FechaAlerta DESC) AS Num_Fila,
				T.IdLocal,
				T.IdUbicacion,
				T.IdAlerta,
				T.IdAlertaTipo,
				T.FechaAlerta,
				T.FechaAtencion,
				T.IdUsuario,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				--Local
				L.IdLocal as Local_IdLocal,
				L.IdEmpresa as Local_IdEmpresa,
				L.IdDireccion as Local_IdDireccion,
				U.IdLocal as Ubicacion_IdLocal,
				U.IdUbicacion as Ubicacion_IdUbicacion,
				U.IdUbicacionTipo as Ubicacion_IdUbicacionTipo,
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
				--Ubicacion
				U.Numero as Ubicacion_Numero,
				U.Capacidad as Ubicacion_Capacidad,
				UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
				UT.Descripcion as UbicacionTipo_Descripcion,
				--AlertaTipo
				AT.IdAlertaTipo as AlertaTipo_IdAlertaTipo,
				AT.Descripcion as AlertaTipo_Descripcion,
				--Usuario
				US.IdUsuario as Usuario_IdUsuario,
				US.IdPersona as Usuario_IdPersona,
				PEU.IdPersona as Usuario_Persona_IdPersona,
				PEU.Nombres as Usuario_Persona_Nombres,
				PEU.ApellidoPaterno as Usuario_Persona_ApellidoPaterno,
				PEU.ApellidoMaterno as Usuario_Persona_ApellidoMaterno,
				PEU.IdTipoDocumento as Usuario_Persona_IdTipoDocumento,
				PEU.NumeroDocumento as Usuario_Persona_NumeroDocumento,
				COUNT(*) OVER() Total_Filas
			From Alerta T
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
			inner join Ubicacion U on
			U.IdUbicacion = T.IdUbicacion AND
			U.Estado = 'A'
			inner join UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo AND
			UT.Estado = 'A'
			inner join AlertaTipo AT on
			AT.IdAlertaTipo = T.IdAlertaTipo AND
			AT.Estado = 'A'
			inner join SecurityUsuario US on
			US.IdUsuario = T.IdUsuario
			inner join CorePersona PEU on
			PEU.IdPersona = US.IdPersona
			Where 
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdUbicacion is null or T.IdUbicacion = @pIdUbicacion) AND
				(@pIdAlerta is null or T.IdAlerta = @pIdAlerta) AND
				(@pIdAlertaTipo is null or T.IdAlertaTipo = @pIdAlertaTipo) AND
				(@pFechaInicio is null or T.FechaAlerta >= @pFechaInicio) AND
				(@pFechaFin is null or T.FechaAlerta <= @pFechaFin) AND
				(@pIdUsuario is null or T.IdUsuario = @pIdUsuario) AND
				(@pEstado is null or T.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
