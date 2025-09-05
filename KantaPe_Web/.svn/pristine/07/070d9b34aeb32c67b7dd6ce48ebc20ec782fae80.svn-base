create PROCEDURE [dbo].[ListarEmpresaTemporal]
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
AS
BEGIN

			Select
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
END
