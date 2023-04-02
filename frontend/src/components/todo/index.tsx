import { TodoItem } from '@/types';
import { fetchTodoItems } from '@/utils/fetchTodoItems';
import { NextPage } from 'next';
import { useEffect, useState } from 'react';
import TodoForm from './Form';
import TodoList from './List';

const TodoApp: NextPage = () => {
  const [items, setItems] = useState<TodoItem[]>([]);

  const refetch = () => fetchTodoItems().then(setItems);

  useEffect(() => {
    refetch();
  }, []);

  return (
    <div className="flex w-full h-screen justify-center">
      <div className="flex justify-center w-full lg:w-1/2 bg-slate-100">
        <div className="flex flex-col w-3/4 h-full">
          <TodoForm refetch={refetch} />
          <TodoList items={items} refetch={refetch} />
        </div>
      </div>
    </div>
  );
};

export default TodoApp;
