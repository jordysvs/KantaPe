create PROCEDURE [dbo].[ListarAperturaUbicacion] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de ubicaciones de la Apertura
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdUbicacion - Id de la ubicacion
		@pEstado - Estado del Apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de canciones de la apertura
'* Creado Por : John Castillo
'* Fecha Creación : 07-09-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pIdUbicacion int = null,
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY AU.IdLocal, AU.IdApertura DESC) AS Num_Fila,
				--AperturaUbicacion
				AU.IdLocal,
				AU.IdApertura,
				AU.IdUbicacion,
				AU.Estado,
				AU.UsuarioCreacion,
				AU.FechaCreacion,
				AU.UsuarioModificacion,
				AU.FechaModificacion,
				--Ubicacion
				U.IdLocal as Ubicacion_IdLocal,
				U.IdUbicacion as Ubicacion_IdUbicacion,
				U.IdUbicacionTipo as Ubicacion_IdUbicacionTipo,
				U.Numero as Ubicacion_Numero,
				U.Capacidad as Ubicacion_Capacidad,
				--UbicacionTipo
				UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
				UT.Descripcion as UbicacionTipo_Descripcion,
				
				COUNT(*) OVER() Total_Filas
			From AperturaUbicacion AU
			inner join Ubicacion U on
			AU.IdUbicacion = U.IdUbicacion
			inner join UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			Where 
				(@pIdLocal is null or AU.IdLocal = @pIdLocal) AND
				(@pIdApertura is null or AU.IdApertura = @pIdApertura) AND
				(@pIdUbicacion is null or AU.IdUbicacion = @pIdUbicacion) AND
				(@pEstado is null or AU.Estado = @pEstado) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
