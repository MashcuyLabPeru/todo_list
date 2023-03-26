import { TodoItem } from '@/types';

export class PostgreSQLRepository {
  list = async (): Promise<TodoItem[]> => {
    throw new Error('Not Implemented');
  };
  create = async (item: TodoItem) => {
    throw new Error('Not Implemented');
  };
  update = async (item: TodoItem) => {
    throw new Error('Not Implemented');
  };
  delete = async (itemId: number) => {
    throw new Error('Not Implemented');
  };
}
