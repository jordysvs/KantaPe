CREATE TABLE [dbo].[Producto](
	[IdLocal] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
	[Nombre] [varchar](100) NULL,
	[IdProductoTipo] [int] NULL,
	[Costo] [decimal](18, 6) NULL,
	[Precio] [decimal](18, 6) NULL,
	[IdImagen] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_Local] FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Local] ([IdLocal])
GO

ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_Local]
GO


