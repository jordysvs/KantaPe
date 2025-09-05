create PROCEDURE [dbo].[InsertarLocalCancionTemporal]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción de album
'*	Input			:	@pIdCancion - Id del canción,
						@pTitulo - Titulo de cancion,
						@pIdArtista - Id del artista,
						@pEstado - Estado del Album,
						@pUsuarioCreacion - Usuario creación
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación		: 12/07/2016
'**********************************************************************************
*/
(
@pIdLocalCancionTemporal		int out,
@pNombreArchivo			varchar(255),
@pFlagVisible           char(1),
@pEstado				char(1),
@pIdEmpresa             int,
@pIdLocal               int
)
AS

select @pIdLocalCancionTemporal = ISNULL(MAX(IdLocalCancionTemporal),0)+1 from LocalCancionTemporal Where IdLocalCancionTemporal > 0

Insert into LocalCancionTemporal(
IdLocalCancionTemporal,
NombreArchivo,
FlagVisible,
Estado,
IdEmpresa,
IdLocal
)
Values
(
@pIdLocalCancionTemporal,
@pNombreArchivo,
@pFlagVisible,
@pEstado,
@pIdEmpresa,
@pIdLocal
)
