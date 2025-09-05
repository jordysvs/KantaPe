create PROCEDURE [dbo].[ListarTokenNotificacion]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de TokenNotificacion
'* Input :
		@pIdToken - IdToken del TokenNotificacion
		@pFecha - Fecha del TokenNotificacion
		@pIdUsuario - IdUsuario del TokenNotificacion
		@pTitulo - Titulo del TokenNotificacion
		@pMensaje - Mensaje del TokenNotificacion
		@pEstado - Estado del TokenNotificacion
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de TokenNotificacion
'* Creado Por : John Castillo
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdToken varchar(200) = null, 
	@pFechaInicio DateTime = null, 
	@PFechaFin DateTime = null,
	@pIdUsuario varchar(20) = null, 
	@pTitulo varchar(100) = null, 
	@pMensaje varchar(200) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdToken, T.Fecha ASC) AS Num_Fila,
				T.IdToken,
				T.Fecha,
				T.IdUsuario,
				T.Titulo,
				T.Mensaje,
				T.Resultado,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From TokenNotificacion T
			Where 
				(@pIdToken is null or T.IdToken = @pIdToken) AND
				(@pFechaInicio is null or T.Fecha >= @pFechaInicio) AND
				(@pFechaFin is null or T.Fecha <= @pFechaFin) AND
				(@pIdUsuario is null or T.IdUsuario = @pIdUsuario) AND
				(@pTitulo is null or T.Titulo like '%' + @pTitulo + '%') AND
				(@pMensaje is null or T.Mensaje like '%' + @pMensaje + '%') AND
				(@pEstado is null or T.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));END;
