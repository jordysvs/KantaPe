create PROCEDURE [dbo].[ReporteCancionPedida] 
/*
'**********************************************************************************
'* Procedimiento almacenado de ReporteCancionPedida
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
'* Creado Por : John Castillo
'* Fecha Creación : 07-09-2016
'**********************************************************************************
*/
(
	@pIdEmpresa int,
	@pIdLocal int,
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null,
	@pDesArtista varchar(200) = null,
	@pDesAlbum varchar(200) = null,
	@pIdGenero int = null,
	@pIdIdioma int = null,
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY (select count(IdLocalCancion) from AperturaCancion where IdLocalCancion = C.IdLocalCancion)  DESC) AS Num_Fila,
					
				--LocalCancion
				C.IdLocalCancion as LocalCancion_IdLocalCancion,
				C.IdAlbum as LocalCancion_IdAlbum,
				C.IdArtista as LocalCancion_IdArtista,
				C.IdCancion as LocalCancion_IdCancion,
				--Cancion 
				CAN.IdCancion as Cancion_IdCancion,
				CAN.Descripcion as Cancion_Descripcion,
				--Album
				AL.IdAlbum as Album_IdAlbum,
				AL.Titulo as Album_Titulo,
				--Artista
				AR.IdArtista as Artista_IdArtista,
				AR.Nombre as Artista_Nombre,
				--Genero
				GE.IdGenero as Genero_IdGenero,
				GE.Descripcion as Genero_Descripcion,
				--Idioma
				ID.IdIdioma as Idioma_IdIdioma,
				ID.Descripcion as Idioma_Descripcion,
				--Empresa
				EM.NombreComercial as Empresa_NombreComercial,
				--Local
		       	CPD.Direccion as Local_Direccion,

				(select count(IdLocalCancion) from AperturaCancion where IdLocalCancion = C.IdLocalCancion) as CantidadPedido,

				COUNT(*) OVER() Total_Filas
			From 
            (select ac.idlocal,ac.IdLocalCancion, count(1) as cantidad
            from aperturacancion ac
			LEFT JOIN Local LO on
			LO.IdLocal = ac.IdLocal
			LEFT JOIN CorePersona EM on
			EM.IdPersona = LO.IdEmpresa
			LEFT JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa
			where 
			((CONVERT (DATE,@pFechaInicio) is null AND CONVERT (DATE,@pFechaFin) is null)  or 
			(
				CONVERT (DATE,ac.FechaCreacion) between CONVERT (DATE,@pFechaInicio) and CONVERT (DATE,@pFechaFin)
			)) and 
			(@pIdEmpresa is null or Lo.IdEmpresa = @pIdEmpresa) AND
		    (@pIdLocal is null or LO.IdDireccion = @pIdLocal)
            group by ac.idlocal, ac.IdLocalCancion) AC

			LEFT join LocalCancion C on
			AC.IdLocalCancion = C.IdLocalCancion
			LEFT join Cancion CAN on
			CAN.IdCancion = C.IdCancion
			LEFT join Album AL on
			AL.IdAlbum = C.IdAlbum
			LEFT join Artista AR on
			AR.IdArtista = C.IdArtista
			LEFT join Genero GE on
			GE.IdGenero = C.IdGenero
			LEFT join Idioma ID on
			ID.IdIdioma = C.IdIdioma
			LEFT JOIN Local LO on
			LO.IdLocal = ac.IdLocal
			LEFT JOIN CorePersona EM on
			EM.IdPersona = LO.IdEmpresa
			LEFT JOIN CorePersonaDireccion CPD on
			CPD.IdDireccion = LO.IdDireccion and CPD.IdPersona=LO.IdEmpresa

			Where 
			    (@pDesArtista is null or AR.Nombre like '%' + @pDesArtista + '%') AND
				(@pDesAlbum is null or AL.Titulo like '%' + @pDesAlbum + '%') AND
				(@pIdGenero is null or C.IdGenero = @pIdGenero) AND
				(@pIdIdioma is null or C.IdIdioma = @pIdIdioma)
			
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
