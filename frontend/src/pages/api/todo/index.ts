import { TodoGetHandlerResponse, TodoItem } from '@/types';
import type { NextApiRequest, NextApiResponse } from 'next';
import { todoRepository } from '../repository';

const getHandler = async (
  _: NextApiRequest,
  res: NextApiResponse<TodoGetHandlerResponse>
) => {
  const items: TodoItem[] = await todoRepository.list();
  res.status(200).json({ items });
};

const postHandler = async (
  req: NextApiRequest,
  res: NextApiResponse<TodoItem>
) => {
  todoRepository.create(req.body.text);
  res.status(202).end();
};

const handler = async (req: NextApiRequest, res: NextApiResponse) => {
  switch (req.method) {
    case 'GET':
      getHandler(req, res);
      break;
    case 'POST':
      postHandler(req, res);
      break;
    default:
      res.status(405).end();
  }
};

export default handler;
