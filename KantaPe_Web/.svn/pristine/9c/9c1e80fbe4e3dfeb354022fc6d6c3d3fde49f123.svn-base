create PROCEDURE [dbo].[CoreListarPersonaDireccion]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de CorePersonaDireccion
'* Input :
		@pIdPersona - IdPersona del CorePersonaDireccion
		@pIdDireccion - IdDireccion del CorePersonaDireccion
		@pIdUbigeo - IdUbigeo del CorePersonaDireccion
		@pNombre - Nombre del CorePersonaDireccion
		@pDireccion - Direccion del CorePersonaDireccion
		@pLatitud - Latitud del CorePersonaDireccion
		@pLogitud - Logitud del CorePersonaDireccion
		@pPrincipal - Principal del CorePersonaDireccion
		@pEstado - Estado del CorePersonaDireccion
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de CorePersonaDireccion
'* Creado Por : Kruma
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdPersona int = null, 
	@pIdDireccion int = null, 
	@pIdUbigeo int = null, 
	@pNombre varchar(50) = null, 
	@pDireccion varchar(100) = null, 
	@pLatitud varchar(50) = null, 
	@pLongitud varchar(50) = null, 
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
				ROW_NUMBER() OVER (ORDER BY T.IdDireccion ASC) AS Num_Fila,
				T.IdPersona,
				T.IdDireccion,
				T.IdUbigeo,
				T.Nombre,
				T.Direccion,
				T.Latitud,
				T.Longitud,
				T.Principal,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,
				COUNT(*) OVER() Total_Filas
			From CorePersonaDireccion T
			Where 
				(@pIdPersona is null or T.IdPersona = @pIdPersona) AND
				(@pIdDireccion is null or T.IdDireccion = @pIdDireccion) AND
				(@pIdUbigeo is null or T.IdUbigeo = @pIdUbigeo) AND
				(@pNombre is null or T.Nombre like '%' + @pNombre + '%') AND
				(@pDireccion is null or T.Direccion like '%' + @pDireccion + '%') AND
				(@pLatitud is null or CAST(T.Latitud as VARCHAR(MAX)) like '%' + @pLatitud + '%') AND
				(@pLongitud is null or CAST(T.Longitud as VARCHAR(MAX)) like '%' + @pLongitud + '%') AND
				(@pPrincipal is null or T.Principal = @pPrincipal) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
