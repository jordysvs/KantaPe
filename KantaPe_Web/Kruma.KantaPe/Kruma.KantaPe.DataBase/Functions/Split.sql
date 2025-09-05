CREATE FUNCTION [Split]
(
@pSeparador VARCHAR(32), 
@pCadena VARCHAR(MAX))
RETURNS TABLE
AS
RETURN
(
    SELECT r.value('.','VARCHAR(MAX)') as Item
    FROM (SELECT CONVERT(XML, N'<root><r>' + REPLACE(REPLACE(REPLACE(@pCadena,'& ','&amp; '),'<','&lt;'), @pSeparador, '</r><r>') + '</r></root>') as valxml) x
    CROSS APPLY x.valxml.nodes('//root/r') AS RECORDS(r)
)
