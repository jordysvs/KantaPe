create PROCEDURE [dbo].[SecurityListarGrupo] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de SecurityGrupo
'* Input :
		@pIdModulo - IdModulo del SecurityGrupo
		@pIdGrupo - IdGrupo del SecurityGrupo
		@pDescripcion - Descripcion del SecurityGrupo
		@pURL - URL del SecurityGrupoDetalle,
		@pFlagVisible - Visibilidad del SceurityGrupoDetalle,
		@pEstado - Estado del SecurityGrupo
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de SecurityGrupo
'* Creado Por : Kruma
'* Fecha Creación : 27-07-2015
'**********************************************************************************
*/
(
	@pIdModulo varchar(max) = null,
	@pIdGrupo varchar(8) = null, 
	@pDescripcion varchar(50) = null, 
	@pURL varchar(500) = null,
	@pFlagVisible char(1) = null,
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select MTBL.*
			From(
				Select
					ROW_NUMBER() OVER (ORDER BY T.Orden ASC) AS Num_Fila,
					T.IdModulo,
					T.IdGrupo,
					T.Descripcion,
					T.Orden,
					T.IdImagen,
					T.Estado,
					T.UsuarioCreacion,
					T.FechaCreacion,
					T.UsuarioModificacion,
					T.FechaModificacion,
					(
						select count(1) from SecurityGrupoDetalle SGD
						where 
						SGD.IdModulo = T.IdModulo AND
						SGD.IdGrupo = T.IdGrupo AND
						SGD.IdDetallePadre is NULL AND
						(@pFlagVisible is null or SGD.FlagVisible = @pFlagVisible) AND
						(@pURL is null or SGD.URL like '%' + @pURL + '%') AND
						(@pEstado is null or SGD.Estado = @pEstado)
					) Total_Detalle,
					COUNT(*) OVER() Total_Filas
				From SecurityGrupo T
				Where 
					(@pIdModulo is null or T.IdModulo in 
						(SELECT item FROM [dbo].Split(',',@pIdModulo))) AND
					(@pIdGrupo is null or T.IdGrupo like '%' + @pIdGrupo + '%') AND
					(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
					(@pEstado is null or T.Estado = @pEstado)
			) MTBL
			where
			(@pFlagVisible is null or MTBL.Total_Detalle > 0) AND
			(@pURL is null or MTBL.Total_Detalle > 0) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
