import { TodoItem } from '@/types';
import { deleteTodoItem } from '@/utils/deleteTodoItem';
import { updateTodoItem } from '@/utils/updateTodoItem';
import { RefreshIcon } from '../icons/RefreshIcon';
import Item from './Item';

interface TodoListProps {
  items: TodoItem[];
  refetch: () => void;
}

const TodoList: React.FC<TodoListProps> = ({ items, refetch }) => {
  const toggleItem = (item: TodoItem) => {
    updateTodoItem({
      ...item,
      completed: !item.completed,
    }).finally(refetch);
  };
  const removeItem = (itemId: number) => {
    deleteTodoItem(itemId).finally(refetch);
  };
  return (
    <div className="w-full">
      <div className="flex flex-row justify-between">
        <h1 className="text-xl underline">Items</h1>
        <button onClick={refetch}>
          <RefreshIcon />
        </button>
      </div>
      <div>
        {items.map((item) => (
          <Item
            key={`todo-item-${item.id}`}
            item={item}
            handleTodoToggle={toggleItem}
            handleTodoRemove={removeItem}
          />
        ))}
      </div>
    </div>
  );
};

export default TodoList;
