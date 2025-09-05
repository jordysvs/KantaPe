create PROCEDURE [dbo].[FileServerEliminarDocumento] 
/*    
'**********************************************************************************
'* Procedimiento almacenado encargado de eliminar un documento
'* Input        : @pIdDocumento - Id del documento
				  @pIdAlmacen - Id del almacen
				  @pIdRegistro - Id del registro relacionado
				  @pUsuarioModificacion - Código del usuario
'* Creado Por   : John Castillo
'* Fec Creación : 13/03/2015
'**********************************************************************************
*/
(
	@pIdDocumento			int out,
	@pIdAlmacen				int,
	@pIdRegistro			int,
	@pUsuarioModificacion	varchar(20)
)  
As  
Begin  
  
	Set NoCount On
  
	Update [FileServerDocumento]
	Set Estado = 'I',
	UsuarioModificacion = @pUsuarioModificacion,
	FechaModificacion = getdate()
	Where
	IdDocumento = @pIdDocumento AND
	IdAlmacen  = @pIdAlmacen AND
	IdRegistro = @pIdRegistro
		
	Set NoCount Off
  
End
