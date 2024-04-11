# DesafioMonedas
Desafío de inter cambio de monedas  


Postman   -   HACER CAMBIO DE MONEDA

curl --location 'http://localhost:8080/changecurrency' \
--header 'Content-Type: application/json' \
--data '{
    "typeCurrencyOrigin": "USD",
    "valueCurrencyOrigin": 64,
    "typeCurrencyDestiny": "PE",
    "valueCurrencyDestiny": 33
}'


postman - LISTAR CAMBIO DE MONEDAS 


curl --location 'http://localhost:8080/changecurrency/listChange'


postman - LISTAR VALORES DE CAMBIO POR TYPO

curl --location 'http://localhost:8080/changecurrency/type/USD'