create PROCEDURE [dbo].[ListarLocalCancionTemporal]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de canciones
'*	Input			: 	
						@pNumPagina - Número de página,
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Vicente Gonzales
'*	Fec Creación	: 02/06/2017
'**********************************************************************************
*/
(
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin

	--set @pNumPagina = 1
	--set @pTamPagina = 20

		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY C.IdLocalCancionTemporal ASC) AS Num_Fila,
			C.IdLocalCancionTemporal,
			C.IdEmpresa,
			C.IdLocal,
			C.NombreArchivo,
			C.FlagVisible,
			C.Estado,
			C.UsuarioCreacion,
			C.FechaCreacion,
			C.UsuarioModificacion,
			C.FechaModificacion,
			CP.NombreComercial as Empresa_NombreComercial,
			CPD.Direccion as Local_Direccion,
			COUNT(*) OVER() Total_Filas
			From LocalCancionTemporal C
			LEFT JOIN CorePersona CP on
			CP.IdPersona = C.IdEmpresa
			LEFT JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = C.IdLocal and CPD.IdPersona=C.IdEmpresa
			Where 
			C.FlagVisible = 'S' and
			(@pIdEmpresa is null or C.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or C.IdLocal = @pIdLocal)
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
