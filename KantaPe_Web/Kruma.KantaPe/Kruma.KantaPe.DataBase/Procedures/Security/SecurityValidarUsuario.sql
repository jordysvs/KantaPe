create PROCEDURE [dbo].[SecurityValidarUsuario]
/*
'**********************************************************************************
'* Procedimiento almacenado encargado de validar si existe el usuario
'* Input			: @pUsuario - Codigo del usuario
					  @pClave - Clavel del usuario
					  @@pValidationResult - Resultado de la validación
'* Output			: <Ninguno>
'* Creado Por		: John Castillo
'* Fec Creación		: 12/12/2014
'**********************************************************************************
*/
(
@pIdUsuario		varchar(20),
@pClave			varchar(50),
@pValidationResult int out
)
AS
Begin

	Set NoCount On  

	--Usuario Autenticado
	SET @pValidationResult = 1

	--Validacion de usuario
	IF NOT EXISTS(Select U.Idusuario From [SecurityUsuario] U Where U.IdUsuario = @pIdUsuario)
		BEGIN
		
		SET @pValidationResult = 2
		
		END
	--Validacion de constrasenia
	ELSE IF NOT EXISTS(
		Select U.IdUsuario
		From [SecurityUsuario] U
		Where
		U.IdUsuario = @pIdUsuario AND
		U.Clave = @pClave
	)
		BEGIN
		
		SET @pValidationResult = 3
		END

	ELSE 
		BEGIN
		
			--Validacion de expiracion del usuario
			IF EXISTS(
				select U.IdUsuario  
				From [SecurityUsuario] U
				Where
				U.FlagExpiracion = 'S' AND
				U.IdUsuario = @pIdUsuario
			)
			BEGIN
			
				IF EXISTS(
				Select U.idUsuario
				From [SecurityUsuario] U 
				Where U.IdUsuario = @pIdUsuario AND
				U.FechaExpiracion <= GETDATE())
				BEGIN
				
					SET @pValidationResult = 5
				END
			END

			IF EXISTS (
				Select IdParametro 
				from [CoreParametro]
				where 
				Estado = 'A' AND
				Valor = 'S' AND
				IdParametro = 'ClaveExpiracion'
				)
				BEGIN
			
					IF EXISTS(
						Select IdUsuario 
						from [SecurityUsuario]
						Where 
						IdUsuario = @pIdUsuario AND
						dateadd(day,(
						Select convert(int,Valor)
						from [CoreParametro] 
						Where Estado = 'A' AND 
						IdParametro = 'FechaClaveExpiracion'),
						FechaCambioClave) < GETDATE())
					BEGIN
					
					SET @pValidationResult = 7
					END
				
				END
		END
	Set NoCount Off
End
