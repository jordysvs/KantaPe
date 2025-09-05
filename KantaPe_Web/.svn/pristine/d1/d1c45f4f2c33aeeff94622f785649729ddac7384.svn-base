CREATE TABLE [dbo].[AperturaUbicacion](
	[IdLocal] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdUbicacion] [int] NOT NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_AperturaUbicacion] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdApertura] ASC,
	[IdUbicacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[AperturaUbicacion]  WITH CHECK ADD  CONSTRAINT [FK_AperturaUbicacion_Apertura] FOREIGN KEY([IdLocal], [IdApertura])
REFERENCES [dbo].[Apertura] ([IdLocal], [IdApertura])
GO

ALTER TABLE [dbo].[AperturaUbicacion] CHECK CONSTRAINT [FK_AperturaUbicacion_Apertura]
GO

ALTER TABLE [dbo].[AperturaUbicacion]  WITH CHECK ADD  CONSTRAINT [FK_AperturaUbicacion_Ubicacion] FOREIGN KEY([IdLocal], [IdUbicacion])
REFERENCES [dbo].[Ubicacion] ([IdLocal], [IdUbicacion])
GO

ALTER TABLE [dbo].[AperturaUbicacion] CHECK CONSTRAINT [FK_AperturaUbicacion_Ubicacion]
GO


