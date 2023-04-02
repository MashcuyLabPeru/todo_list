import os

DB_DRIVER = "postgresql+psycopg2"
DB_USER = os.environ.get("POSTGRES_USER")
DB_HOST = os.environ.get("POSTGRES_HOST")
DB_NAME = os.environ.get("POSTGRES_DB")
DB_PORT = os.environ.get("POSTGRES_PORT", 5432)
DB_PASSWORD = os.environ.get("POSTGRES_PASSWORD")

DB_URL = f"{DB_DRIVER}://{DB_USER}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}"
