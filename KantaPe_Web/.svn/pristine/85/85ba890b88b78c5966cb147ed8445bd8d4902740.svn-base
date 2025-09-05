create PROCEDURE [dbo].[ListarCancionSolicitud]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de canción solicitud
'*	Input			: 	@pIdCancionSolicitud - Id de canción solicitud,
						@pDescripcion - Descripcion del género,
						@pEstado - Estado de cancion solicitud,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 12/07/2016
'**********************************************************************************
*/
(
	@pIdCancionSolicitud int = null,
	@pDescripcion varchar(100) = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY CS.IdCancionSolicitud ASC) AS Num_Fila,
			CS.IdCancionSolicitud,
			CS.Descripcion,
			CS.Estado,
			CS.UsuarioCreacion,
			CS.FechaCreacion,
			CS.UsuarioModificacion,
			CS.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From CancionSolicitud CS
			Where 
			(@pIdCancionSolicitud is null or CS.IdCancionSolicitud = @pIdCancionSolicitud) AND
			(@pDescripcion is null or CS.Descripcion like '%' + @pDescripcion + '%') AND 
			(@pEstado is null or CS.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
