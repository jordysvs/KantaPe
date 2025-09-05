create PROCEDURE [dbo].[ListarUbicacion]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de ubicaciones
'*	Input			: 	@pIdUbicacionTipo - Id tipo de ubicación,
						@pDescripcion - Descripción del tipo de ubicación,
						@pEstado - Estado del tipo de ubicación,
						@pNumPagina - Número de página,
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 03/08/2016
'**********************************************************************************
*/
(
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pIdUbicacion int = null,
	@pIdUbicacionTipo int = null,
	@pNumero varchar(100) = null,
	@pCapacidad varchar(100) = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY T.Numero ASC) AS Num_Fila,
			T.IdLocal,
			T.IdUbicacion,
			T.IdUbicacionTipo,
			T.Numero,
			T.Capacidad,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,
			
			--Local
			L.IdLocal as Local_IdLocal,
			L.IdEmpresa as Local_IdEmpresa,
			L.IdDireccion as Local_IdDireccion,
			L.Radio as Local_Radio,

			--CorePersonaDireccion
			PD.IdPersona as CorePersonaDireccion_IdPersona,
			PD.IdDireccion as CorePersonaDireccion_IdDireccion,
			PD.Nombre as CorePersonaDireccion_Nombre,
			PD.Direccion as CorePersonaDireccion_Direccion,
			PD.Longitud as CorePersonaDireccion_Longitud,
			PD.Latitud as CorePersonaDireccion_Latitud,

			--Empresa
			E.IdEmpresa as Empresa_IdEmpresa,

			--CorePersona
			PE.IdPersona as CorePersona_IdPersona,
			PE.RazonSocial as CorePersona_RazonSocial,
			PE.NombreComercial as CorePersona_NombreComercial,
			PE.IdTipoDocumento as CorePersona_IdTipoDocumento,
			PE.NumeroDocumento as CorePersona_NumeroDocumento,

			--TipoDocumento
			TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
			TD.Descripcion as TipoDocumento_Descripcion,

			--Ubicacion Tipo
			UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
			UT.Descripcion as UbicacionTipo_Descripcion,

			COUNT(*) OVER() Total_Filas
			From Ubicacion T
			inner join UbicacionTipo UT on
			T.IdUbicacionTipo = UT.IdUbicacionTipo AND
			UT.Estado = 'A'
			inner join Local L on
			L.IdLocal = T.IdLocal AND
			L.Estado = 'A'
			inner join Empresa E on
			E.IdEmpresa = L.IdEmpresa AND
			E.Estado = 'A'
			inner join CorePersona PE on
			PE.IdPersona = E.IdEmpresa AND
			PE.Estado = 'A'
			inner join CoreTipoDocumento TD on
			TD.IdTipoDocumento = PE.IdTipoDocumento AND
			TD.Estado = 'A'
			inner join CorePersonaDireccion PD on
			PD.IdPersona = L.IdEmpresa AND
			PD.IdDireccion = L.IdDireccion AND
			PD.Principal = 'N' AND
			PD.Estado = 'A'
			Where 
			(@pIdEmpresa is null or E.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
			(@pIdUbicacion is null or T.IdUbicacion = @pIdUbicacion) AND
			(@pIdUbicacionTipo is null or T.IdUbicacionTipo = @pIdUbicacionTipo) AND
			(@pNumero is null or CAST(T.Numero as varchar(MAX)) like '%' + @pNumero + '%') AND
			(@pCapacidad is null or CAST(T.Capacidad as varchar(MAX)) like '%' + @pCapacidad + '%') AND
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
