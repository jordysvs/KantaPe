create Procedure [dbo].[InsertarProducto]
/*
'**********************************************************************************
'*	Procedimiento almacenado de inserción del producto
'*	Input			:	@pIdLocal - Id del local,
						@pNombre - Nombre del producto,
						@pIdProductoTipo - Id del tipo de producto,
						@pCosto - costo del producto,
						@pPrecio - precio del producto,
						@pUsuarioCreacion - Usuario creación
'*	Output			:	@pIdProducto - Id del producto,
'*	Creado Por		: John Castillo
'*	Fec Creación	: 18/08/2016
'**********************************************************************************
*/
(
@pIdLocal					int = null,
@pNombre					varchar(100) = null,
@pIdProductoTipo			int = null,
@pCosto						decimal(18,6) = null,
@pPrecio					decimal(18,6) = null,
@pIdImagen					int = null,
@pEstado					char(1) = null,
@pUsuarioCreacion			varchar(20) = null,
@pIdProducto				int out
)
AS

select @pIdProducto = ISNULL(MAX(IdProducto),0)+1 
from Producto Where IdLocal = @pIdLocal AND IdProducto > 0

Insert into Producto(
IdLocal,
IdProducto,
Nombre,
IdProductoTipo,
Costo,
Precio,
IdImagen,
Estado,
UsuarioCreacion,
FechaCreacion,
UsuarioModificacion,
FechaModificacion
)
Values
(
@pIdLocal,
@pIdProducto,
@pNombre,
@pIdProductoTipo,
@pCosto,
@pPrecio,
@pIdImagen,
@pEstado,
@pUsuarioCreacion,
GETDATE(),
@pUsuarioCreacion,
GETDATE()
)
