create  PROCEDURE [dbo].[ListarToken]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Token
'* Input :
		@pIdUsuario - IdUsuario del Token
		@pIdToken - IdToken del Token
		@pEstado - Estado del Token
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Token
'* Creado Por : John Castillo
'* Fecha Creación : 15-04-2017
'**********************************************************************************
*/
(
	@pIdUsuario varchar(20) = null, 
	@pIdToken varchar(200) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdUsuario ASC) AS Num_Fila,
				T.IdUsuario,
				T.IdToken,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From Token T
			Where 
				(@pIdUsuario is null or T.IdUsuario = @pIdUsuario) AND
				(@pIdToken is null or T.IdToken = @pIdToken) AND
				(@pEstado is null or T.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));END;
