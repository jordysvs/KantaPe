create PROCEDURE [dbo].[ListarUsuarioPideCancionesTop] 
/*
'**********************************************************************************
'* Procedimiento almacenado de [ListarUsuarioPideCancionesTop]
'* Input :
'* Output : Lista de canciones de la apertura
'* Creado Por : Vicente Gonzales Osorio
'* Fecha Creación : 09-03-2017
'**********************************************************************************
*/
(
	@pNombreCompleto varchar(200) = null,
	@pIdEmpresa int = null,
	@pIdLocal int = null,
	@pFechaInicio datetime = null, 
	@pFechaFin datetime = null
)
AS
BEGIN
			Select

				--Usuario
				US.ApellidoPaterno + ' '+ US.ApellidoMaterno+', '+ US.Nombres as Usuario_NombreCompleto,
				count(1) as Cantidad

			From SolicitudCancion SO
			LEFT JOIN SecurityUsuario SU on
			SU.IdUsuario = SO.UsuarioCreacion
			LEFT JOIN CorePersona US on
			US.IdPersona = SU.IdPersona

			Where 
			    (@pNombreCompleto is null or 
			(
			US.Nombres like '%' + @pNombreCompleto + '%' OR
			US.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
			US.ApellidoMaterno like '%' + @pNombreCompleto + '%' 
			)) AND
		    ((CONVERT(DATE,@pFechaInicio) is null AND CONVERT(DATE,@pFechaFin) is null)  or 
			    (
				CONVERT(DATE,SO.FechaCreacion) between CONVERT(DATE,@pFechaInicio) and CONVERT(DATE,@pFechaFin)
			     ))
		    group by US.UsuarioCreacion, US.ApellidoPaterno + ' '+ US.ApellidoMaterno+', '+ US.Nombres
END
