CREATE TABLE [dbo].[CoreParametro](
	[IdModulo] [char](8) NOT NULL,
	[IdParametro] [varchar](20) NOT NULL,
	[Descripcion] [varchar](100) NULL,
	[Valor] [varchar](500) NULL,
	[Sistema] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_CoreParametro] PRIMARY KEY CLUSTERED 
(
	[IdModulo] ASC,
	[IdParametro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[CoreParametro]  WITH CHECK ADD  CONSTRAINT [FK_CoreParametro_CoreModulo] FOREIGN KEY([IdModulo])
REFERENCES [dbo].[CoreModulo] ([IdModulo])
GO

ALTER TABLE [dbo].[CoreParametro] CHECK CONSTRAINT [FK_CoreParametro_CoreModulo]
GO


