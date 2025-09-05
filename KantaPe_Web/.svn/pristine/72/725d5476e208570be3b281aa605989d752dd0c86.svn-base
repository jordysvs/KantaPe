CREATE TABLE [dbo].[Horario](
	[IdLocal] [int] NOT NULL,
	[IdUbicacion] [int] NOT NULL,
	[IdHorario] [int] NOT NULL,
	[IdMozo] [int] NULL,
	[Dia] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Horario] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdUbicacion] ASC,
	[IdHorario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Horario]  WITH CHECK ADD  CONSTRAINT [FK_Horario_Ubicacion] FOREIGN KEY([IdLocal], [IdUbicacion])
REFERENCES [dbo].[Ubicacion] ([IdLocal], [IdUbicacion])
GO

ALTER TABLE [dbo].[Horario] CHECK CONSTRAINT [FK_Horario_Ubicacion]
GO


