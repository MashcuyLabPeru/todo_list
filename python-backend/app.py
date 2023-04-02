# FastApi
from fastapi import FastAPI

# routes
from api.routes.todos import todo

app = FastAPI()

app.include_router(todo, prefix="/api/todos")
