CREATE TABLE [dbo].[LocalCancion](
	[IdLocalCancion] [int] NOT NULL,
	[IdEmpresa] [int] NULL,
	[IdLocal] [int] NULL,
	[IdCancion] [int] NULL,
	[IdArtista] [int] NULL,
	[IdAlbum] [int] NULL,
	[IdGenero] [int] NULL,
	[IdIdioma] [int] NULL,
	[Decada] [varchar](10) NULL,
	[Version] [varchar](100) NULL,
	[NombreArchivo] [varchar](255) NULL,
	[FechaRegistro] [datetime] NULL,
	[Anio] [int] NULL,
	[Letra] [varchar](max) NULL,
	[Duracion] [int] NULL,
	[Youtube] [varchar](255) NULL,
	[IdCancionSolicitud] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Cancion] PRIMARY KEY CLUSTERED 
(
	[IdLocalCancion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO


ALTER TABLE [dbo].[LocalCancion]  WITH CHECK ADD  CONSTRAINT [FK_Cancion_Album] FOREIGN KEY([IdAlbum])
REFERENCES [dbo].[Album] ([IdAlbum])
GO

ALTER TABLE [dbo].[LocalCancion] CHECK CONSTRAINT [FK_Cancion_Album]
GO

ALTER TABLE [dbo].[LocalCancion]  WITH CHECK ADD  CONSTRAINT [FK_Cancion_Artista] FOREIGN KEY([IdArtista])
REFERENCES [dbo].[Artista] ([IdArtista])
GO

ALTER TABLE [dbo].[LocalCancion] CHECK CONSTRAINT [FK_Cancion_Artista]
GO

ALTER TABLE [dbo].[LocalCancion]  WITH CHECK ADD  CONSTRAINT [FK_Cancion_CancionEstado] FOREIGN KEY([IdCancionSolicitud])
REFERENCES [dbo].[CancionSolicitud] ([IdCancionSolicitud])
GO

ALTER TABLE [dbo].[LocalCancion] CHECK CONSTRAINT [FK_Cancion_CancionEstado]
GO

ALTER TABLE [dbo].[LocalCancion]  WITH CHECK ADD  CONSTRAINT [FK_Cancion_Genero] FOREIGN KEY([IdGenero])
REFERENCES [dbo].[Genero] ([IdGenero])
GO

ALTER TABLE [dbo].[LocalCancion] CHECK CONSTRAINT [FK_Cancion_Genero]
GO

ALTER TABLE [dbo].[LocalCancion]  WITH CHECK ADD  CONSTRAINT [FK_Cancion_Idioma] FOREIGN KEY([IdIdioma])
REFERENCES [dbo].[Idioma] ([IdIdioma])
GO

ALTER TABLE [dbo].[LocalCancion] CHECK CONSTRAINT [FK_Cancion_Idioma]
GO


