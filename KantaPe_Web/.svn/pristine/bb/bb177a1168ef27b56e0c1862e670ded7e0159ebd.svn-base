CREATE TABLE [dbo].[ProductoInsumo](
	[IdLocal] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
	[IdInsumo] [int] NOT NULL,
	[Cantidad] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_ProductoInsumo] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdProducto] ASC,
	[IdInsumo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[ProductoInsumo]  WITH CHECK ADD  CONSTRAINT [FK_ProductoInsumo_Insumo] FOREIGN KEY([IdInsumo])
REFERENCES [dbo].[Insumo] ([IdInsumo])
GO

ALTER TABLE [dbo].[ProductoInsumo] CHECK CONSTRAINT [FK_ProductoInsumo_Insumo]
GO

ALTER TABLE [dbo].[ProductoInsumo]  WITH CHECK ADD  CONSTRAINT [FK_ProductoInsumo_Producto] FOREIGN KEY([IdLocal], [IdProducto])
REFERENCES [dbo].[Producto] ([IdLocal], [IdProducto])
GO

ALTER TABLE [dbo].[ProductoInsumo] CHECK CONSTRAINT [FK_ProductoInsumo_Producto]
GO


