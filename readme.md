# Animal Shelter 1.0.

CRUD-приложение, написанное на языке Java с использованием Spring-framework. 
Приложение парсит таблицу Exсel с данными библиотекой Apahe.Poi и заносит их в базу данных MySQL.  
Дальнейшее редактирование возможно при помощи фронтенда.

##Эндпоинты:

_/animals_ - отображает общий список обитателей приюта;

_/animal-create_ - создаём запись о новом обитателе;

_/animal-delete/{id}_ - удаляем запись об обитателе приюта;

_/animal-update/{id}_ - изменяем запись об обитателе приюта;

_/noname-animals_ - выводим список бездомных обитателей;

