create PROC [dbo].[CerrarAlertas]
@pIdLocal int = null
AS
	BEGIN
		UPDATE Alerta 
			SET 
				Estado = 'I', 
				FechaAtencion = [dbo].getDateSys(), 
				UsuarioModificacion = 'SYSTEM', 
				FechaModificacion = [dbo].getDateSys()  
			WHERE 
				Estado = 'P' and 
				(@pIdLocal is null or IdLocal = @pIdLocal)
		UPDATE Apertura 
			SET  
				FechaFinal = [dbo].getDateSys(),
			    UsuarioModificacion='SYSTEM',
				FechaModificacion = [dbo].getDateSys()  
			WHERE 
				Estado = 'A' and 
				(@pIdLocal is null or IdLocal = @pIdLocal)
	END
