CREATE TABLE [dbo].[SecurityPerfilGrupoDetalleAcceso](
	[IdModulo] [char](8) NOT NULL,
	[IdPerfil] [varchar](20) NOT NULL,
	[IdModuloGrupo] [char](8) NOT NULL,
	[IdGrupo] [char](8) NOT NULL,
	[IdDetalle] [char](8) NOT NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityPerfilGrupoDetalleAcceso] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdPerfil] ASC,
	[IdModuloGrupo] ASC,
	[IdGrupo] ASC,
	[IdDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleAcceso]  WITH NOCHECK ADD  CONSTRAINT [PK_SecurityPerfilGrupoDetalleAcceso_SecurityGrupoDetalle] FOREIGN KEY([IdModuloGrupo], [IdGrupo], [IdDetalle])
REFERENCES [dbo].[SecurityGrupoDetalle] ([IdModulo], [IdGrupo], [IdDetalle])
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleAcceso] CHECK CONSTRAINT [PK_SecurityPerfilGrupoDetalleAcceso_SecurityGrupoDetalle]
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleAcceso]  WITH NOCHECK ADD  CONSTRAINT [PK_SecurityPerfilGrupoDetalleAcceso_SecurityPerfil] FOREIGN KEY([IdModulo], [IdPerfil])
REFERENCES [dbo].[SecurityPerfil] ([IdModulo], [IdPerfil])
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleAcceso] CHECK CONSTRAINT [PK_SecurityPerfilGrupoDetalleAcceso_SecurityPerfil]
GO


