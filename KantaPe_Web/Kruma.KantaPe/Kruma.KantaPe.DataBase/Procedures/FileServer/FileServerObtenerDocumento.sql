create PROCEDURE [dbo].[FileServerObtenerDocumento] 
/*
'**********************************************************************************
'* Procedimiento almacenado encargado de obtener el documento
'* Input        : @pIdAlmacen - Id del almacen
				  @pIdRegistro - Id del registro relacionado
'*				  @pIdDocumento - Id del documento
'* Output       : <Ninguno>
'* Creado Por   : John Castillo.
'* Fec CreaciÃ³n : 20/11/2014  
'**********************************************************************************    
*/  
(  
	@pIdAlmacen		int,
	@pIdRegistro	int,
	@pIdDocumento	int
)  
As  
Begin  

	Set NoCount On  
	
	Select
		D.IdAlmacen,
		D.IdRegistro,
		D.IdDocumento,
		D.DescripcionFisica,
		D.DescripcionLogica,
		D.Extension,
		D.Estado,
		D.UsuarioCreacion,
		D.FechaCreacion,
		D.UsuarioModificacion,
		D.FechaModificacion,
		A.Ruta
	From [FileServerDocumento] D
	Inner Join [FileServerAlmacen] A ON
	A.IdAlmacen = D.IdAlmacen AND
	A.Estado = 'A'
	Where
	D.Estado = 'A' AND
	D.IdAlmacen = @pIdAlmacen AND
	(@pIdRegistro is null or D.IdRegistro = @pIdRegistro) AND
	(@pIdDocumento is null or D.IdDocumento = @pIdDocumento)

	Set NoCount Off
	  
End
