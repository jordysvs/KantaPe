CREATE TABLE [dbo].[Solicitud](
	[IdSolicitud] [int] NOT NULL,
	[IdCancion] [int] NOT NULL,
	[FechaSolicitud] [datetime] NULL,
	[IdUsuario] [varchar](20) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Solicitud] PRIMARY KEY CLUSTERED 
(
	[IdSolicitud] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Solicitud]  WITH CHECK ADD  CONSTRAINT [FK_Solicitud_Cancion] FOREIGN KEY([IdCancion])
REFERENCES [dbo].[LocalCancion] ([IdLocalCancion])
GO

ALTER TABLE [dbo].[Solicitud] CHECK CONSTRAINT [FK_Solicitud_Cancion]
GO

ALTER TABLE [dbo].[Solicitud]  WITH CHECK ADD  CONSTRAINT [FK_Solicitud_SecurityUsuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[SecurityUsuario] ([IdUsuario])
GO

ALTER TABLE [dbo].[Solicitud] CHECK CONSTRAINT [FK_Solicitud_SecurityUsuario]
GO


