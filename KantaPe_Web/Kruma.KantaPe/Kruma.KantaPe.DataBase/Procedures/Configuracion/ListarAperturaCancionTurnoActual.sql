create PROCEDURE [dbo].[ListarAperturaCancionTurnoActual] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de canciones de la Apertura de Turno
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de canciones de la apertura
'* Creado Por : Diego Mendoza
'* Fecha Creación : 11-05-2017
'**********************************************************************************
*/
(
	@pIdTurno int = null, 
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY AC.IdAperturaCancionTipo ASC, AC.Orden ASC) AS Num_Fila,
				--AperturaCancion
				AC.IdLocal,
				AC.IdApertura,
				AC.IdAperturaCancion,
				AC.IdUsuario,
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
			JOIN AperturaCancionTipo ACT on
			ACT.IdAperturaCancionTipo = AC.IdAperturaCancionTipo
			JOIN LocalCancion C on
			AC.IdLocalCancion = C.IdLocalCancion
			JOIN Cancion CAN on
			CAN.IdCancion = C.IdCancion
			LEFT JOIN Album AL on
			AL.IdAlbum = C.IdAlbum
			JOIN Artista AR on
			AR.IdArtista = C.IdArtista
			JOIN SecurityUsuario U on
			U.IdUsuario = AC.IdUsuario
			JOIN CorePersona PE on
			PE.IdPersona = U.IdPersona
			LEFT JOIN CoreTipoDocumento TD on
			TD.IdTipoDocumento = PE.IdTipoDocumento
			JOIN Apertura AP
			ON AP.IdApertura = AC.IdApertura
			Where 
				AC.IdAperturaCancion in (select IdAperturaCancion from TurnoDetalle 
										where IdTurno = @pIdTurno and 
										IdLocal = @pIdLocal and 
										IdApertura=@pIdApertura) AND
				AP.FlagTurno = 'S' AND AC.IdAperturaCancionTipo in (1,3)
				AND (@pIdLocal is null or AC.IdLocal = @pIdLocal)
				AND (@pIdApertura is null or AC.IdApertura = @pIdApertura)
				AND AP.Estado = 'A' AND AC.Estado = 'A'
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
