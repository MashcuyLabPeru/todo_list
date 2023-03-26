import { TodoGetHandlerResponse, TodoItem } from '@/types';

const ENDPOINT = '/api/todo';

export const fetchTodoItems = async (): Promise<TodoItem[]> => {
  const response = await fetch(ENDPOINT);
  const data: TodoGetHandlerResponse = await response.json();
  return data.items;
};
