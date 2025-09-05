create PROCEDURE [dbo].[ListarLocal]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Local
'* Input :
		@pIdLocal - IdLocal del Local
		@pIdEmpresa - IdEmpresa del Local
		@pIdDireccion - IdDireccion del Local
		@pNombre - Nombre del Local
		@pDireccion - Dirección del Local
		@pIdPais - Id del pais
		@pIdDepartamento - Id del departamento
		@pIdProvincia - Id de la provincia
		@pIdDistrito - Id del distrito
		@pEstado - Estado del Local
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Local
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdEmpresa int = null, 
	@pIdDireccion int = null, 
	@pNombre varchar(50) = null, 
	@pDireccion varchar(100) = null, 
	@pIdPais int = null,
	@pIdDepartamento int = null,
	@pIdProvincia int = null,
	@pIdDistrito int = null,
	@pEstado varchar(1) = null,
	@pHoraInicio int = null, 
	@pHoraFin int = null,  
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY PE.NombreComercial ASC,PD.Nombre ASC) AS Num_Fila,
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
				PD.Principal as CorePersonaDireccion_Principal,

				U.IdUbigeo as Ubigeo_IdUbigeo,
				U.IdPais as Ubigeo_IdPais,
				U.IdDepartamento as Ubigeo_IdDepartamento,
				U.IdProvincia as Ubigeo_IdProvincia,
				U.IdDistrito as Ubigeo_IdDistrito,

				P.IdPais as Pais_IdPais,
				P.Descripcion as Pais_Descripcion,
				
				D.IdDepartamento as Departamento_IdDepartamento,
				D.Descripcion as Departamento_Descripcion,

				PR.IdProvincia as Provincia_IdProvincia,
				PR.Descripcion as Provincia_Descripcion,

				DI.IdDistrito as Distrito_IdDistrito,
				DI.Descripcion as Distrito_Descripcion,

				EM.IdEmpresa as Empresa_IdEmpresa,

				PE.IdPersona as CorePersona_IdPersona,
				PE.RazonSocial as CorePersona_RazonSocial,
				PE.NombreComercial as CorePersona_NombreComercial,
				PE.IdTipoDocumento as CorePersona_IdTipoDocumento,
				PE.NumeroDocumento as CorePersona_NumeroDocumento,

				PET.Numero as CorePersonaTelefono_Numero,

				PEM.Mail as CorePersonaMail_Mail,
				COUNT(*) OVER() Total_Filas
			From Local T
			inner join CorePersonaDireccion PD on
			PD.IdPersona = T.IdEmpresa AND
			PD.IdDireccion = T.IdDireccion AND
			PD.Estado = 'A'
			inner join CoreUbigeo U on
			U.IdUbigeo = PD.IdUbigeo AND
			U.Estado = 'A'
			left join CorePais P on
			P.IdPais = U.IdPais AND
			P.Estado = 'A'
			left join CoreDepartamento D on
			D.IdDepartamento = U.IdDepartamento AND
			D.Estado = 'A'
			left join CoreProvincia PR on
			PR.IdProvincia = U.IdProvincia AND
			PR.Estado = 'A'
			left join CoreDistrito DI on
			DI.IdDistrito = U.IdDistrito AND
			DI.Estado = 'A'
			inner join Empresa EM on
			EM.IdEmpresa = T.IdEmpresa AND
			EM.Estado = 'A'
			inner join CorePersona PE on
			PE.IdPersona = EM.IdEmpresa AND
			PE.Estado = 'A'
			left join CorePersonaTelefono PET on
			PET.IdPersona = PE.IdPersona AND
			PET.Estado = 'A'
			left join CorePersonaMail PEM on
			PEM.IdPersona = PE.IdPersona AND
			PEM.Estado = 'A'
			Where 
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdEmpresa is null or T.IdEmpresa = @pIdEmpresa) AND
				(@pIdDireccion is null or T.IdDireccion = @pIdDireccion) AND
				(@pNombre is null or PD.Nombre like '%' + @pNombre + '%') AND
				(@pDireccion is null or PD.Direccion like '%' + @pDireccion + '%') AND
				(@pIdPais is null or P.IdPais = @pIdPais) AND
				(@pIdDepartamento is null or D.IdDepartamento = @pIdDepartamento) AND
				(@pIdProvincia is null or PR.IdProvincia = @pIdProvincia) AND
				(@pIdDistrito is null or DI.IdDistrito = @pIdDistrito) AND
				(@pHoraInicio is null or T.HoraInicio = @pHoraInicio) AND
				(@pHoraFin is null or T.HoraFin = @pHoraFin) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
