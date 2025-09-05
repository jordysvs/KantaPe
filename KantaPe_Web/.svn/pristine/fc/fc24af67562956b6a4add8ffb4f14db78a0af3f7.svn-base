CREATE TABLE [dbo].[SecurityGrupoDetalle](
	[IdModulo] [char](8) NOT NULL,
	[IdGrupo] [char](8) NOT NULL,
	[IdDetalle] [char](8) NOT NULL,
	[Descripcion] [varchar](50) NULL,
	[IdDetallePadre] [char](8) NULL,
	[Orden] [int] NULL,
	[URL] [varchar](500) NULL,
	[FlagVisible] [char](1) NULL,
	[IdImagen] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityGrupoDetalle] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdGrupo] ASC,
	[IdDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityGrupoDetalle]  WITH NOCHECK ADD  CONSTRAINT [FK_SecurityGrupoDetalle_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[SecurityGrupoDetalle] CHECK CONSTRAINT [FK_SecurityGrupoDetalle_CoreModulo]
GO

ALTER TABLE [dbo].[SecurityGrupoDetalle]  WITH NOCHECK ADD  CONSTRAINT [FK_SecurityGrupoDetalle_SecurityGrupo] FOREIGN KEY([IdModulo], [IdGrupo])
REFERENCES [dbo].[SecurityGrupo] ([IdModulo], [IdGrupo])
GO

ALTER TABLE [dbo].[SecurityGrupoDetalle] CHECK CONSTRAINT [FK_SecurityGrupoDetalle_SecurityGrupo]
GO


