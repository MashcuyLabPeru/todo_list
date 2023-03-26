import { TodoItem } from '@/types';

let DATABASE: TodoItem[] = [];

export class MemoryRepository {
  getNewId = () => {
    const lastItem = DATABASE[DATABASE.length - 1];
    return lastItem ? lastItem.id + 1 : 1;
  };
  list = async (): Promise<TodoItem[]> => DATABASE;
  create = async (itemText: string) => {
    const item: TodoItem = {
      id: this.getNewId(),
      text: itemText,
      completed: false,
    };
    DATABASE.push(item);
  };
  update = async (item: TodoItem) => {
    let selectedItem = DATABASE.find((i) => i.id == item.id);
    if (!selectedItem) return;
    selectedItem.text = item.text;
    selectedItem.completed = item.completed;
  };
  delete = async (itemId: number) => {
    DATABASE = DATABASE.filter((item) => item.id != itemId);
  };
}
