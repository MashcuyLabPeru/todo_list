import { MemoryRepository } from './memory';
import { PostgreSQLRepository } from './postgresql';

const DB_EXISTS = !!process.env.POSTGRES_HOST;
export const todoRepository = DB_EXISTS
  ? new PostgreSQLRepository()
  : new MemoryRepository();
