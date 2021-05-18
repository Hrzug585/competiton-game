\connect game_app

INSERT INTO public.tasks (task_name, description, input_test, output_test)
VALUES  ('fibbonacci', 'Write method printing first x numbers of fibonacci sequence starting from 0', 10, '0 1 1 2 3 5 8 13 21 34 55'),
        ('second task', 'test desc', 0, 'test output')
        ('write hello', 'Write method printing string "Hello World', 1, 'Hello World');
