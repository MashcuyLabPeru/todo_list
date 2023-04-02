export enum TodoAction {
  SAVE,
  DELETE,
  UPDATE,
}

export interface TodoItem {
  id: number;
  text: string;
  completed: boolean;
}
