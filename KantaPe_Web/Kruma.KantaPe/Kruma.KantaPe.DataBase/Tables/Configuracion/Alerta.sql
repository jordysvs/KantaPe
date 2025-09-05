CREATE TABLE [dbo].[Alerta](
	[IdLocal] [int] NOT NULL,
	[IdUbicacion] [int] NOT NULL,
	[IdAlerta] [int] NOT NULL,
	[IdAlertaTipo] [int] NULL,
	[FechaAlerta] [datetime] NULL,
	[FechaAtencion] [datetime] NULL,
	[IdUsuario] [varchar](20) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Alerta] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdUbicacion] ASC,
	[IdAlerta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Alerta]  WITH CHECK ADD  CONSTRAINT [FK_Alerta_AlertaTipo] FOREIGN KEY([IdAlertaTipo])
REFERENCES [dbo].[AlertaTipo] ([IdAlertaTipo])
GO

ALTER TABLE [dbo].[Alerta] CHECK CONSTRAINT [FK_Alerta_AlertaTipo]
GO

ALTER TABLE [dbo].[Alerta]  WITH CHECK ADD  CONSTRAINT [FK_Alerta_Local] FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Local] ([IdLocal])
GO

ALTER TABLE [dbo].[Alerta] CHECK CONSTRAINT [FK_Alerta_Local]
GO

ALTER TABLE [dbo].[Alerta]  WITH CHECK ADD  CONSTRAINT [FK_Alerta_SecurityUsuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[SecurityUsuario] ([IdUsuario])
GO

ALTER TABLE [dbo].[Alerta] CHECK CONSTRAINT [FK_Alerta_SecurityUsuario]
GO


