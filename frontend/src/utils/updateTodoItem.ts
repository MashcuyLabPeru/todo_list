import { TodoItem } from '@/types';

const generateTodoEndpoint = (id: number) => `/api/todo/${id}/`;

export const updateTodoItem = async (todoItem: TodoItem) => {
  await fetch(generateTodoEndpoint(todoItem.id), {
    method: 'PUT',
    body: JSON.stringify(todoItem),
    headers: {
      'Content-Type': 'application/json',
    },
  });
};
