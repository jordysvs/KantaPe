create PROCEDURE [dbo].[ListarIdiomaTop] 
/*
'**********************************************************************************
'* Procedimiento almacenado de ListarIdiomaTop
'* Input :
		@pIdLocal - Id del 
		@pFechaInicio
		@pFechaFin
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
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
	@pIdIdioma int = null
)
AS
BEGIN
			select CPD.Direccion as Local_Direccion, ID.IdIdioma as Idioma_IdIdioma,ID.descripcion as Idioma_Descripcion, count(1) as cantidad
            from aperturacancion ac
			LEFT JOIN  LocalCancion C on 
			C.IdLocalCancion = AC.IdLocalCancion
			LEFT join Album AL on
			AL.IdAlbum = C.IdAlbum
			LEFT JOIN Artista AR on
			AR.IdArtista=C.IdArtista
			LEFT JOIN Genero GE on
			GE.IdGenero = C.IdGenero
			LEFT JOIN Idioma ID on
			ID.IdIdioma = C.IdIdioma
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
			(@pIdEmpresa is null or Lo.IdEmpresa = @pIdEmpresa)and
		    (@pIdLocal is null or LO.IdDireccion = @pIdLocal)and
			(@pDesArtista is null or AR.Nombre like '%' + @pDesArtista + '%') AND
				(@pDesAlbum is null or AL.Titulo like '%' + @pDesAlbum + '%') AND
				(@pIdGenero is null or C.IdGenero = @pIdGenero) AND
				(@pIdIdioma is null or C.IdIdioma = @pIdIdioma)
            group by CPD.Direccion, ID.IdIdioma, ID.Descripcion
			
END
