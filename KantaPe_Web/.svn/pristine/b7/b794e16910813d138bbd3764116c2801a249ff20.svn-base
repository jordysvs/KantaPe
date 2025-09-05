create PROCEDURE [dbo].[ListarLocalCancion_OLD]
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de LocalCancion
'* Input :
		@pIdLocal - IdLocal del LocalCancion
		@pIdCancion - IdCancion del LocalCancion
		@pEstado - Estado del LocalCancion
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de LocalCancion
'* Creado Por : John Castillo
'* Fecha Creación : 21-07-2016
'**********************************************************************************
*/

(
	@pIdEmpresa int = null, 
	@pIdLocal int = null, 
	@pIdCancion int = null, 
	@pTitulo varchar(100) = null,
	@pArtista varchar(100) = null,
	@pAlbum varchar(100) = null,
	@pIdGenero int = null, 
	@pIdIdioma int = null, 
	@pPalabraClave varchar(100) = null,
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
	declare @IdCancionSolicitudAprobada int = null

	SELECT @IdCancionSolicitudAprobada = Valor
	FROM CoreParametro
	WHERE
	IdModulo = 'KANTAPE' AND
	IdParametro = 'CANSOLAPROBADA' AND
	Estado = 'A'

		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY T.IdLocal ASC) AS Num_Fila,

				--LocalCancion
				T.IdLocal,
				T.IdCancion,
				T.Estado,
				T.UsuarioCreacion,
				T.FechaCreacion,
				T.UsuarioModificacion,
				T.FechaModificacion,

				--Local
				L.IdLocal as Local_IdLocal,
				L.IdEmpresa as Local_IdEmpresa,
				L.IdDireccion as Local_IdDireccion,

				--CorePersonaDireccion
				PD.IdPersona as CorePersonaDireccion_IdPersona,
				PD.IdDireccion as CorePersonaDireccion_IdDireccion,
				PD.Nombre as CorePersonaDireccion_Nombre,
				PD.Direccion as CorePersonaDireccion_Direccion,

				--Empresa
				E.IdEmpresa as Empresa_IdEmpresa,

				--CorePersona
				PE.IdPersona as CorePersona_IdPersona,
				PE.RazonSocial as CorePersona_RazonSocial,
				PE.NombreComercial as CorePersona_NombreComercial,
				PE.IdTipoDocumento as CorePersona_IdTipoDocumento,
				PE.NumeroDocumento as CorePersona_NumeroDocumento,

				--TipoDocumento
				TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
				TD.Descripcion as TipoDocumento_Descripcion,

				--Cancion
				C.IdCancion as Cancion_IdCancion,
				C.IdCancionSimple as Cancion_IdCancionSimple,
				--C.Titulo as Cancion_Titulo,
				C.IdArtista as Cancion_IdArtista,
				C.IdAlbum as Cancion_IdAlbum,
				C.IdGenero as Cancion_IdGenero,
				C.IdIdioma as Cancion_IdIdioma,
				C.Decada as Cancion_Decada,
				C.Version as Cancion_Version,
				C.NombreArchivo as Cancion_NombreArchivo,
				C.FechaRegistro as Cancion_FechaRegistro,
				C.Anio as Cancion_Anio,
				C.Letra as Cancion_Letra,
				C.Duracion as Cancion_Duracion,
				C.Youtube as Cancion_Youtube,
				A.IdAlbum as Album_IdAlbum,
				A.Titulo as Album_Titulo,

				--Cancion Simple
				CS.IdCancionSimple as CancionSimple_IdCancionSimple,
				CS.Descripcion as CancionSimple_Descripcion,

				--Artista
				AR.IdArtista as Artista_IdArtista,
				AR.Nombre as Artista_Nombre,

				--Genero
				G.IdGenero as Genero_IdGenero,
				G.Descripcion as Genero_Descripcion,

				--Idioma
				I.IdIdioma as Idioma_IdIdioma,
				I.Descripcion as Idioma_Descripcion, 
				COUNT(*) OVER() Total_Filas

			From LocalCancion T
			inner join Local L on
			L.IdLocal = T.IdLocal AND
			L.Estado = 'A'
			inner join Empresa E on
			E.IdEmpresa = L.IdEmpresa AND
			E.Estado = 'A'
			inner join CorePersona PE on
			PE.IdPersona = E.IdEmpresa AND
			PE.Estado = 'A'
			inner join CoreTipoDocumento TD on
			TD.IdTipoDocumento = PE.IdTipoDocumento AND
			TD.Estado = 'A'
			inner join CorePersonaDireccion PD on
			PD.IdPersona = L.IdEmpresa AND
			PD.IdDireccion = L.IdDireccion AND
			PD.Principal = 'N' AND
			PD.Estado = 'A'
			inner join LocalCancion C on 
			C.IdCancion = T.IdCancion AND
			C.Estado = 'A' AND
			C.IdCancionSolicitud = @IdCancionSolicitudAprobada
			JOIN CancionSimple CS 
			on C.IdCancionSimple = CS.IdCancionSimple
			inner join Album A on
			A.IdAlbum = C.IdAlbum AND
			A.Estado = 'A'
			inner join Artista AR on
			AR.IdArtista = C.IdArtista AND
			AR.Estado = 'A'
			inner join Genero G on
			G.IdGenero = C.IdGenero AND
			G.Estado = 'A'
			inner join Idioma I on
			I.IdIdioma = C.IdIdioma AND
			I.Estado = 'A' 
			Where 
				(@pIdEmpresa is null or E.IdEmpresa = @pIdEmpresa) AND
				(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
				(@pIdCancion is null or T.IdCancion = @pIdCancion) AND
				(@pTitulo is null or CS.Descripcion = @pTitulo) AND
				(@pArtista is null or AR.Nombre = @pArtista) AND
				(@pAlbum is null or A.Titulo = @pAlbum) AND
				(@pIdGenero is null or G.IdGenero = @pIdGenero) AND
				(@pIdIdioma is null or I.IdIdioma = @pIdIdioma) AND 
				(@pPalabraClave is null or 
					(CS.Descripcion like '%' + @pPalabraClave + '%') OR
					--(A.Titulo like '%' + @pPalabraClave + '%') OR
					(AR.Nombre like '%' + @pPalabraClave + '%') OR
					(G.Descripcion like '%' + @pPalabraClave + '%') OR
					(I.Descripcion like '%' + @pPalabraClave + '%')) AND
				(@pEstado is null or T.Estado = @pEstado)
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
