create PROCEDURE [dbo].[ListarProducto]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de productos
'*	Input			: 	
						@pIdEmpresa - Id de la empresa
						@pIdLocal - Id del local
						@pIdProducto - Id del producto,
						@pNombre - Nombre del producto,
						@pIdProductoTipo - Id del tipo de producto,
						@pCosto - Costo del producto,
						@pPrecio - Precio del producto,
						@pEstado - Estado del producto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 18/08/2016
'**********************************************************************************
*/
(
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pIdProducto int = null,
	@pNombre varchar(100) = null,
	@pIdProductoTipo int = null,
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
			T.IdProducto,
			T.Nombre,
			T.IdProductoTipo,
			T.Costo,
			T.Precio,
			T.IdImagen,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,

			--Tipo de Producto
			PT.IdProductoTipo as ProductoTipo_IdProductoTipo,
			PT.Descripcion as ProductoTipo_Descripcion,

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
			From Producto T
			inner join ProductoTipo PT on
			PT.IdProductoTipo = T.IdProductoTipo AND
			PT.Estado = 'A'
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
			(@pIdProducto is null or T.IdProducto = @pIdProducto) AND
			(@pIdProductoTipo is null or T.IdProductoTipo = @pIdProductoTipo) AND
			(@pNombre is null or T.Nombre like '%' + @pNombre + '%') AND 
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
