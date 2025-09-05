create PROCEDURE [dbo].[ReporteUsuarioFrecuente] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ReporteUsuarioFrecuente]
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
	@pNombreCompleto varchar(200) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null,
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY  (select count(US.IdPersona)) desc) AS Num_Fila,
				--Empresa
				EM.NombreComercial as Empresa_NombreComercial,
				--Local
		       	CPD.Direccion as Local_Direccion,
				--Usuario
				US.ApellidoPaterno + ' '+ US.ApellidoMaterno+', '+ US.Nombres as Usuario_NombreCompleto,
				US.IdPersona as Usuario_IdPersona,
				--Mail
				CPM.Mail as Usuario_Mail,
				(select count(US.IdPersona)) as cantidad,
				COUNT(*) OVER() Total_Filas
			From AperturaUsuario AU
			LEFT JOIN SecurityUsuario SU on
			SU.IdUsuario = AU.IdUsuario
			LEFT JOIN CorePersona US on
			US.IdPersona = SU.IdPersona
			LEFT join CorePersonaMail CPM on
			CPM.IdPersona = US.IdPersona
			INNER JOIN Local LO on
			LO.IdLocal = AU.IdLocal
			LEFT JOIN CorePersona EM on
			EM.IdPersona = LO.IdEmpresa
			LEFT JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa	

			Where 
			(@pNombreCompleto is null or 
			(
			US.Nombres like '%' + @pNombreCompleto + '%' OR
			US.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
			US.ApellidoMaterno like '%' + @pNombreCompleto + '%' 
			)) AND
			    (@pIdEmpresa is null or Lo.IdEmpresa = @pIdEmpresa) AND
		        (@pIdLocal is null or LO.IdDireccion = @pIdLocal) AND
				((CONVERT (DATE, @pFechaInicio) is null AND CONVERT (DATE, @pFechaFin) is null)  or 
			    (
				CONVERT(DATE,AU.FechaCreacion) between CONVERT (DATE, @pFechaInicio) and CONVERT (DATE, @pFechaFin)
			     ))
				 group by  US.IdPersona,EM.NombreComercial,CPD.Direccion, US.ApellidoPaterno + ' '+ US.ApellidoMaterno+', '+ US.Nombres, CPM.Mail
			
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
