import { TodoGetHandlerResponse, TodoItem } from '@/types';
import { todoAPIEndpoints } from './config';

export const fetchTodoItems = async (): Promise<TodoItem[]> => {
  const response = await fetch(todoAPIEndpoints.list());
  const data: TodoGetHandlerResponse = await response.json();
  return data.items;
};
