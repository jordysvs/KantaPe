CREATE TABLE [dbo].[FileServerAlmacen](
	[IdAlmacen] [int] NOT NULL,
	[IdModulo] [char](8) NULL,
	[Descripcion] [varchar](50) NULL,
	[Ruta] [varchar](200) NULL,
	[TipoAlmacen] [int] NULL,
	[Usuario] [varchar](50) NULL,
	[Clave] [varchar](50) NULL,
	[Dominio] [varchar](50) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_FileServerAlmacen] PRIMARY KEY CLUSTERED 
(
	[IdAlmacen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[FileServerAlmacen]  WITH CHECK ADD  CONSTRAINT [FK_FileServerAlmacen_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[FileServerAlmacen] CHECK CONSTRAINT [FK_FileServerAlmacen_CoreModulo]
GO


