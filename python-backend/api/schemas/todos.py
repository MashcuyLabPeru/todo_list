# FastApi
from pydantic import BaseModel


class TodoBase(BaseModel):
    text: str
    completed: bool = False


class Todo(TodoBase):
    id: int

    class Config:
        orm_mode = True