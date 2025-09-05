create PROCEDURE [dbo].[ListarTotalUbicacion] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarTotalUbicacion]
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

				COUNT(*) OVER() Cantidad
			From Ubicacion U
			INNER JOIN Local LO on
			LO.IdLocal = U.IdLocal
			inner join UbicacionTipo UT on
			UT.IdUbicacionTipo = U.IdUbicacionTipo
			

			Where 
		        (LO.IdLocal = @pIdLocal) AND
				(UT.IdUbicacionTipo = @pIdUbicacionTipo)and 
				(U.Estado = 'A')
				
END
