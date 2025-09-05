CREATE TABLE [dbo].[SecurityPerfil](
	[IdModulo] [char](8) NOT NULL,
	[IdPerfil] [varchar](20) NOT NULL,
	[Descripcion] [varchar](50) NULL,
	[Sistema] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_SecurityPerfil] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdPerfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SecurityPerfil]  WITH CHECK ADD  CONSTRAINT [FK_SecurityPerfil_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[SecurityPerfil] CHECK CONSTRAINT [FK_SecurityPerfil_CoreModulo]
GO


