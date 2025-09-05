create Procedure [dbo].[ListarUsuario] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de usuarios
	para el usuario
'*	Input			: 	@pIdUsuario - Id del usuario,
						@pUsuarioRed - Usuario de red,
						@pNombreCompleto - Nombre del empleado,
						@pIdPerfil - id del perfil,
						@pEstado - estado,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20) = null,
	@pUsuarioRed varchar(20) = null,
	@pCodigo varchar(20) = null,
	@pNombreCompleto varchar(500) = null,
	@pIdPerfil varchar(20) = null,
	@pIdPersona int = null,
	@pSistema char(1) = null,
	@pEstado char(1) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY U.IdUsuario ASC) AS Num_Fila,
		
			U.IdUsuario,
			U.IdPersona,
			U.Clave,
			U.UsuarioRed,
			U.FlagExpiracion,
			U.FechaExpiracion,
			U.FechaCambioClave,
			U.FechaOlvidoClave,
			U.FechaUltimoLogin,
			U.Sistema,
			U.Estado,
			U.UsuarioCreacion,
			U.FechaCreacion,
			U.UsuarioModificacion,
			U.FechaModificacion,

			P.IdPersona as CorePersona_IdPersona,
			P.Nombres as CorePersona_Nombres,
			P.ApellidoPaterno as CorePersona_ApellidoPaterno,
			P.ApellidoMaterno as CorePersona_ApellidoMaterno,
			CPM.Mail as CorePersona_Mail,
			P.IdTipoDocumento as CorePersona_IdTipoDocumento,
			P.NumeroDocumento as CorePersona_NumeroDocumento,
			P.RazonSocial as CorePersona_RazonSocial,
			P.NombreComercial as CorePersona_NombreComercial,
			P.Estado as CorePersona_Estado,
			CPE.NombreComercial as Empresa_NombreComercial,
			PD.Nombre as Local_Nombre,
			COUNT(*) OVER() Total_Filas  

			From SecurityUsuario U
			left join CorePersona P on
			U.IdPersona = P.IdPersona
			left join CorePersonaMail CPM on
			CPM.IdPersona = P.IdPersona AND
			CPM.Principal = 'S'
			left join Empleado E on
			U.IdPersona = E.IdPersona
			left join CorePersona CPE on
			CPE.IdPersona = E.IdEmpresa
			left join Local LO on
			Lo.IdLocal = E.IdLocal
			left join CorePersonaDireccion PD on
			PD.IdDireccion = Lo.IdDireccion and PD.IdPersona = E.IdEmpresa
			Where 
			(@pIdUsuario is null or U.IdUsuario = @pIdUsuario) AND
			(@pUsuarioRed is null or U.UsuarioRed = @pUsuarioRed) AND
			(@pCodigo is null or U.IdUsuario like '%' + @pCodigo + '%') AND
			(@pNombreCompleto is null or 
			(
			P.Nombres like '%' + @pNombreCompleto + '%' OR
			P.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
			P.ApellidoMaterno like '%' + @pNombreCompleto + '%' OR
			P.RazonSocial like '%' + @pNombreCompleto + '%' OR
			P.NombreComercial like '%' + @pNombreCompleto + '%' 
			)) AND
			(@pIdPersona is null or P.IdPersona = @pIdPersona) AND
			(@pSistema is null or U.Sistema = @pSistema) AND
			(@pEstado is null or U.Estado = @pEstado) AND
			(@pIdEmpresa is null or E.IdEmpresa = @pIdEmpresa) AND
			(@pIdLocal is null or E.IdLocal = @pIdLocal) AND
			(@pIdPerfil is null or U.IdUsuario IN (
				select IdUsuario
				from SecurityPerfilUsuario
				where IdPerfil = @pIdPerfil AND Estado = 'A'))
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
