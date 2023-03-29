# TODO LIST MONOREPO

This project is an implementation of a todo list build with:

- Frontend in React
- Backend in Java
- Backend in Node
- Backend in Python
- Database in PostgreSQL

## Java Backend

The implementation is found in the folder `java-backend`.

This is a simple Spring boot API

It follows good practices like: Dependency injection, Clean architecture, SOLID, google checkstyle
and API validations.

## Node Backend

This implementation is found in the folder `frontend/src/pages/api`.

This backend is build with NextJS's API feature, it uses node and the `pg` library.

It follows the repository pattern to allow the migration to other database engines (or memory storage).

## Python Backend

WIP

## Makefile

| command | description                                      |
| ------- | ------------------------------------------------ |
| up-node | Start the node version of the project            |
| psql    | Open a shell for the running PostgreSQL instance |
