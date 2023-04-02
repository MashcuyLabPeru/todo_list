# sqlAlchemy
from sqlalchemy import create_engine, MetaData

# settings
from .settings import DB_URL

engine = create_engine(DB_URL)

meta = MetaData()

conn = engine.connect()