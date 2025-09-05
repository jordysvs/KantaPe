CREATE TABLE [dbo].[Ubicacion](
	[IdLocal] [int] NOT NULL,
	[IdUbicacion] [int] NOT NULL,
	[IdUbicacionTipo] [int] NULL,
	[Numero] [int] NULL,
	[Capacidad] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Ubicacion] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdUbicacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Ubicacion]  WITH CHECK ADD  CONSTRAINT [FK_Ubicacion_Local] FOREIGN KEY([IdLocal])
REFERENCES [dbo].[Local] ([IdLocal])
GO

ALTER TABLE [dbo].[Ubicacion] CHECK CONSTRAINT [FK_Ubicacion_Local]
GO


