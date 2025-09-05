CREATE TABLE [dbo].[PedidoDetalle](
	[IdLocal] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdPedidoDetalle] [int] NOT NULL,
	[IdPedido] [int] NOT NULL,
	[IdProducto] [int] NULL,
	[Cantidad] [int] NULL,
	[Precio] [decimal](18, 6) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_PedidoDetalle] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdApertura] ASC,
	[IdPedidoDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[PedidoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_PedidoDetalle_Pedido] FOREIGN KEY([IdLocal], [IdApertura], [IdPedido])
REFERENCES [dbo].[Pedido] ([IdLocal], [IdApertura], [IdPedido])
GO

ALTER TABLE [dbo].[PedidoDetalle] CHECK CONSTRAINT [FK_PedidoDetalle_Pedido]
GO

ALTER TABLE [dbo].[PedidoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_PedidoDetalle_Producto] FOREIGN KEY([IdLocal], [IdProducto])
REFERENCES [dbo].[Producto] ([IdLocal], [IdProducto])
GO

ALTER TABLE [dbo].[PedidoDetalle] CHECK CONSTRAINT [FK_PedidoDetalle_Producto]
GO


