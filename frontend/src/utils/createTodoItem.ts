const ENDPOINT = '/api/todo';

export const createTodoItem = async (todoText: string) => {
  const payload = {
    text: todoText,
  };
  await fetch(ENDPOINT, {
    method: 'POST',
    body: JSON.stringify(payload),
    headers: {
      'Content-Type': 'application/json',
    },
  });
};
