create PROCEDURE [dbo].[ListarAperturaTurno] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de Apertura
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdMozo - Id del mozo
		@pIdUbicacionTipo - Id de tipo de ubicación
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de Apertura
'* Creado Por : Diego Mendoza
'* Fecha Creación : 19-08-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY AP.Ronda ASC, AP.FechaApertura ASC) AS Num_Fila,
				AP.IdLocal,
				AP.IdApertura,
				AP.FechaApertura,
				AP.Ronda,
				AP.FlagTurno,
				AP.Total,
				AP.Estado,
				AP.UsuarioCreacion,
				AP.FechaCreacion,
				AP.UsuarioModificacion,
				AP.FechaModificacion,
				AU.IdUbicacion as AperturaUbicacion_IdUbicacion,
				AU.IdLocal as AperturaUbicacion_IdLocal,
				AU.IdApertura as AperturaUbicacion_IdApertura,
				U.IdUbicacion as Ubicacion_IdUbicacion,
				U.Numero as Ubicacion_Numero,
				U.IdUbicacionTipo as Ubicacion_IdUbicacionTipo,
				UT.IdUbicacionTipo as UbicacionTipo_IdUbicacionTipo,
				UT.Descripcion as UbicacionTipo_Descripcion,
				COUNT(*) OVER() Total_Filas
			From Ubicacion U
			inner join UbicacionTipo UT 
			ON UT.IdUbicacionTipo = U.IdUbicacionTipo
			JOIN 
			(
				select APU.IdLocal, APU.IdApertura,APU.IdMozo,APU.IdUbicacion, APU.IdUsuario
				FROM (
					select ROW_NUMBER() OVER (
					PARTITION BY A.IdApertura ORDER BY A.FechaApertura ASC) as Num_Fila,
					A.IdLocal,A.IdApertura,A.IdMozo,AU.IdUbicacion, AUS.IdUsuario
					from AperturaUbicacion AU 
					inner join AperturaUsuario AUS on
					AUS.IdLocal = AU.IdLocal AND
					AUS.IdApertura = AU.IDApertura AND
					AUS.Administrador = 'S' AND
					AUS.Estado = 'A'
					inner join Apertura A on
					A.IdLocal = AU.IdLocal AND
					A.IdApertura = AU.IdApertura AND
					A.Estado = 'A'
					Where
					A.IdLocal = @pIdLocal AND
					A.FechaApertura >= [dbo].getdatesys() - 30 AND
					A.FechaApertura <= [dbo].getdatesys() AND
					A.FechaFinal is null)
				APU where APU.Num_Fila = 1
			) A on
			A.IdLocal = U.IdLocal AND
			A.IdUbicacion = U.IdUbicacion
			join Apertura AP on
			AP.IdLocal = A.IdLocal AND
			AP.IdApertura = A.IdApertura
			join SecurityUsuario US on
			US.IdUsuario = A.IdUsuario
			join CorePersona PEU on
			PEU.IdPersona = US.IdPersona
			join AperturaUbicacion AU on 
			AU.IdApertura = A.IdApertura 
			AND AU.IdUbicacion = A.IdUbicacion
			Where 
				(@pIdLocal is null or U.IdLocal = @pIdLocal) 
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END


