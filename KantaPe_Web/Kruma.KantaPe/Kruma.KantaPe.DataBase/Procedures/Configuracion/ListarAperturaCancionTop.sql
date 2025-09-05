create PROCEDURE [dbo].[ListarAperturaCancionTop] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ReporteAperturaMesa]
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdAperturaCancion - Id de la apertura cancion
		@pIdUsuario - Id del usuario
		@pIdCancion - Id de la cancion
		@pIdAperturaCancionTipo - Id del tipo de la apertura cancion
		@pAdministrador - Usuario administrador
		@pEstado - Estado del Apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 09-03-2017
'**********************************************************************************
*/
(
	
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null
)
AS
BEGIN
			select top 5
            cantidad as Cantidad,
			Cancion_Descripcion as Cancion_Descripcion,
			--Local
		    Local_Direccion as Local_Direccion
            From 
            (select CPD.Direccion as Local_Direccion,cas.descripcion as Cancion_Descripcion, count(1) as Cantidad 
            from AperturaCancion A
			INNER JOIN Local LO on
			LO.IdLocal = A.IdLocal
			INNER JOIN CorePersona EM on
			EM.IdPersona = LO.IdEmpresa
			INNER JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa
			inner join LocalCancion CAN on 
			can.IdLocalCancion = a.IdLocalCancion
			inner join Cancion CAS on 
			cas.idcancion = can.idcancion
			where 
				((@pFechaInicio is null AND @pFechaFin is null)  or 
			    (
				A.FechaCreacion between @pFechaInicio and @pFechaFin
			     ))
			group by CPD.Direccion, cas.descripcion
			)A		
		   ORDER BY Cantidad desc
           
	
END
