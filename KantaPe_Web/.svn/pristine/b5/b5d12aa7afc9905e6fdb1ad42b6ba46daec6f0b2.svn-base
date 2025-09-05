create PROCEDURE [dbo].[SecurityListarPerfilGrupoDetalleProcesoAccesoUsuario] 
/*
'**********************************************************************************
'*	Procedimiento almacenado encargado de obtener las opciones de acceso
	para el usuario
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 22/11/2014
'**********************************************************************************
*/
(
@pIdModulo char(8),
@pUsuario varchar(20)
)
AS
Begin

	Set NoCount On  

	
		Select 
		PGDPA.IdPerfil,
		PGDPA.IdGrupo,
		PGDPA.IdDetalle,
		PGDPA.IdProceso,
		PGDPA.Estado,
		PGDPA.UsuarioCreacion,
		PGDPA.FechaCreacion,
		PGDPA.UsuarioModificacion,
		PGDPA.FechaModificacion,
		GDP.Descripcion as GDP_Descripcion,
		GDP.NombreControl as GDP_NombreControl,
		GDP.Estado as GDP_Estado,
		GDP.UsuarioCreacion as GDP_UsuarioCreacion,
		GDP.FechaCreacion as GDP_FechaCreacion,
		GDP.UsuarioModificacion as GDP_UsuarioModificacion,
		GDP.FechaModificacion as GDP_FechaModificacion
		from [SecurityPerfilGrupoDetalleProcesoAcceso] PGDPA
		inner join [SecurityGrupoDetalleProceso] GDP on
		GDP.IdGrupo = PGDPA.IdGrupo AND
		GDP.IdDetalle = PGDPA.IdDetalle AND
		GDP.IdProceso = PGDPA.IdProceso AND
		GDP.Estado = 'A'
		inner join (
			Select IdModulo,IdPerfil 
			from [SecurityPerfilUsuario] PU
			where 
			(
			(@pIdModulo is null OR PU.IdModulo = @pIdModulo) AND
			(@pUsuario is null  OR PU.IdUsuario = @pUsuario))
		) PER on
		PER.IdModulo = PGDPA.IdModulo AND
		PER.IdPerfil = PGDPA.IdPerfil
		where 
		PGDPA.Estado = 'A' 
	
	Set NoCount Off
End
