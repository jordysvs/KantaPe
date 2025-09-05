create PROCEDURE [dbo].[FileServerListarAlmacen] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de almacen de documentos
'* Input :
		@pIdAlmacen - IdAlmacen del almacen de documentos
		@pDescripcion - Descripcion del almacen de documentos
		@pRuta - Ruta del almacen de documentos
		@pEstado - Estado del almacen de documentos
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de almacen de documentos
'* Creado Por : John Castillo
'* Fecha Creación : 23-07-2015
'**********************************************************************************
*/
(
	@pIdModulo varchar(max) = null,
	@pIdAlmacen int = null, 
	@pDescripcion varchar(50) = null, 
	@pRuta varchar(200) = null, 
	@pEstado char(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdAlmacen ASC) AS Num_Fila,
				T.IdModulo,
				T.IdAlmacen,
				T.Descripcion,
				T.Ruta,
				T.TipoAlmacen,
				T.Usuario,
				T.Clave,
				T.Dominio,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				M.IdModulo as Modulo_IdModulo,
				M.Descripcion as Modulo_Descripcion,
				COUNT(*) OVER() Total_Filas
			From FileServerAlmacen T
			inner join CoreModulo M ON
			M.IdModulo = T.IdModulo AND
			M.Estado = 'A'
			Where 
				(@pIdModulo is null or T.IdModulo in 
					(SELECT item FROM Split(',',@pIdModulo))) AND
				(@pIdAlmacen is null or T.IdAlmacen = @pIdAlmacen) AND
				(@pDescripcion is null or T.Descripcion like '%' + @pDescripcion + '%') AND
				(@pRuta is null or T.Ruta like '%' + @pRuta + '%') AND
				(@pEstado is null or T.Estado like '%' + @pEstado + '%')
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
