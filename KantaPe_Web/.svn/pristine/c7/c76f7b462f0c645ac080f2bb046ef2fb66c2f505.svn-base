create PROCEDURE [dbo].[CoreListarPersonaMail]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CorePersonaMail
'* Input :
		@pIdPersona - IdPersona del CorePersonaMail
		@pIdMail - Id Mail de CorePersonaMail
		@pMail - Mail del CorePersonaMail
		@pIdTipoMail - IdTipoMail del CorePersonaMail
		@pPrincipal - Principal del CorePersonaMail
		@pEstado - Estado del CorePersonaMail
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CorePersonaMail
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdMail int = null,
	@pMail varchar(50) = null, 
	@pIdMailTipo int = null, 
	@pPrincipal varchar(1) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.Mail ASC) AS Num_Fila,
				T.IdPersona,
				T.IdMail,
				T.Mail,
				T.IdMailTipo,
				T.Principal,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CorePersonaMail T
			Where 
				(@pIdPersona is null or T.IdPersona = @pIdPersona) AND
				(@pIdMail is null or T.IdMail = @pIdMail) AND
				(@pMail is null or T.Mail like '%' + @pMail + '%') AND
				(@pIdMailTipo is null or T.IdMailTipo = @pIdMailTipo) AND
				(@pPrincipal is null or T.Principal = @pPrincipal) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
