create PROCEDURE [dbo].[ListarEmpleado]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Empleado
'* Input :
		@pIdEmpleado - IdEmpleado del Empleado
		@pIdPersona - IdPersona del Empleado
		@pIdEmpresa - IdEmpresa del Empleado
		@pIdArea - IdArea del Empleado
		@pIdPuesto - IdPuesto del Empleado
		@pFechaIngreso - FechaIngreso del Empleado
		@pEstado - Estado del Empleado
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Empleado
'* Creado Por : John Castillo
'* Fecha Creación : 19-07-2016
'**********************************************************************************
*/
(
	@pIdEmpleado int = null, 
	@pIdEmpresa int = null,
	@pIdPersona int = null,
	@pIdLocal int = null,
	@pIdTipoDocumento int = null,
	@pNumeroDocumento varchar(20) = null,
	@pNombreCompleto varchar(100) = null,
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdEmpleado ASC) AS Num_Fila,
				--Empleado
				T.IdEmpleado,
				T.IdPersona,
				T.IdEmpresa,
				T.IdLocal,
				T.IdArea,
				T.IdPuesto,
				T.FechaIngreso,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				--Persona
				P.IdPersona as CorePersona_IdPersona,
				P.IdTipoDocumento as CorePersona_IdTipoDocumento,
				P.NumeroDocumento as CorePersona_NumeroDocumento,
				P.Nombres as CorePersona_Nombres,
				P.ApellidoPaterno as CorePersona_ApellidoPaterno,
				P.ApellidoMaterno as CorePersona_ApellidoMaterno,
				--Persona - TipoDocumento
				TD.IdTipoDocumento as CoreTipoDocumento_IdTipoDocumento,
				TD.Descripcion as CoreTipoDocumento_Descripcion,
				--Empresa
				E.IdEmpresa as Empresa_IdEmpresa,
				PE.IdPersona as Empresa_IdPersona,
				PE.IdTipoDocumento as Empresa_IdTipoDocumento,
				PE.NumeroDocumento as Empresa_NumeroDocumento,
				PE.RazonSocial as Empresa_RazonSocial,
				PE.NombreComercial as Empresa_NombreComercial,
				--Empresa - TipoDocumento
				ETD.IdTipoDocumento as Empresa_CoreTipoDocumento_IdTipoDocumento,
				ETD.Descripcion as Empresa_CoreTipoDocumento_Descripcion,
				--Local
				L.IdLocal as Local_IdLocal,
				L.IdEmpresa as Local_IdEmpresa,
				L.IdDireccion as Local_IdDireccion,
				PD.IdPersona as Local_CorePersonaDireccion_IdPersona,
				PD.IdDireccion as Local_CorePersonaDireccion_IdDireccion,
				PD.Nombre as Local_CorePersonaDireccion_Nombre,
				PD.Direccion as Local_CorePersonaDireccion_Direccion,
				COUNT(*) OVER() Total_Filas

			From Empleado T
			inner join CorePersona P on
			P.IdPersona = T.IdPersona 
			inner join CoreTipoDocumento TD on
			TD.IdTipoDocumento = P.IdTipoDocumento 
			inner join Empresa E on
			E.IdEmpresa = T.IdEmpresa 
			inner join CorePersona PE on
			PE.IdPersona = E.IdEmpresa 
			inner join CoreTipoDocumento ETD on
			ETD.IdTipoDocumento = PE.IdTipoDocumento 
			inner join Local L on
			L.IdLocal = T.IdLocal 
			inner join CorePersonaDireccion PD on
			PD.IdPersona = E.IdEmpresa AND
			PD.IdDireccion = L.IdDireccion AND
			PD.Principal = 'N' 
			Where 
				(@pIdEmpleado is null or T.IdEmpleado = @pIdEmpleado) AND
				(@pIdEmpresa is null or T.IdEmpresa = @pIdEmpresa) AND
				(@pIdPersona is null or T.IdPersona = @pIdPersona) AND
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdTipoDocumento is null or P.IdTipoDocumento = @pIdTipoDocumento) AND
				(@pNumeroDocumento is null or P.NumeroDocumento like '%' + @pNumeroDocumento + '%') AND
				(@pNombreCompleto is null or 
					((P.Nombres like '%' + @pNombreCompleto + '%') OR
					(P.ApellidoPaterno like '%' + @pNombreCompleto + '%') OR
					(P.ApellidoMaterno like '%' + @pNombreCompleto + '%'))) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
