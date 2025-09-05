CREATE TABLE [dbo].[Empresa](
	[IdEmpresa] [int] NOT NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_Empresa] PRIMARY KEY CLUSTERED 
(
	[IdEmpresa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO



ALTER TABLE [dbo].[Empresa]  WITH CHECK ADD  CONSTRAINT [FK_Empresa_CorePersona] FOREIGN KEY([IdEmpresa])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[Empresa] CHECK CONSTRAINT [FK_Empresa_CorePersona]
GO
