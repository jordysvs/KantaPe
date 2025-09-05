CREATE TABLE [dbo].[Pedido](
	[IdLocal] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdPedido] [int] NOT NULL,
	[IdUsuario] [varchar](20) NULL,
	[NroPedido] [varchar](20) NULL,
	[FechaPedido] [datetime] NULL,
	[Costo] [decimal](18, 6) NULL,
	[Precio] [decimal](18, 6) NULL,
	[Igv] [decimal](18, 6) NULL,
	[Total] [decimal](18, 6) NULL,
	[IdPedidoEstado] [int] NULL,
	[IdAlerta] [int] NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Pedido] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdApertura] ASC,
	[IdPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Pedido]  WITH CHECK ADD  CONSTRAINT [FK_Pedido_PedidoEstado] FOREIGN KEY([IdPedidoEstado])
REFERENCES [dbo].[PedidoEstado] ([IdPedidoEstado])
GO

ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [FK_Pedido_PedidoEstado]
GO

ALTER TABLE [dbo].[Pedido]  WITH CHECK ADD  CONSTRAINT [FK_Pedido_SecurityUsuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[SecurityUsuario] ([IdUsuario])
GO

ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [FK_Pedido_SecurityUsuario]
GO


