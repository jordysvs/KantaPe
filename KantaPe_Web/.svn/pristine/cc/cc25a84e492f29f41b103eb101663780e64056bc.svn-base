CREATE TABLE [dbo].[TurnoDetalle](
	[IdLocal] [int] NOT NULL,
	[IdTurno] [int] NOT NULL,
	[IdApertura] [int] NOT NULL,
	[IdAperturaCancion] [int] NOT NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_TurnoDetalle] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC,
	[IdTurno] ASC,
	[IdApertura] ASC,
	[IdAperturaCancion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[TurnoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_TurnoDetalle_AperturaCancion] FOREIGN KEY([IdLocal], [IdApertura], [IdAperturaCancion])
REFERENCES [dbo].[AperturaCancion] ([IdLocal], [IdApertura], [IdAperturaCancion])
GO

ALTER TABLE [dbo].[TurnoDetalle] CHECK CONSTRAINT [FK_TurnoDetalle_AperturaCancion]
GO

ALTER TABLE [dbo].[TurnoDetalle]  WITH CHECK ADD  CONSTRAINT [FK_TurnoDetalle_Turno] FOREIGN KEY([IdLocal], [IdTurno])
REFERENCES [dbo].[Turno] ([IdLocal], [IdTurno])
GO

ALTER TABLE [dbo].[TurnoDetalle] CHECK CONSTRAINT [FK_TurnoDetalle_Turno]
GO


