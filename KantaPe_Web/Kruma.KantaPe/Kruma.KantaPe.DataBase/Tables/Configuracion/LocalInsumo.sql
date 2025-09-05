CREATE TABLE [dbo].[LocalInsumo](
	[IdLocal] [int] NOT NULL,
	[IdInsumo] [int] NOT NULL,
	[Cantidad] [int] NULL,
	[Minimo] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_LocalInsumo] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdInsumo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[LocalInsumo]  WITH CHECK ADD  CONSTRAINT [FK_LocalInsumo_Insumo] FOREIGN KEY([IdInsumo])
REFERENCES [dbo].[Insumo] ([IdInsumo])
GO

ALTER TABLE [dbo].[LocalInsumo] CHECK CONSTRAINT [FK_LocalInsumo_Insumo]
GO

ALTER TABLE [dbo].[LocalInsumo]  WITH CHECK ADD  CONSTRAINT [FK_LocalInsumo_Local] FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Local] ([IdLocal])
GO

ALTER TABLE [dbo].[LocalInsumo] CHECK CONSTRAINT [FK_LocalInsumo_Local]
GO