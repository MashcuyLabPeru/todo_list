import { todoAPIEndpoints } from './config';

export const createTodoItem = async (todoText: string) => {
  const payload = {
    text: todoText,
  };
  await fetch(todoAPIEndpoints.create(), {
    method: 'POST',
    body: JSON.stringify(payload),
    headers: {
      'Content-Type': 'application/json',
    },
  });
};
