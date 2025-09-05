CREATE TABLE [dbo].[CorePersonaMail](
	[IdPersona] [int] NOT NULL,
	[IdMail] [int] NOT NULL,
	[Mail] [varchar](50) NOT NULL,
	[IdMailTipo] [int] NULL,
	[Principal] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_PersonaMail] PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC,
	[IdMail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[CorePersonaMail]  WITH CHECK ADD  CONSTRAINT [FK_PersonaMail_CorePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[CorePersona] ([IdPersona])
GO

ALTER TABLE [dbo].[CorePersonaMail] CHECK CONSTRAINT [FK_PersonaMail_CorePersona]
GO