CREATE TABLE [dbo].[FileServerDocumento](
	[IdAlmacen] [int] NOT NULL,
	[IdRegistro] [int] NOT NULL,
	[IdDocumento] [int] NOT NULL,
	[DescripcionFisica] [varchar](200) NULL,
	[DescripcionLogica] [varchar](200) NULL,
	[Extension] [varchar](5) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_FileServerDocumento] PRIMARY KEY CLUSTERED 
(
	[IdAlmacen] ASC,
	[IdRegistro] ASC,
	[IdDocumento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


ALTER TABLE [dbo].[FileServerDocumento]  WITH CHECK ADD  CONSTRAINT [FK_FileServerDocumento_FileServerAlmacen] FOREIGN KEY([IdAlmacen])
REFERENCES [dbo].[FileServerAlmacen] ([IdAlmacen])
GO

ALTER TABLE [dbo].[FileServerDocumento] CHECK CONSTRAINT [FK_FileServerDocumento_FileServerAlmacen]
GO


