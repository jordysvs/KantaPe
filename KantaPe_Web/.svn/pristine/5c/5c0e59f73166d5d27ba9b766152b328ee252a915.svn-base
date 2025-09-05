create PROCEDURE [dbo].[ListarEstadoAperturaUsuario] 
/*
'**********************************************************************************
'* Procedimiento almacenado de listado de usuarios de la Apertura
'* Input :
		@pIdLocal - Id del local
		@pIdApertura - Id de la apertura
		@pIdUsuario - Id del usuario
		@pAdministrador - Usuario administrador
		@pEstado - Estado del Apertura
		@pNumPagina - Número de pagina
		@pTamPagina - Cantidad de registros por pagina
'* Output : Lista de usuarios de la apertura
'* Creado Por : John Castillo
'* Fecha Creación : 07-09-2016
'**********************************************************************************
*/
(
	@pIdLocal int = null, 
	@pIdApertura int = null, 
	@pIdAperturaUsuario int = null,
	@pIdUsuario varchar(20) = null, 
	@pAdministrador char(1) = null, 
	@pEstado varchar(1) = null, 
	@pNumPagina int = null, 
	@pTamPagina int = null
)
AS
BEGIN
		Select TBL.*
		From(
			Select
				ROW_NUMBER() OVER (ORDER BY AU.IdLocal, AU.IdApertura DESC) AS Num_Fila,
				AU.IdLocal,
				AU.IdApertura,
				AU.IdAperturaUsuario,
				AU.IdUsuario,
				AU.Administrador,
				AU.FechaIngreso,
				AU.FechaFinal,
				AU.Latitud,
				AU.Longitud,
				AU.Estado,
				AU.UsuarioCreacion,
				AU.FechaCreacion,
				AU.UsuarioModificacion,
				AU.FechaModificacion,
				U.IdUsuario as Usuario_IdUsuario,
				U.IdPersona as Usuario_IdPersona,
				PE.IdPersona as Persona_IdPersona,
				PE.IdTipoDocumento as Persona_IdTipoDocumento,
				PE.NumeroDocumento as Persona_NumeroDocumento,
				PE.Nombres as Persona_Nombres,
				PE.ApellidoPaterno as Persona_ApellidoPaterno,
				PE.ApellidoMaterno as Persona_ApellidoMaterno,
				TD.IdTipoDocumento as TipoDocumento_IdTipoDocumento,
				TD.Descripcion as TipoDocumento_Descripcion,
				COUNT(*) OVER() Total_Filas
			From AperturaUsuario AU
			inner join SecurityUsuario U on
			U.IdUsuario = AU.IdUsuario
			inner join CorePersona PE on
			PE.IdPersona = U.IdPersona
			left join CoreTipoDocumento TD on
			TD.IdTipoDocumento = PE.IdTipoDocumento
			Where 
				(@pIdLocal is null or AU.IdLocal = @pIdLocal) AND
				(@pIdApertura is null or AU.IdApertura = @pIdApertura) AND
				(@pIdAperturaUsuario is null or AU.IdAperturaUsuario = @pIdAperturaUsuario) AND
				(@pIdUsuario is null or AU.IdUsuario = @pIdUsuario) AND
				(@pAdministrador is null or AU.Administrador = @pAdministrador)
				--(@pEstado is null or AU.Estado = @pEstado) 
				--(AU.Estado IN ('P','A'))
		) TBL
		Where (@pTamPagina IS NULL OR TBL.Num_Fila BETWEEN (@pNumPagina * @pTamPagina)- @pTamPagina + 1 AND (@pNumPagina * @pTamPagina));
END
