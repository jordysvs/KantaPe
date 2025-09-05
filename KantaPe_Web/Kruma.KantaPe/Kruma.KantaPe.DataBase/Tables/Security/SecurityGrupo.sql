CREATE TABLE [dbo].[SecurityGrupo](
	[IdModulo] [char](8) NOT NULL,
	[IdGrupo] [char](8) NOT NULL,
	[Descripcion] [varchar](50) NULL,
	[Orden] [int] NULL,
	[IdImagen] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityGrupo] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdGrupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityGrupo]  WITH CHECK ADD  CONSTRAINT [FK_SecurityGrupo_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[SecurityGrupo] CHECK CONSTRAINT [FK_SecurityGrupo_CoreModulo]
GO


