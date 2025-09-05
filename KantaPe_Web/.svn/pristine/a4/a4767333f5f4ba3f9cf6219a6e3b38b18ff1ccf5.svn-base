create PROCEDURE [dbo].[SecurityListarPerfilGrupoDetalleAcceso]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de SecurityGrupoDetalle
'* Input :
		@pIdGrupo - IdGrupo del acceso del perfil
		@pIdDetalle - IdDetalle del acceso del perfil
		@pIdPerfil - IdPerdil del acceso del perfil
		@pEstado - Estado del acceso del perfil
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de SecurityGrupoDetalle
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pIdGrupo varchar(8) = null, 
	@pIdDetalle varchar(8) = null,
	@pIdPerfil varchar(20) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdGrupo, T.IdDetalle, T.IdPerfil ASC) AS Num_Fila,
				T.IdModuloGrupo,
				T.IdGrupo,
				T.IdDetalle,
				T.IdModulo,
				T.IdPerfil,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From SecurityPerfilGrupoDetalleAcceso T
			Where 
				(@pIdModulo is null or T.IdModulo  = @pIdModulo) AND
				(@pIdGrupo is null or T.IdGrupo  = @pIdGrupo) AND
				(@pIdDetalle is null or T.IdDetalle = @pIdDetalle) AND
				(@pIdPerfil is null or T.IdPerfil = @pIdPerfil) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
