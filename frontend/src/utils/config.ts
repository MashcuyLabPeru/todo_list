export const API_HOST = process.env.NEXT_PUBLIC_API_HOST;
export const todoAPIEndpoints = {
  list: () => `${API_HOST}/api/todo`,
  create: () => `${API_HOST}/api/todo`,
  update: (id: number) => `${API_HOST}/api/todo/${id}/`,
  delete: (id: number) => `${API_HOST}/api/todo/${id}/`,
};
