CREATE PROCEDURE [dbo].[SecurityListarPerfilGrupoDetalleAccesoPerfil] 
/*
'**********************************************************************************
'*	Procedimiento almacenado encargado de obtener las opciones permitidas del perfil
	para el usuario
'*	Input			:	@pIdModulo - Codigo del modulo
						@pIdPerfil - Codigo del perfil
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 31/07/2015
'**********************************************************************************
*/
(
@pIdModulo		char(8),
@pIdPerfil		varchar(20),
@pIdModuloGrupo	char(8)
)
AS
Begin

	Set NoCount On  

	
		Select
		G.IdModulo as Grupo_IdModulo, 
		G.IdGrupo as Grupo_IdGrupo,
		G.Descripcion as Grupo_Descripcion,
		G.Orden as Grupo_Orden,

		GD.IdModulo as Detalle_IdModulo,
		GD.IdGrupo as Detalle_IdGrupo,
		GD.IdDetalle as Detalle_IdDetalle,
		GD.Descripcion as Detalle_Descripcion,
		GD.IdDetallePadre as Detalle_IdDetallePadre,
		GD.Orden as Detalle_Orden,
		GD.URL as Detalle_URL,
		GD.FlagVisible as Detalle_FlagVisible,

		M.IdModulo as Modulo_IdModulo,
		M.Descripcion as Modulo_Descripcion,

		CASE WHEN PGDA.IdPerfil is not null THEN 1 ELSE 0 END as Seleccion
		from [SecurityGrupoDetalle] GD
		inner join [CoreModulo] M ON
		M.IdModulo = GD.IdModulo AND
		M.Estado = 'A'
		inner join [SecurityGrupo] G ON
		G.IdModulo = GD.IdModulo AND
		G.IdGrupo = GD.IdGrupo AND
		G.Estado = 'A'
		left join  [SecurityPerfilGrupoDetalleAcceso] PGDA ON
		GD.IdModulo = PGDA.IdModuloGrupo AND
		GD.IdGrupo = PGDA.IdGrupo AND
		GD.IdDetalle = PGDA.IdDetalle AND
		PGDA.Estado = 'A' AND
		PGDA.IdModulo = @pIdModulo AND
		PGDA.IdPerfil = @pIdPerfil
		Where 
		GD.Estado = 'A' 
		AND
		(@pIdModuloGrupo IS NULL OR M.IdModulo = @pIdModuloGrupo)
		order by G.Orden,GD.Orden

	Set NoCount Off
End
