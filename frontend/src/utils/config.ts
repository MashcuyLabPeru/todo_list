export const API_HOST = process.env.NEXT_PUBLIC_API_HOST;
export const todoAPIEndpoints = {
  list: () => `${API_HOST}/v1.0/api/todo`,
  create: () => `${API_HOST}/v1.0/api/todo`,
  update: (id: number) => `${API_HOST}/v1.0/api/todo/${id}/`,
  delete: (id: number) => `${API_HOST}/v1.0/api/todo/${id}/`,
};
