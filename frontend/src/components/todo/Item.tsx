import { TodoItem } from '@/types';
import clsx from 'clsx';
import { TrashIcon } from '../icons/TrashIcon';

interface ItemProps {
  item: TodoItem;
  handleTodoToggle: (item: TodoItem) => void;
  handleTodoRemove: (itemId: number) => void;
}
const Item: React.FC<ItemProps> = ({
  item,
  handleTodoToggle,
  handleTodoRemove,
}) => (
  <div className="flex flex-row justify-between mt-2">
    <div className="flex flex-row" onClick={() => handleTodoToggle(item)}>
      <input
        type="checkbox"
        checked={item.completed}
        readOnly
        className="mr-2"
      />
      <div
        className={clsx({
          'line-through text-gray-500': item.completed,
        })}
      >
        {item.text}
      </div>
    </div>
    <button className="text-red-500" onClick={() => handleTodoRemove(item.id)}>
      <TrashIcon />
    </button>
  </div>
);
export default Item;
