CREATE TABLE [dbo].[SecurityGrupoDetalleProceso](
	[IdModulo] [char](8) NOT NULL,
	[IdGrupo] [char](8) NOT NULL,
	[IdDetalle] [char](8) NOT NULL,
	[IdProceso] [int] NOT NULL,
	[Descripcion] [varchar](50) NULL,
	[NombreControl] [varchar](50) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityGrupoDetalleProceso] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdGrupo] ASC,
	[IdDetalle] ASC,
	[IdProceso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityGrupoDetalleProceso]  WITH CHECK ADD  CONSTRAINT [FK_SecurityGrupoDetalleProceso_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[SecurityGrupoDetalleProceso] CHECK CONSTRAINT [FK_SecurityGrupoDetalleProceso_CoreModulo]
GO

ALTER TABLE [dbo].[SecurityGrupoDetalleProceso]  WITH CHECK ADD  CONSTRAINT [FK_SecurityGrupoDetalleProceso_SecurityGrupoDetalle] FOREIGN KEY([IdModulo], [IdGrupo], [IdDetalle])
REFERENCES [dbo].[SecurityGrupoDetalle] ([IdModulo], [IdGrupo], [IdDetalle])
GO

ALTER TABLE [dbo].[SecurityGrupoDetalleProceso] CHECK CONSTRAINT [FK_SecurityGrupoDetalleProceso_SecurityGrupoDetalle]
GO


