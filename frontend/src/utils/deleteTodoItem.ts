import { todoAPIEndpoints } from './config';

export const deleteTodoItem = async (todoItemId: number) => {
  await fetch(todoAPIEndpoints.delete(todoItemId), {
    method: 'DELETE',
  });
};
