# TODO LIST MONOREPO

This project is an implementation of a todo list build with:

- Frontend in React
- Backend in Java
- Backend in Node
- Backend in Python
- Database in PostgreSQL

## Java Backend

WIP

## Node Backend

This implementation is found in the folder `frontend/src/pages/api`.

This backend is build with NextJS's API feature, it uses node and the `pg` library.

It follows the repository pattern to allow the migration to other database engines (or memory storage).

## Python Backend

please improve this description 

This implementation is located in the `python-backend` folder.

This backend is built with FastApi feature, it uses python, psycopg2 and sqlalchemy library.

This is a simple rest api that uses sql raw for transactions

## Makefile

| command | description                                      |
| ------- | ------------------------------------------------ |
| up-node | Start the node version of the project            |
| psql    | Open a shell for the running PostgreSQL instance |
