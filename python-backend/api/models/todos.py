# SqlAlchemy
from sqlalchemy import Table, Column, Integer, String, Boolean, text
from sqlalchemy.ext.declarative import declarative_base

# config
from config.db import meta, engine

Base = declarative_base()

todos = Table('todos', meta,
              Column('id', Integer(), primary_key=True, nullable=False, autoincrement=True),
              Column('text', String()),
              Column('completed', Boolean()))

todo_querys = {
    'select': text('''SELECT * FROM todos'''),
    'insert': text('''INSERT INTO todos(text, completed) VALUES(:text, :completed)'''),
    'update': text('''UPDATE todos SET text=:text, completed=:completed WHERE id=:id'''),
    'delete': text('''DELETE FROM todos WHERE id=:id'''),

    'select_by_id': text('''SELECT * FROM todos WHERE id=:id'''),
}


meta.create_all(engine)
