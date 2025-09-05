CREATE TABLE [dbo].[CorePersona](
	[IdPersona] [int] NOT NULL,
	[IdTipoDocumento] [int] NULL,
	[NumeroDocumento] [varchar](20) NULL,
	[Nombres] [varchar](50) NULL,
	[ApellidoPaterno] [varchar](50) NULL,
	[ApellidoMaterno] [varchar](50) NULL,
	[RazonSocial] [varchar](100) NULL,
	[NombreComercial] [varchar](100) NULL,
	[FechaNacimiento] [datetime] NULL,
	[Genero] [int] NULL,
	[IdEstadoCivil] [int] NULL,
	[Sistema] [char](1) NULL,
	[Estado] [char](1) NULL,
	[UsuarioCreacion] [varchar](20) NULL,
	[FechaCreacion] [datetime] NULL,
	[UsuarioModificacion] [varchar](20) NULL,
	[FechaModificacion] [datetime] NULL,
 CONSTRAINT [PK_CorePersona_1] PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO