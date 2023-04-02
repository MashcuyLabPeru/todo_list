import { createTodoItem } from '@/utils/createTodoItem';
import { useRef } from 'react';

interface TodoFormProps {
  refetch: () => void;
}

const TodoForm: React.FC<TodoFormProps> = ({ refetch }) => {
  const inputRef = useRef<HTMLInputElement>(null);

  const handleNewTodoSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    if (!inputRef || !inputRef.current) return;
    event.preventDefault();
    createTodoItem(inputRef.current.value).then(() => {
      refetch();
    });
    inputRef.current.value = ''; // Reset input
  };

  return (
    <div className="w-full my-4 p-4 bg-white rounded-lg shadow-md">
      <h1 className="text-xl font-bold mb-4">Todo App</h1>
      <form onSubmit={handleNewTodoSubmit} className="flex mb-4">
        <input
          type="text"
          ref={inputRef}
          placeholder="Enter a new todo"
          className="border border-gray-400 p-2 rounded-lg w-full mr-2"
        />
        <button type="submit" className="bg-blue-500 text-white p-2 rounded-lg">
          Add
        </button>
      </form>
    </div>
  );
};

export default TodoForm;
