create PROCEDURE [dbo].[ListarAperturaMesaCerradoInicio] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarAperturaMesaCerradoInicio]
'* Input :
		@pIdLocal - Id del local

'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 09-03-2017
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdUbicacionTipo int = null
)
AS
BEGIN
			Select
				COUNT(AL.IdAlerta) OVER() Alerta_Cantidad,
				A.FechaFinal 
			From Apertura A
			INNER JOIN Local LO on
			LO.IdLocal = A.IdLocal
			left join Alerta AL on 
			AL.IdAlerta = A.IdAlerta 
			inner join AperturaUbicacion AU on
			AU.IdApertura = A.IdApertura
			inner join Ubicacion U on
			U.IdUbicacion = AU.IdUbicacion
			inner join UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			

			Where 
			    CONVERT (DATE, A.FechaApertura)  = CONVERT (date, GETDATE()) AND
		        (LO.IdLocal = @pIdLocal) AND
				(UT.IdUbicacionTipo = @pIdUbicacionTipo) and
				A.FechaFinal is not null
				
END
