create PROCEDURE [dbo].[CoreListarPersonaTelefono]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CorePersonaTelefono
'* Input :
		@pIdPersona - IdPersona del CorePersonaTelefono
		@pIdTelefono - IdTelefono del CorePersonaTelefono
		@pIdTipoTelefono - IdTipoTelefono del CorePersonaTelefono
		@pNumero - Numero del CorePersonaTelefono
		@pPrincipal - Principal del CorePersonaTelefono
		@pEstado - Estado del CorePersonaTelefono
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CorePersonaTelefono
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdTelefono int = null, 
	@pIdTelefonoTipo int = null, 
	@pNumero varchar(50) = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdTelefono ASC) AS Num_Fila,
				T.IdPersona,
				T.IdTelefono,
				T.IdTelefonoTipo,
				T.Numero,
				T.Principal,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CorePersonaTelefono T
			Where 
				(@pIdPersona is null or T.IdPersona = @pIdPersona) AND
				(@pIdTelefono is null or T.IdTelefono = @pIdTelefono) AND
				(@pIdTelefonoTipo is null or T.IdTelefonoTipo = @pIdTelefonoTipo) AND
				(@pNumero is null or T.Numero like '%' + @pNumero + '%') AND
				(@pPrincipal is null or T.Principal = @pPrincipal) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
