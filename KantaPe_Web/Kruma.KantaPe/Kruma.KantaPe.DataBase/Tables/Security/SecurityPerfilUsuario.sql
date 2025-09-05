CREATE TABLE [dbo].[SecurityPerfilUsuario](
	[IdModulo] [char](8) NOT NULL,
	[IdPerfil] [varchar](20) NOT NULL,
	[IdUsuario] [varchar](20) NOT NULL,
	[FlagExpiracion] [char](1) NULL,
	[FechaExpiracion] [datetime] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityPerfilUsuario] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdPerfil] ASC,
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityPerfilUsuario]  WITH CHECK ADD  CONSTRAINT [PK_SecurityPerfilUsuario_SecurityPerfil] FOREIGN KEY([IdModulo], [IdPerfil])
REFERENCES [dbo].[SecurityPerfil] ([IdModulo], [IdPerfil])
GO

ALTER TABLE [dbo].[SecurityPerfilUsuario] CHECK CONSTRAINT [PK_SecurityPerfilUsuario_SecurityPerfil]
GO

ALTER TABLE [dbo].[SecurityPerfilUsuario]  WITH CHECK ADD  CONSTRAINT [PK_SecurityPerfilUsuario_SecurityUsuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[SecurityUsuario] ([IdUsuario])
GO

ALTER TABLE [dbo].[SecurityPerfilUsuario] CHECK CONSTRAINT [PK_SecurityPerfilUsuario_SecurityUsuario]
GO


