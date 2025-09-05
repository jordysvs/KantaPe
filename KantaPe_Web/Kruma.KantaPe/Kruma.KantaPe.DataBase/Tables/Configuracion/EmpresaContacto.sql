CREATE TABLE [dbo].[EmpresaContacto](
	[IdEmpresa] [int] NOT NULL,
	[IdPersona] [int] NOT NULL,
	[Principal] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_EmpresaContacto] PRIMARY KEY CLUSTERED 
(
	[IdEmpresa] ASC,
	[IdPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[EmpresaContacto]  WITH CHECK ADD  CONSTRAINT [FK_EmpresaContacto_CorePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[EmpresaContacto] CHECK CONSTRAINT [FK_EmpresaContacto_CorePersona]
GO

ALTER TABLE [dbo].[EmpresaContacto]  WITH CHECK ADD  CONSTRAINT [FK_EmpresaContacto_Empresa] FOREIGN KEY([IdEmpresa])
REFERENCES [dbo].[Empresa] ([IdEmpresa])
GO

ALTER TABLE [dbo].[EmpresaContacto] CHECK CONSTRAINT [FK_EmpresaContacto_Empresa]
GO