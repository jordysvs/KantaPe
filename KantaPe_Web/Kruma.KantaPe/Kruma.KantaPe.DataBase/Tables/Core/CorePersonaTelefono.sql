CREATE TABLE [dbo].[CorePersonaTelefono](
	[IdPersona] [int] NOT NULL,
	[IdTelefono] [int] NOT NULL,
	[IdTelefonoTipo] [int] NULL,
	[Numero] [varchar](50) NULL,
	[Principal] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_PersonaTelefono] PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC,
	[IdTelefono] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[CorePersonaTelefono]  WITH CHECK ADD  CONSTRAINT [FK_PersonaTelefono_CorePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[CorePersonaTelefono] CHECK CONSTRAINT [FK_PersonaTelefono_CorePersona]
GO