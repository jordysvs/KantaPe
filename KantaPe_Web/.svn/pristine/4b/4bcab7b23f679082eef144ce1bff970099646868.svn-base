create PROCEDURE [dbo].[FileServerActualizarAlmacen]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación del almacen de documentos
'* Input :
		@pIdAlmacen - IdAlmacen del almacen de documentos
		@pDescripcion - Descripcion del almacen de documentos
		@pRuta - Ruta del almacen de documentos
		@pEstado - Estado del almacen de documentos
		@pUsuarioModificacion - UsuarioModificacion del almacen de documentos
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 23-07-2015
'**********************************************************************************
*/
(
	@pIdAlmacen int = null, 
	@pIdModulo char(8) = null,
	@pDescripcion varchar(50) = null, 
	@pRuta varchar(200) = null, 
	@pTipoAlmacen int = null,
	@pUsuario varchar(50) = null,
	@pClave varchar(50) = null,
	@pDominio varchar(50) = null,
	@pEstado char(1) = null, 
	@pUsuarioModificacion varchar(20) = null
)
AS
BEGIN
		Update FileServerAlmacen
		Set 
		IdModulo = @pIdModulo,
		Descripcion = @pDescripcion,
		Ruta = @pRuta,
		TipoAlmacen = @pTipoAlmacen,
		Usuario = @pUsuario,
		Clave = @pClave,
		Dominio = @pDominio,
		Estado = @pEstado,
		UsuarioModificacion = @pUsuarioModificacion,
		FechaModificacion = getdate()
		Where
			IdAlmacen= @pIdAlmacen
END
