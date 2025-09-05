CREATE TABLE [dbo].[AperturaCancion](
	[IdLocal] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdAperturaCancion] [int] NOT NULL,
	[IdUsuario] [varchar](20) NOT NULL,
	[IdLocalCancion] [int] NULL,
	[IdAperturaCancionTipo] [int] NULL,
	[IdAperturaCancionSolicitud] [int] NULL,
	[Orden] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_AperturaCancion] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdApertura] ASC,
	[IdAperturaCancion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[AperturaCancion]  WITH CHECK ADD  CONSTRAINT [FK_AperturaCancion_Apertura] FOREIGN KEY([IdLocal], [IdApertura])
REFERENCES [dbo].[Apertura] ([IdLocal], [IdApertura])
GO

ALTER TABLE [dbo].[AperturaCancion] CHECK CONSTRAINT [FK_AperturaCancion_Apertura]
GO

ALTER TABLE [dbo].[AperturaCancion]  WITH CHECK ADD  CONSTRAINT [FK_AperturaCancion_AperturaCancionTipo] FOREIGN KEY([IdAperturaCancionTipo])
REFERENCES [dbo].[AperturaCancionTipo] ([IdAperturaCancionTipo])
GO

ALTER TABLE [dbo].[AperturaCancion] CHECK CONSTRAINT [FK_AperturaCancion_AperturaCancionTipo]
GO

ALTER TABLE [dbo].[AperturaCancion]  WITH CHECK ADD  CONSTRAINT [FK_AperturaCancion_Cancion] FOREIGN KEY([IdLocalCancion])
REFERENCES [dbo].[LocalCancion] ([IdLocalCancion])
GO

ALTER TABLE [dbo].[AperturaCancion] CHECK CONSTRAINT [FK_AperturaCancion_Cancion]
GO


