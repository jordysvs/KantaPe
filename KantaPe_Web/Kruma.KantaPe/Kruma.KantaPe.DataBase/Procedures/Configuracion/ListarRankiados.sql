create PROCEDURE [dbo].[ListarRankiados] 
/*
'**********************************************************************************
'* Procedimiento almacenado de ListarRankiados
'* Input :
'* Output : Lista de canciones de la apertura
'* Creado Por : John Castillo
'* Fecha Creación : 07-09-2016
'**********************************************************************************
*/
AS
BEGIN
			Select top 12
					
				--LocalCancion
				C.IdLocalCancion as LocalCancion_IdLocalCancion,
				count(C.IdLocalCancion) as Cantidad,
				--Cancion 
				CAN.IdCancion as Cancion_IdCancion,
				CAN.Descripcion as Cancion_Descripcion,
				--Artista
				AR.IdArtista as Artista_IdArtista,
				AR.Nombre as Artista_Nombre,
				--Album
				AL.IdAlbum as Album_IdAlbum,
				AL.Titulo as Album_Titulo
						
			From 
            AperturaCancion AC
			inner join LocalCancion C on
			AC.IdLocalCancion = C.IdLocalCancion
			inner join Cancion CAN on
			CAN.IdCancion = C.IdCancion
			inner join Artista AR on
			AR.IdArtista = C.IdArtista
			inner join Album AL on
			AL.IdAlbum = C.IdAlbum
			
            group by C.IdLocalCancion, CAN.IdCancion,CAN.Descripcion, AR.IdArtista,AR.Nombre,AL.IdAlbum,AL.Titulo
			order by Cantidad desc
			
END
