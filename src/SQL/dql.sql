SELECT estado FROM `Clientes`
WHERE identificacion = '456789123'
;


SELECT * FROM `Cuentas`
WHERE id = ?
;

SELECT CURDATE();

SELECT * from `Cheques` WHERE id_cuenta = 1 AND beneficiario = "" AND monto=1;

SELECT NOW();

/* 'Alta', 'Media', 'Baja' */
SELECT * from `Cheques`;
SELECT * from `Cheques` WHERE prioridad = "Media";
SELECT * from `Cheques` WHERE prioridad = "Baja";

UPDATE `Cheques` SET estado = ? AND fecha_proceso = NOW() WHERE numero_cheque = ?;

select identificacion FROM `Clientes` WHERE id = 1;

UPDATE `Cheques` SET estado = 'CH0001001' AND fecha_proceso = NOW() WHERE numero_cheque = 'Procesado';

 UPDATE `Cheques` SET estado = 'Procesado' , fecha_proceso = NOW() WHERE numero_cheque = 'CH0001001';