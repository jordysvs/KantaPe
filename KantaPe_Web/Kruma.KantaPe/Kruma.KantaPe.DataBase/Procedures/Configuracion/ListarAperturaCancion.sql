create PROCEDURE [dbo].[ListarAperturaCancion] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de canciones de la Apertura
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
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pIdAperturaCancion int = null,
	@pIdUsuario varchar(20) = null,
	@pIdLocalCancion int = null,
	@pIdAperturaCancionTipo int = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY AC.Orden) AS Num_Fila,
				--AperturaCancion
				AC.IdLocal,
				AC.IdApertura,
				AC.IdAperturaCancion,
				AC.IdUsuario,
				--AU.IdUsuario as AperturaUsuario_IdUsuario,
				--AU.Estado as AperturaUsuario_Estado,
				AC.IdLocalCancion,
				AC.IdAperturaCancionTipo,
				AC.IdAperturaCancionSolicitud,
				AC.Orden,
				AC.Estado,
				AC.UsuarioCreacion,
				AC.FechaCreacion,
				AC.UsuarioModificacion,
				AC.FechaModificacion,
				--Cancion
				C.IdLocalCancion as LocalCancion_IdLocalCancion,
				C.IdAlbum as LocalCancion_IdAlbum,
				C.IdArtista as LocalCancion_IdArtista,
				C.IdCancion as LocalCancion_IdCancion,
				C.IdIdioma as LocalCancion_IdIdioma,
				C.IdGenero as LocalCancion_IdGenero,
				C.Duracion as LocalCancion_Duracion,
				--Cancion Simple
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
				--Usuario
				U.IdUsuario as Usuario_IdUsuario,
				U.IdPersona as Usuario_IdPersona,
				PE.IdPersona as Persona_IdPersona,
				PE.IdTipoDocumento as Persona_IdTipoDocumento,
				PE.NumeroDocumento as Persona_NumeroDocumento,
				PE.Nombres as Persona_Nombres,
				PE.ApellidoPaterno as Persona_ApellidoPaterno,
				PE.ApellidoMaterno as Persona_ApellidoMaterno,
				TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
				TD.Descripcion as TipoDocumento_Descripcion,
				ACT.IdAperturaCancionTipo as AperturaCancionTipo_IdAperturaCancionTipo,
				ACT.Descripcion as AperturaCancionTipo_Descripcion,
				COUNT(*) OVER() Total_Filas
			From AperturaCancion AC
			--inner join AperturaUsuario AU
			--on AC.IdUsuario = AU.IdUsuario AND AU.Estado = 'A'
			inner join AperturaCancionTipo ACT on
			ACT.IdAperturaCancionTipo = AC.IdAperturaCancionTipo
			inner join LocalCancion C on
			AC.IdLocalCancion = C.IdLocalCancion
			inner join Cancion CAN on
			CAN.IdCancion = C.IdCancion
			inner join Artista AR on
			AR.IdArtista = C.IdArtista
			left join Album AL on
			AL.IdAlbum = C.IdAlbum
			left join Genero GE on
			GE.IdGenero = C.IdGenero
			left join Idioma ID on
			ID.IdIdioma = C.IdIdioma
			inner join SecurityUsuario U on
			U.IdUsuario = AC.IdUsuario
			inner join CorePersona PE on
			PE.IdPersona = U.IdPersona
			left join CoreTipoDocumento TD on
			TD.IdTipoDocumento = PE.IdTipoDocumento
			Where 
				--AC.IdUsuario in (select IdUsuario from AperturaUsuario where IdLocal = AC.IdLocal and IdApertura = AC.IdApertura and Estado = 'A') AND
				(@pIdLocal is null or AC.IdLocal = @pIdLocal) AND
				(@pIdApertura is null or AC.IdApertura = @pIdApertura) AND
				(@pIdAperturaCancion is null or AC.IdAperturaCancion = @pIdAperturaCancion) AND
				(@pIdUsuario is null or AC.IdUsuario = @pIdUsuario) AND
				(@pIdLocalCancion is null or AC.IdLocalCancion = @pIdLocalCancion) AND
				(@pIdAperturaCancionTipo is null or AC.IdAperturaCancionTipo = @pIdAperturaCancionTipo) AND
				(@pEstado is null or AC.Estado = @pEstado) 
				
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
