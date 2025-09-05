create PROCEDURE [dbo].[FileServerInsertarAlmacen]
/*
'**********************************************************************************
'* Procedimiento almacenado de inserción del almacen de documentos
'* Input :
		@pDescripcion - Descripcion del almacen de documentos
		@pRuta - Ruta del almacen de documentos
		@pEstado - Estado del almacen de documentos
		@pUsuarioCreacion - UsuarioCreacion del almacen de documentos
'* Output : 
		@pIdAlmacen - IdAlmacen del almacen de documentos
'* Creado Por : John Castillo
'* Fecha Creación : 23-07-2015
'**********************************************************************************
*/
(
	@pIdModulo char(8) = null,
	@pDescripcion varchar(50) = null, 
	@pRuta varchar(200) = null, 
	@pTipoAlmacen int = null,
	@pUsuario varchar(50) = null,
	@pClave varchar(50) = null,
	@pDominio varchar(50) = null,
	@pEstado char(1) = null, 
	@pUsuarioCreacion varchar(20) = null, 
	@pIdAlmacen int out
)
AS
BEGIN
		Select @pIdAlmacen = IsNull(Max(IdAlmacen),0)+1 From FileServerAlmacen Where IdAlmacen > 0

		Insert Into FileServerAlmacen
		(
			IdModulo,
			IdAlmacen,
			Descripcion,
			Ruta,
			TipoAlmacen,
			Usuario,
			Clave,
			Dominio,
			Estado,
			UsuarioCreacion,
			FechaCreacion,
			UsuarioModificacion,
			FechaModificacion
		)
		Values
		(
			@pIdModulo,
			@pIdAlmacen,
			@pDescripcion,
			@pRuta,
			@pTipoAlmacen,
			@pUsuario,
			@pClave,
			@pDominio,
			@pEstado,
			@pUsuarioCreacion,
			getdate(),
			@pUsuarioCreacion,
			getdate()
		)
END
