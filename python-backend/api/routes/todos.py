# FastApi
from fastapi import APIRouter, HTTPException, Response
from fastapi.responses import JSONResponse

# config
from config.db import conn

# models
from api.models.todos import todos, todo_querys

# schemas
from api.schemas.todos import *

todo = APIRouter()


@todo.get("/")
async def get_todos():
    result = conn.execute(todo_querys['select'])
    todos = []
    for row in result:
        todo = {
            "id": row.id,
            "text": row.text,
            "completed": row.completed
        }
        todos.append(todo)

    return JSONResponse(content=todos, status_code=201)


@todo.post("/")
async def create_todo(todo: TodoBase):
    new_todo = dict(todo)
    try:
        conn.execute(todo_querys['insert'], new_todo)
        conn.commit()
        return JSONResponse(content=new_todo, status_code=202)
    except Exception:
        raise HTTPException(status_code=405, detail='something went wrong!')


@todo.put("/{id}")
async def create_todo(id: int, todo: TodoBase) -> Todo:  # this method uses schemas to serialize the data, type hints
    conn.execute(todos.update().values(text=todo.text, completed=todo.completed).where(todos.c.id == id))
    result = conn.execute(todos.select().where(todos.c.id == id)).first()
    print('*'*5, conn.execute(todos.select().where(todos.c.id == id)).first())
    return result


@todo.delete("/{id}")
async def delete_todo(id: int):
    try:
        conn.execute(todo_querys['delete'], {'id': id})
        conn.commit()
        return Response(status_code=204)
    except Exception:
        raise HTTPException(status_code=405, detail='something went wrong!')


@todo.get("/{id}")
async def get_todo_by_id(id: int):
    try:
        result = conn.execute(todo_querys['select_by_id'], {'id': id})
        result = result.fetchone()

        todo = {
            'id': result[0],
            'text': result[1],
            'completed': result[2]
        }

        return JSONResponse(content=todo, status_code=200)
    except Exception:
        raise HTTPException(status_code=404, detail="not found")