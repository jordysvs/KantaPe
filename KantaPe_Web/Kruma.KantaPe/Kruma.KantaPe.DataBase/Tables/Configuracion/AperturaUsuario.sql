CREATE TABLE [dbo].[AperturaUsuario](
	[IdLocal] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdAperturaUsuario] [int] NOT NULL,
	[IdUsuario] [varchar](20) NULL,
	[Administrador] [char](1) NULL,
	[FechaIngreso] [datetime] NULL,
	[FechaFinal] [datetime] NULL,
	[Latitud] [varchar](50) NULL,
	[Longitud] [varchar](50) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_AperturaUsuario] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdApertura] ASC,
	[IdAperturaUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[AperturaUsuario]  WITH CHECK ADD  CONSTRAINT [FK_AperturaUsuario_Apertura] FOREIGN KEY([IdLocal], [IdApertura])
REFERENCES [dbo].[Apertura] ([IdLocal], [IdApertura])
GO

ALTER TABLE [dbo].[AperturaUsuario] CHECK CONSTRAINT [FK_AperturaUsuario_Apertura]
GO


