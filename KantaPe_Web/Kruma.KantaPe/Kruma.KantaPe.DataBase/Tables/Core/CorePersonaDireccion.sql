CREATE TABLE [dbo].[CorePersonaDireccion](
	[IdPersona] [int] NOT NULL,
	[IdDireccion] [int] NOT NULL,
	[IdUbigeo] [int] NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Direccion] [varchar](100) NULL,
	[Latitud] [varchar](50) NULL,
	[Longitud] [varchar](50) NULL,
	[Principal] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_PersonaDireccion_1] PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC,
	[IdDireccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[CorePersonaDireccion]  WITH CHECK ADD  CONSTRAINT [FK_CorePersonaDireccion_CoreUbigeo] FOREIGN KEY([IdUbigeo])
REFERENCES [dbo].[CoreUbigeo] ([IdUbigeo])
GO

ALTER TABLE [dbo].[CorePersonaDireccion] CHECK CONSTRAINT [FK_CorePersonaDireccion_CoreUbigeo]
GO

ALTER TABLE [dbo].[CorePersonaDireccion]  WITH CHECK ADD  CONSTRAINT [FK_PersonaDireccion_CorePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[CorePersonaDireccion] CHECK CONSTRAINT [FK_PersonaDireccion_CorePersona]
GO