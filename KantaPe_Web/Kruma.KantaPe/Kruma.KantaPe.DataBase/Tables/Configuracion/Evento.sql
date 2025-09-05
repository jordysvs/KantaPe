
CREATE TABLE [dbo].[Evento](
	[IdLocal] [int] NOT NULL,
	[IdEvento] [int] NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Descripcion] [varchar](500) NULL,
	[FechaEvento] [datetime] NULL,
	[IdImagen] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Evento_1] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdEvento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Evento]  WITH CHECK ADD  CONSTRAINT [FK_Evento_Local] FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Local] ([IdLocal])
GO

ALTER TABLE [dbo].[Evento] CHECK CONSTRAINT [FK_Evento_Local]
GO


