CREATE TABLE [dbo].[CoreUbigeo](
	[IdUbigeo] [int] NOT NULL,
	[IdPais] [int] NULL,
	[IdDepartamento] [int] NULL,
	[IdProvincia] [int] NULL,
	[IdDistrito] [int] NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_CoreUbigeo] PRIMARY KEY CLUSTERED 
(
	[IdUbigeo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[CoreUbigeo]  WITH CHECK ADD  CONSTRAINT [FK_CoreUbigeo_CoreDepartamento] FOREIGN KEY([IdDepartamento])
REFERENCES [dbo].[CoreDepartamento] ([IdDepartamento])
GO

ALTER TABLE [dbo].[CoreUbigeo] CHECK CONSTRAINT [FK_CoreUbigeo_CoreDepartamento]
GO

ALTER TABLE [dbo].[CoreUbigeo]  WITH CHECK ADD  CONSTRAINT [FK_CoreUbigeo_CoreDistrito] FOREIGN KEY([IdDistrito])
REFERENCES [dbo].[CoreDistrito] ([IdDistrito])
GO

ALTER TABLE [dbo].[CoreUbigeo] CHECK CONSTRAINT [FK_CoreUbigeo_CoreDistrito]
GO

ALTER TABLE [dbo].[CoreUbigeo]  WITH CHECK ADD  CONSTRAINT [FK_CoreUbigeo_CorePais] FOREIGN KEY([IdPais])
REFERENCES [dbo].[CorePais] ([IdPais])
GO

ALTER TABLE [dbo].[CoreUbigeo] CHECK CONSTRAINT [FK_CoreUbigeo_CorePais]
GO

ALTER TABLE [dbo].[CoreUbigeo]  WITH CHECK ADD  CONSTRAINT [FK_CoreUbigeo_CoreProvincia] FOREIGN KEY([IdProvincia])
REFERENCES [dbo].[CoreProvincia] ([IdProvincia])
GO

ALTER TABLE [dbo].[CoreUbigeo] CHECK CONSTRAINT [FK_CoreUbigeo_CoreProvincia]
GO