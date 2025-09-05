create PROCEDURE [dbo].[ActualizarProducto]
/*
'**********************************************************************************
'* Procedimiento almacenado de modificación del producto
'* Input :
		@pIdLocal - Id del local de la ubicación,
		@pIdProducto - Id del producto,
		@pNombre - Nombre del producto,
		@pIdProductoTipo - Id del tipo de producto,
		@pCosto	- Costo del producto,
		@pPrecio - Precio del producto,
		@pEstado - Estado del producto
		@pUsuarioModificacion - UsuarioModificacion de la ubicación
'* Output : Ninguno
'* Creado Por : John Castillo
'* Fecha Creación : 12-07-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdProducto int = null, 
	@pNombre varchar(50) = null,
	@pIdProductoTipo int = null,
	@pCosto decimal(18,6) = null,
	@pPrecio decimal(18,6) = null,
	@pIdImagen int = null,
	@pEstado varchar(1) = null, 
	@pUsuarioModificacion varchar(20) = null 
)
AS
BEGIN
		Update Producto
		Set 
			Nombre = @pNombre,
			IdProductoTipo = @pIdProductoTipo,
			Costo = @pCosto,
			Precio = @pPrecio,
			IdImagen = @pIdImagen,
			Estado = @pEstado,
			UsuarioModificacion = @pUsuarioModificacion,
			FechaModificacion = getdate()
		Where
			IdLocal = @pIdLocal AND
			IdProducto = @pIdProducto
END
