-- DOMAIN: public.datanascitavalida

-- DROP DOMAIN IF EXISTS public.datanascitavalida;

CREATE DOMAIN public.datanascitavalida
    AS date;

ALTER DOMAIN public.datanascitavalida OWNER TO postgres;

ALTER DOMAIN public.datanascitavalida
    ADD CONSTRAINT datanascitavalida_check CHECK (VALUE > '1940-01-01'::date);