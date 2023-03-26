import { MemoryRepository } from './memory';
import { PostgreSQLRepository } from './postgresql';

export const todoRepository = new MemoryRepository();
