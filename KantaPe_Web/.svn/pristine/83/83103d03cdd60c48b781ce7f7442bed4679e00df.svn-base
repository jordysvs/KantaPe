create PROCEDURE [dbo].[ListarExtension]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de géneros
'*	Input			: 	@pIdExtension - Id del género,
						@pDescripcion - Descripcion del género,
						@pEstado - Estado del auto,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: Carlos Gómez
'*	Fec Creación	: 01/07/2016
'**********************************************************************************
*/
As
Begin
		Select
			G.IdExtension,
			G.Descripcion,
			G.Estado,
			G.UsuarioCreacion,
			G.FechaCreacion,
			G.UsuarioModificacion,
			G.FechaModificacion,
			COUNT(*) OVER() Total_Filas
			From Extension G
			Where 
		    G.Estado = 'A'
End
