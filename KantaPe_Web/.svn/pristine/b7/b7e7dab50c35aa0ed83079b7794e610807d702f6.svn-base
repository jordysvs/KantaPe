CREATE TABLE [dbo].[SecurityPerfilGrupoDetalleProcesoAcceso](
	[IdModulo] [char](8) NOT NULL,
	[IdPerfil] [varchar](20) NOT NULL,
	[IdModuloGrupo] [char](8) NOT NULL,
	[IdGrupo] [char](8) NOT NULL,
	[IdDetalle] [char](8) NOT NULL,
	[IdProceso] [int] NOT NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityPerfilGrupoDetalleProcesoAcceso] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdPerfil] ASC,
	[IdModuloGrupo] ASC,
	[IdGrupo] ASC,
	[IdDetalle] ASC,
	[IdProceso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleProcesoAcceso]  WITH CHECK ADD  CONSTRAINT [PK_SecurityPerfilGrupoDetalleProcesoAcceso_SecurityGrupoDetalleAcceso] FOREIGN KEY([IdModuloGrupo], [IdGrupo], [IdDetalle], [IdProceso])
REFERENCES [dbo].[SecurityGrupoDetalleProceso] ([IdModulo], [IdGrupo], [IdDetalle], [IdProceso])
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleProcesoAcceso] CHECK CONSTRAINT [PK_SecurityPerfilGrupoDetalleProcesoAcceso_SecurityGrupoDetalleAcceso]
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleProcesoAcceso]  WITH CHECK ADD  CONSTRAINT [PK_SecurityPerfilGrupoDetalleProcesoAcceso_SecurityPerfil] FOREIGN KEY([IdModulo], [IdPerfil])
REFERENCES [dbo].[SecurityPerfil] ([IdModulo], [IdPerfil])
GO

ALTER TABLE [dbo].[SecurityPerfilGrupoDetalleProcesoAcceso] CHECK CONSTRAINT [PK_SecurityPerfilGrupoDetalleProcesoAcceso_SecurityPerfil]
GO


