create PROCEDURE [dbo].[CoreListarPersona]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de personas
	para el usuario
'*	Input	: @pIdPersona - Id de la persona,
@pNombreCompleto - Nombre completo de la persona,
@pIdTipoDocumento - Id del tipo de documento de la persona,
@pNumeroDocumento - Numero de documento de la persona,
@pEstado - Estado de la persona,
@pNumPagina - Número de pagina
@pTamPagina - Cantidad de registros por pagina
'*	Output	: <Ninguno>
'*	Creado Por	: John Castillo
'*	Fec Creación	: 09/08/2015
'**********************************************************************************
*/
(
@pIdPersona varchar(20) = null,
@pNombreCompleto varchar(200) = null,
@pIdTipoDocumento int = null,
@pNumeroDocumento varchar(50) = null,
@pNumeroDocumentoFiltro varchar(50) = null,
@pSistema char(1) = null,
@pEstado char(1) = null,
@pNumPagina int = null,
@pTamPagina int = null
)
As
Begin
Select tbl.*
from(
Select
ROW_NUMBER() OVER (ORDER BY P.IdPersona ASC) AS Num_Fila,
P.IdPersona,
P.IdTipoDocumento,
P.NumeroDocumento,
P.Nombres,
P.ApellidoPaterno,
P.ApellidoMaterno,
P.RazonSocial,
P.NombreComercial,
[dbo].setDateSys(P.FechaNacimiento) as FechaNacimiento,
P.IdEstadoCivil,
P.Genero,
P.Sistema,
P.Estado,
P.UsuarioCreacion,
[dbo].setDateSys(P.FechaCreacion) as FechaCreacion,
P.UsuarioModificacion,
[dbo].setDateSys(P.FechaModificacion) as FechaModificacion,
PD.IdDireccion as PersonaDireccion_IdDireccion,
PD.Direccion as PersonaDireccion_Direccion,
PM.Mail as PersonaMail_Mail,
PT.IdTelefono as PersonaTelefono_IdTelefono,
PT.Numero as PersonaTelefono_Numero,
TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
TD.Descripcion as TipoDocumento_Descripcion,
EC.IdEstadoCivil as EstadoCivil_IdEstadoCivil,
EC.Descripcion as EstadoCivil_Descripcion,
COUNT(*) OVER() Total_Filas
From CorePersona P
Left Join CoreEstadoCivil EC on
EC.IdEstadoCivil = P.IdEstadoCivil AND
EC.Estado = 'A'
Left Join CoreTipoDocumento TD on
TD.IdTipoDocumento = P.IdTipoDocumento AND
TD.Estado = 'A'
Left Join (
Select
row_number() over(partition by IdPersona order by IdPersona) Num_Fila,
IdPersona, IdDireccion, Direccion
from CorePersonaDireccion
where Principal = 'S' AND Estado = 'A'
)PD on
PD.IdPersona = P.IdPersona AND
PD.Num_Fila = 1
Left Join (
Select
row_number() over(partition by IdPersona order by IdPersona) Num_Fila,
IdPersona,IdTelefono,Numero
from CorePersonaTelefono
where Principal = 'S' AND Estado = 'A'
) PT on
PT.IdPersona = P.IdPersona AND
PT.Num_Fila = 1
Left Join (
select
row_number() over(partition by IdPersona order by IdPersona) Num_Fila,
IdPersona,Mail
from CorePersonaMail
where Principal = 'S' AND Estado = 'A'
) PM on
PM.IdPersona = P.IdPersona AND
PM.Num_Fila = 1
Where
(@pIdPersona is null or P.IdPersona = @pIdPersona) AND
(@pNombreCompleto is null or
(
P.Nombres like '%' + @pNombreCompleto + '%' OR
P.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
P.ApellidoMaterno like '%' + @pNombreCompleto + '%'
)) AND
(@pIdTipoDocumento is null or P.IdTipoDocumento = @pIdTipoDocumento) AND
(@pNumeroDocumento is null or P.NumeroDocumento = @pNumeroDocumento) AND
(@pNumeroDocumentoFiltro is null or P.NumeroDocumento like '%' + @pNumeroDocumentoFiltro + '%') AND
(@pSistema is null or P.Sistema = @pSistema) AND
(@pEstado is null or P.Estado = @pEstado)
) tbl
WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
