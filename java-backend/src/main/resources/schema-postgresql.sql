CREATE TABLE IF NOT EXISTS public.todos (
  id SERIAL PRIMARY KEY,
  text VARCHAR(255),
  completed BOOLEAN
);
