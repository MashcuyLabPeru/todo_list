import { TodoItem } from '@/types';
import type { NextApiRequest, NextApiResponse } from 'next';
import { todoRepository } from '../repository';

const updateHandler = (req: NextApiRequest, res: NextApiResponse<TodoItem>) => {
  const item: TodoItem = req.body;
  todoRepository.update(item);
  res.status(200).end();
};

const deleteHandler = (req: NextApiRequest, res: NextApiResponse) => {
  todoRepository.delete(Number(req.query.itemId));
  res.status(200).end();
};

const handler = (req: NextApiRequest, res: NextApiResponse) => {
  switch (req.method) {
    case 'PUT':
      updateHandler(req, res);
      break;
    case 'DELETE':
      deleteHandler(req, res);
      break;
    default:
      res.status(405).end();
  }
};

export default handler;
