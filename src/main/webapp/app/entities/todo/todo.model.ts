export interface ITodo {
  id: number;
  state?: boolean | null;
  title?: string | null;
  description?: string | null;
}

export type NewTodo = Omit<ITodo, 'id'> & { id: null };
