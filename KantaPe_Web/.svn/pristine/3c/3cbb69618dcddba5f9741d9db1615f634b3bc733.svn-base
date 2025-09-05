CREATE TABLE [dbo].[SecurityUsuario](
	[IdUsuario] [varchar](20) NOT NULL,
	[Clave] [varchar](50) NULL,
	[UsuarioRed] [varchar](20) NULL,
	[IdPersona] [int] NULL,
	[FlagExpiracion] [char](1) NULL,
	[FechaExpiracion] [datetime] NULL,
	[FechaCambioClave] [datetime] NULL,
	[FechaOlvidoClave] [datetime] NULL,
	[FechaUltimoLogin] [datetime] NULL,
	[FechaLogin] [datetime] NULL,
	[Sistema] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityUsuario_1] PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[SecurityUsuario]  WITH NOCHECK ADD  CONSTRAINT [FK_SecurityUsuario_CorePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[SecurityUsuario] CHECK CONSTRAINT [FK_SecurityUsuario_CorePersona]
GO