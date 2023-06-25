import { ITodo, NewTodo } from './todo.model';

export const sampleWithRequiredData: ITodo = {
  id: 6305,
};

export const sampleWithPartialData: ITodo = {
  id: 70317,
  title: 'interfaces Executif Pays',
  description: 'Transexual Transexual Ouest',
};

export const sampleWithFullData: ITodo = {
  id: 56484,
  state: false,
  title: 'models',
  description: 'interface bleu Prêt',
};

export const sampleWithNewData: NewTodo = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
