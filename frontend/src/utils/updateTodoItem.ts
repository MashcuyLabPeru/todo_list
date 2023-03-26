import { TodoItem } from '@/types';
import { todoAPIEndpoints } from './config';

export const updateTodoItem = async (todoItem: TodoItem) => {
  await fetch(todoAPIEndpoints.update(todoItem.id), {
    method: 'PUT',
    body: JSON.stringify(todoItem),
    headers: {
      'Content-Type': 'application/json',
    },
  });
};
