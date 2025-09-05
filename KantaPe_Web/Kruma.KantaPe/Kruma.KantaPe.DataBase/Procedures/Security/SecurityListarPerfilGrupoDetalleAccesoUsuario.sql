CREATE PROCEDURE [dbo].[SecurityListarPerfilGrupoDetalleAccesoUsuario] 
/*
'**********************************************************************************
'*	Procedimiento almacenado encargado de obtener las opciones permitidas 
	para el usuario
'*	Input			: @pUsuario - Codigo del usuario
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 22/11/2014
'**********************************************************************************
*/
(
@pIdModulo		char(8),
@pUsuario		varchar(20)
)
AS
Begin

	Set NoCount On  

	
		Select 
		PGDA.IdModulo,
		PGDA.IdPerfil,
		PGDA.IdModuloGrupo,
		PGDA.IdGrupo,
		PGDA.IdDetalle,
		GD.IdModulo as GrupoDetalle_IdModulo,
		GD.IdGrupo as GrupoDetalle_IdGrupo,
		GD.IdDetalle GrupoDetalle_IdDetalle,
		GD.Descripcion as GrupoDetalle_Descripcion,
		GD.IdDetallePadre as GrupoDetalle_IdDetallePadre,
		GD.Orden as GrupoDetalle_Orden,
		GD.URL as GrupoDetalle_URL,
		GD.FlagVisible as GrupoDetalle_FlagVisible,
		GD.IdImagen as GrupoDetalle_IdImagen,
		GD.Estado as GrupoDetalle_Estado,
		G.IdModulo as Grupo_IdModulo,
		G.IdGrupo as Grupo_IdGrupo,
		G.Descripcion as Grupo_Descripcion,
		G.Orden as Grupo_Orden,
		G.IdImagen as Grupo_IdImagen,
		G.Estado as Grupo_Estado,
		MG.IdModulo as GrupoModulo_IdModulo,
		MG.Descripcion as GrupoModulo_Descripcion,
		MG.IdImagen as GrupoModulo_IdImagen,
		MG.Estado as GrupoModulo_Estado,
		PE.IdModulo as Perfil_IdModulo,
		PE.IdPerfil as Perfil_IdPerfil,
		PE.Descripcion as Perfil_Descripcion,
		PE.Estado as Perfil_Estado,
		MO.IdModulo as Modulo_IdModulo,
		MO.Descripcion as Modulo_Descripcion,
		MO.IdImagen as Modulo_IdImagen,
		MO.Estado as Modulo_Estado
		from [SecurityGrupoDetalle] GD
		inner join [SecurityGrupo] G ON
		G.IdModulo = GD.IdModulo AND
		G.IdGrupo = GD.IdGrupo AND
		G.Estado = 'A'
		inner join [CoreModulo] MG ON
		MG.IdModulo = G.IdModulo AND
		MG.Estado = 'A'
		Inner join  [SecurityPerfilGrupoDetalleAcceso] PGDA ON
		GD.IdModulo = PGDA.IdModuloGrupo AND
		GD.IdGrupo = PGDA.IdGrupo AND
		GD.IdDetalle = PGDA.IdDetalle AND
		PGDA.Estado = 'A'
		inner join (
			Select IdModulo, IdPerfil 
			from [SecurityPerfilUsuario] PU
			where 
			(
			PU.FlagExpiracion = 'N' OR
			(PU.FlagExpiracion = 'S' AND CONVERT(varchar(6),PU.FechaExpiracion,112) <= CONVERT(varchar(6),GETDATE(),112))
			) AND
			(@pIdModulo IS NULL OR PU.IdModulo = @pIdModulo) AND
			PU.IdUsuario = @pUsuario AND
			PU.Estado = 'A'
		) PEU ON
		PEU.IdModulo = PGDA.IdModulo AND
		PEU.IdPerfil = PGDA.IdPerfil
		inner join SecurityPerfil PE ON
		PE.IdModulo = PGDA.IdModulo AND
		PE.IdPerfil = PGDA.IdPerfil AND
		PE.Estado = 'A'
		inner join CoreModulo MO ON
		MO.IdModulo = PGDA.IdModulo AND
		MO.Estado = 'A'
		Where 
		GD.Estado = 'A'
		order by PGDA.IdModulo,PGDA.IdModuloGrupo,G.Orden,GD.Orden

	Set NoCount Off
End
