create PROCEDURE [dbo].[FileServerRegistrarDocumento] 
/*    
'**********************************************************************************
'* Procedimiento almacenado encargado de registrar un documento
'* Input        : @pIdAlmacen - Id del almacen
				  @pIdRegistro - Id del registro relacionado
'*				  @pDescripcionFisica - Descripción Física  
'*				  @pDescripcionLogica - Descripción Lógica  
'*				  @pExtension - Extensión del Documento  
				  @pUsuarioCreacion - Usuario de creacion
'* Output       : @pIdDocumento - Id del documento  
'* Creado Por   : John Castillo
'* Fec Creación : 20/11/2014
'**********************************************************************************
*/
(
	@pIdDocumento			int out,
	@pIdAlmacen				int,
	@pIdRegistro			int,
	@pDescripcionFisica		varchar(200),
	@pDescripcionLogica		varchar(200),
	@pExtension				varchar(5),
	@pUsuarioCreacion		varchar(20)
)  
As  
Begin  
  
	Select @pIdDocumento = isnull(MAX(IdDocumento),0) +1 
	from [FileServerDocumento] 
	where IdAlmacen = @pIdAlmacen AND IdRegistro = @pIdRegistro

	Insert into [FileServerDocumento](
		IdAlmacen,
		IdRegistro,
		IdDocumento,
		DescripcionFisica,
		DescripcionLogica,
		Extension,
		Estado,
		UsuarioCreacion,
		FechaCreacion,
		UsuarioModificacion,
		FechaModificacion
		)
	values
		(
		@pIdAlmacen,
		@pIdRegistro,
		@pIdDocumento,
		@pDescripcionFisica,
		@pDescripcionLogica,
		@pExtension,
		'A',
		@pUsuarioCreacion,
		getdate(),
		@pUsuarioCreacion,
		getdate()
		)
End
