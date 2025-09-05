create PROCEDURE [dbo].[ListarHorario]
/*
'**********************************************************************************
'*	Procedimiento almacenado de listado de eventos
'*	Input			: 	
						@pIdEmpresa - Id de la empresa
						@pIdLocal - Id del local
						@pIdEvento - Id del evento,
						@pNombre - Nombre del evento,
						@pDescripcion - Descripcion del evento,
						@pFechaInicio - Fecha de inicio del evento,
						@pFechaFin - Fecha final del evento,
						@pEstado - Estado del evento,
						@pNumPagina - Número de página
						@pTamPagina - Cantidad de registros por página
'*	Output			: <Ninguno>
'*	Creado Por		: John Castillo
'*	Fec Creación	: 08/08/2016
'**********************************************************************************
*/
(
	@pIdLocal int = null,
	@pIdUbicacion int = null,
	@pIdHorario int = null,
	@pIdMozo int = null,
	@pDia int = null,
	@pEstado char(1) = null,
	@pNumPagina int = null,
	@pTamPagina int = null
)
As
Begin
		Select tbl.*
		from(
		Select
		ROW_NUMBER() OVER (ORDER BY T.IdLocal,T.IdUbicacion,Dia ASC) AS Num_Fila,
			T.IdLocal,
			T.IdUbicacion,
			T.IdHorario,
			T.IdMozo,
			T.Dia,
			T.Estado,
			T.UsuarioCreacion,
			T.FechaCreacion,
			T.UsuarioModificacion,
			T.FechaModificacion,
			E.IdEmpleado as Empleado_IdEmpleado,
			E.IdPersona as Empleado_IdPersona,
			PE.IdPersona as CorePersona_IdPersona,
			PE.Nombres as CorePersona_Nombres,
			PE.ApellidoPaterno as CorePersona_ApellidoPaterno,
			PE.ApellidoMaterno as CorePersona_ApellidoMaterno,
			COUNT(*) OVER() Total_Filas
			From Horario T
			inner join Empleado E on
			E.IdEmpleado = T.IdMozo
			inner join CorePersona PE on
			PE.IdPersona = E.IdPersona
			Where 
			(@pIdLocal is null or T.IdLocal = @pIdLocal) AND
			(@pIdUbicacion is null or T.IdUbicacion = @pIdUbicacion) AND
			(@pIdHorario is null or T.IdHorario = @pIdHorario) AND
			(@pIdMozo is null or T.IdMozo = @pIdMozo) AND
			(@pDia is null or T.Dia = @pDia) AND
			(@pEstado is null or T.Estado = @pEstado) 
		) tbl
		WHERE (@pTamPagina IS NULL OR tbl.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
End
