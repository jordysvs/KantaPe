create Procedure [dbo].[CoreListarEmpleado] 
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de empleados
	para el usuario
'*	Input			: 	@pIdEmpleado - Id del empleado,
						@pEstado - Estado del empleado,
						@pNumPagina - Número de pagina
						@pTamPagina - Cantidad de registros por pagina
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación		: 15/12/2014
'**********************************************************************************
*/
(
	@pIdEmpleado int = null,
	@pIdPersona int = null,
	@pNombreCompleto varchar(200) = null,
	@pIdTipoDocumento int = null,
	@pNumeroDocumento varchar(50) = null,
	@pIdArea int = null,
	@pIdPuesto int = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY E.IdEmpleado ASC) AS Num_Fila,
			E.IdEmpleado,
			E.IdPersona,
			E.IdArea,
			E.IdPuesto,
			E.Estado,
			E.UsuarioCreacion,
			E.FechaCreacion,
			E.UsuarioModificacion,
			E.FechaModificacion,
			P.Nombres as CorePersona_Nombres,
			P.ApellidoPaterno as CorePersona_ApellidoPaterno,
			P.ApellidoMaterno as CorePersona_ApellidoMaterno,
			P.Mail as CorePersona_Mail,
			P.IdTipoDocumento as CorePersona_IdTipoDocumento,
			P.NumeroDocumento as CorePersona_NumeroDocumento,
			P.Celular as CorePersona_Celular,
			TD.Descripcion as TipoDocumento_Descripcion,
			A.Descripcion as Area_Descripcion,
			PU.Descripcion as Puesto_Descripcion,
			COUNT(*) OVER() Total_Filas
			From CoreEmpleado E
			inner join CorePersona P on
			P.IdPersona = E.IdPersona
			Left Join CoreTipoDocumento TD on
			TD.IdTipoDocumento = P.IdTipoDocumento
			Left join CoreArea A on
			A.IdArea = E.IdArea 
			Left Join CorePuesto PU on
			PU.IdPuesto = E.IdPuesto 
			Where 
			(@pIdEmpleado is null or E.IdEmpleado = @pIdEmpleado) AND
			(@pIdPersona is null or E.IdPersona = @pIdPersona) AND
			(@pNombreCompleto is null or 
			(
			P.Nombres like '%' + @pNombreCompleto + '%' OR
			P.ApellidoPaterno like '%' + @pNombreCompleto + '%' OR
			P.ApellidoMaterno like '%' + @pNombreCompleto + '%' 
			)) AND
			(@pIdTipoDocumento is null or P.IdTipoDocumento = @pIdTipoDocumento) AND
			(@pNumeroDocumento is null or P.NumeroDocumento like '%' + @pNumeroDocumento + '%') AND
			(@pIdArea is null or E.IdArea = @pIdArea) AND
			(@pIdPuesto is null or E.IdPuesto = @pIdPuesto) AND
			(@pEstado is null or E.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));

End
