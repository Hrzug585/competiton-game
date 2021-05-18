CREATE
user "dbUser" WITH ENCRYPTED PASSWORD 'dbPassword';

DROP
DATABASE IF EXISTS game_app;

CREATE
DATABASE game_app
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL
ON DATABASE game_app TO postgres;
GRANT ALL
ON DATABASE game_app TO "dbUser";

\connect game_app

-- SEQUENCE SETUP
-- tasks sequence
DROP SEQUENCE IF EXISTS public.tasks_seq CASCADE;
CREATE SEQUENCE public.tasks_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.tasks_seq
    OWNER TO "dbUser";

-- TABLES SETUP

DROP TABLE IF EXISTS public.tasks CASCADE;
CREATE TABLE public.tasks
(
    task_id     integer           NOT NULL DEFAULT nextval('tasks_seq'::regclass),
    task_name   character varying NOT NULL,
    description character varying NOT NULL,
    input_test  integer,
    output_test character varying,
    CONSTRAINT sessions_pkey PRIMARY KEY (task_id)
) TABLESPACE pg_default;
ALTER TABLE public.tasks
    OWNER to "dbUser";
