-- FUNCTION: public.ricerca_per_categoria(character varying)

-- DROP FUNCTION IF EXISTS public.ricerca_per_categoria(character varying);

CREATE OR REPLACE FUNCTION public.ricerca_per_categoria(
	_categoria character varying)
    RETURNS SETOF corso 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
select distinct c.* from corso as c inner join tematica_corso as tc on c.codicecorso=tc.codicecorso
where tc.categoria in (select UNNEST (STRING_TO_ARRAY(_categoria,',')))
group by c.codicecorso		
having count (tc.categoria) = (SELECT COUNT(*) FROM (select UNNEST (STRING_TO_ARRAY(_categoria,','))) Y)
						
$BODY$;

ALTER FUNCTION public.ricerca_per_categoria(character varying)
    OWNER TO postgres;
	
-- FUNCTION: public.ricerca_per_data(date)

-- DROP FUNCTION IF EXISTS public.ricerca_per_data(date);

CREATE OR REPLACE FUNCTION public.ricerca_per_data(
	_data date)
    RETURNS SETOF corso 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
select * from corso as c
where c.datainizio = _data
$BODY$;

ALTER FUNCTION public.ricerca_per_data(date)
    OWNER TO postgres;
	
-- FUNCTION: public.ricerca_per_nome(character varying)

-- DROP FUNCTION IF EXISTS public.ricerca_per_nome(character varying);

CREATE OR REPLACE FUNCTION public.ricerca_per_nome(
	_nome character varying)
    RETURNS SETOF corso 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
select * from corso as c
where c.nome LIKE '%'||_nome||'%'
$BODY$;

ALTER FUNCTION public.ricerca_per_nome(character varying)
    OWNER TO postgres;

-- FUNCTION: public.ricerca_per_parola(character varying)

-- DROP FUNCTION IF EXISTS public.ricerca_per_parola(character varying);

CREATE OR REPLACE FUNCTION public.ricerca_per_parola(
	_parolachiave character varying)
    RETURNS SETOF corso 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
select * from corso as c
where c.descrizione LIKE '%'||_parolachiave||'%'
$BODY$;

ALTER FUNCTION public.ricerca_per_parola(character varying)
    OWNER TO postgres;

