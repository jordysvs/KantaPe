CREATE TABLE [dbo].[Local](
	[IdLocal] [int] NOT NULL,
	[IdEmpresa] [int] NULL,
	[IdDireccion] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
	[HoraInicio] [int] NULL,
	[HoraFin] [int] NULL,
	[Radio] [decimal](18, 2) NULL,
 CONSTRAINT [PK_Local] PRIMARY KEY CLUSTERED 
(
	[IdLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[Local]  WITH CHECK ADD  CONSTRAINT [FK_Local_CorePersonaDireccion] FOREIGN KEY([IdEmpresa], [IdDireccion])
REFERENCES [dbo].[CorePersonaDireccion] ([IdPersona], [IdDireccion])
GO

ALTER TABLE [dbo].[Local] CHECK CONSTRAINT [FK_Local_CorePersonaDireccion]
GO

ALTER TABLE [dbo].[Local]  WITH CHECK ADD  CONSTRAINT [FK_Local_Empresa] FOREIGN KEY([IdEmpresa])
REFERENCES [dbo].[Empresa] ([IdEmpresa])
GO

ALTER TABLE [dbo].[Local] CHECK CONSTRAINT [FK_Local_Empresa]
GO
