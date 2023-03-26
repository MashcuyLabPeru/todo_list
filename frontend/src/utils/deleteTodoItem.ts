const generateTodoEndpoint = (id: number) => `/api/todo/${id}/`;

export const deleteTodoItem = async (todoItemId: number) => {
  await fetch(generateTodoEndpoint(todoItemId), {
    method: 'DELETE',
  });
};
