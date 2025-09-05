create PROCEDURE [dbo].[ListarEmpresa]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Empresa
'* Input :
		@pIdEmpresa - IdEmpresa del Empresa
		@pEstado - Estado del Empresa
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Empresa
'* Creado Por : John Castillo
'* Fecha Creación : 19-07-2016
'**********************************************************************************
*/
(
	@pIdEmpresa int = null, 
	@pRUC varchar(50) = null,
	@pRUCFiltro varchar(50) = null,
	@pRazonSocial varchar(100) = null,
	@pNombreComercial varchar(100) = null,
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN

		declare @vIdTipoDocumento int
		Select @vIdTipoDocumento = Valor
		From CoreParametro P
		Where
		P.IdModulo = 'CORE' AND
		P.IdParametro = 'TIPODOCUMENTORUC'
		
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdEmpresa ASC) AS Num_Fila,
				T.IdEmpresa,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				IdPersona as CorePersona_IdPersona,
				P.IdTipoDocumento as CorePersona_IdTipoDocumento,
				P.NumeroDocumento as CorePersona_NumeroDocumento,
				P.RazonSocial as CorePersona_RazonSocial,
				P.NombreComercial as CorePersona_NombreComercial,
				P.FechaNacimiento as CorePersona_FechaNacimiento,
				TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
				TD.Descripcion as TipoDocumento_Descripcion,
				COUNT(*) OVER() Total_Filas
			From Empresa T
			inner join CorePersona P on
			P.IdPersona = T.IdEmpresa AND
			P.Estado = 'A'
			inner join CoreTipoDocumento TD on
			TD.IdTipoDocumento = P.IdTipoDocumento AND
			TD.Estado = 'A'
			Where 
				(P.IdTipoDocumento = @vIdTipoDocumento) AND
				(@pIdEmpresa is null or T.IdEmpresa = @pIdEmpresa) AND
				(@pRUC is null or P.NumeroDocumento = @pRUC) AND
				(@pRUCFiltro is null or P.NumeroDocumento like '%' + @pRUCFiltro + '%') AND
				(@pRazonSocial is null or P.RazonSocial like '%' + @pRazonSocial + '%') AND
				(@pNombreComercial is null or P.NombreComercial like '%' + @pNombreComercial + '%') AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
