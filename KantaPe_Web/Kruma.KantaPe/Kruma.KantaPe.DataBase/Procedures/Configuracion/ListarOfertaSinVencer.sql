create PROCEDURE [dbo].[ListarOfertaSinVencer]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de ofertas
'*	Input			: 	
						@pIdLocal - Id del local
						@pIdOferta - Id de la oferta,
						@pNombre - Nombre de la oferta
						@pDescripcion - Descripcion del oferta,
						@pFechaInicio - Fecha de inicio de la oferta,
						@pFechaFin - Fecha final de la oferta,
						@pEstado - Estado del auto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 08/08/2016
'**********************************************************************************
*/
(
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pIdOferta int = null,
	@pNombre varchar(100) = null,
	@pDescripcion varchar(100) = null,
	@pFechaInicio datetime = null,
	@pFechaFin datetime = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY T.Nombre ASC) AS Num_Fila,
			T.IdLocal,
			T.IdOferta,
			T.Nombre,
			T.Descripcion,
			T.FechaOferta,
			T.FechaVencimiento,
			T.IdImagen,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,

			--Local
			L.IdLocal as Local_IdLocal,
			L.IdEmpresa as Local_IdEmpresa,
			L.IdDireccion as Local_IdDireccion,

			--CorePersonaDireccion
			PD.IdPersona as CorePersonaDireccion_IdPersona,
			PD.IdDireccion as CorePersonaDireccion_IdDireccion,
			PD.Nombre as CorePersonaDireccion_Nombre,
			PD.Direccion as CorePersonaDireccion_Direccion,

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

			COUNT(*) OVER() Total_Filas
			From Oferta T
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
			(T.FechaVencimiento > [dbo].getDateSys())and
			(T.Estado = 'A')and
			(@pIdEmpresa is null or E.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
			(@pIdOferta is null or T.IdOferta = @pIdOferta) AND
			(@pNombre is null or T.Nombre like '%' + @pNombre + '%') AND 
			(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pFechaInicio is null or (T.FechaVencimiento is not null AND
			(convert(datetime,convert(varchar(8),T.FechaVencimiento,112)) >= convert(datetime,convert(varchar(8),@pFechaInicio,112))))) AND
			(@pFechaFin is null or (T.FechaVencimiento is not null AND
			(convert(datetime,convert(varchar(8),T.FechaVencimiento,112)) <= convert(datetime,convert(varchar(8),@pFechaFin,112))))) AND
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
