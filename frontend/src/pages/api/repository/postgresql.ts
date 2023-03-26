import { TodoItem } from '@/types';
import { Client } from 'pg';

const POSTGRES_HOST = process.env.POSTGRES_HOST;
const POSTGRES_DB = process.env.POSTGRES_DB;
const POSTGRES_PORT = Number(process.env.POSTGRES_PORT);
const POSTGRES_USER = process.env.POSTGRES_USER;
const POSTGRES_PASSWORD = process.env.POSTGRES_PASSWORD;

const DB_QUERIES = {
  list: `
    SELECT * FROM todos
    ORDER BY id;
  `,
  create: `
    INSERT INTO todos (text, completed)
    VALUES ($1, $2);
  `,
  update: `
    UPDATE todos
    SET text = $2, completed = $3
    WHERE id = $1;
  `,
  delete: `
    DELETE FROM todos
    WHERE id = $1;
  `,
};

export class PostgreSQLRepository {
  pg_client: Client;

  constructor() {
    this.pg_client = new Client({
      user: POSTGRES_USER,
      host: POSTGRES_HOST,
      database: POSTGRES_DB,
      password: POSTGRES_PASSWORD,
      port: POSTGRES_PORT,
    });
    this.pg_client.connect();
    this.create_db();
  }

  create_db = async () => {
    await this.pg_client.query(
      `
      CREATE TABLE IF NOT EXISTS todos  (
        id SERIAL PRIMARY KEY,
        text VARCHAR(255),
        completed BOOLEAN
      );
      `
    );
  };

  list = async (): Promise<TodoItem[]> => {
    const res = await this.pg_client.query(DB_QUERIES.list);
    return res.rows;
  };

  create = async (itemText: string) => {
    await this.pg_client.query(DB_QUERIES.create, [itemText, false]);
  };

  update = async (item: TodoItem) => {
    await this.pg_client.query(DB_QUERIES.update, [
      item.id,
      item.text,
      item.completed,
    ]);
  };

  delete = async (itemId: number) => {
    await this.pg_client.query(DB_QUERIES.delete, [itemId]);
  };
}
