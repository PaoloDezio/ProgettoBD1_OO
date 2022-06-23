-- FUNCTION: public.calcola_presenze_massime_per_corso(integer)

-- DROP FUNCTION public.calcola_presenze_massime_per_corso(integer);

CREATE OR REPLACE FUNCTION public.calcola_presenze_massime_per_corso(
	_codicecorso integer)
    RETURNS TABLE(numerostudenti integer) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
SELECT max(nums.numero_studenti) AS numero_massimo_studenti
FROM corso c JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
WHERE c.codicecorso=_codicecorso 
GROUP BY c.codicecorso
$BODY$;

ALTER FUNCTION public.calcola_presenze_massime_per_corso(integer)
    OWNER TO postgres;

-- FUNCTION: public.calcola_presenze_massime_per_lezione(integer)

-- DROP FUNCTION public.calcola_presenze_massime_per_lezione(integer);

CREATE OR REPLACE FUNCTION public.calcola_presenze_massime_per_lezione(
	_codicecorso integer)
    RETURNS TABLE(numerostudenti integer) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
SELECT max(nums.numero_studenti) AS numero_massimo_studenti
FROM corso c JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
WHERE c.codicecorso=_codicecorso 
GROUP BY c.codicecorso
$BODY$;

ALTER FUNCTION public.calcola_presenze_massime_per_lezione(integer)
    OWNER TO postgres;

-- FUNCTION: public.calcola_presenze_minime_per_corso(integer)

-- DROP FUNCTION public.calcola_presenze_minime_per_corso(integer);

CREATE OR REPLACE FUNCTION public.calcola_presenze_minime_per_corso(
	_codicecorso integer)
    RETURNS TABLE(numerostudenti integer) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
SELECT max(nums.numero_studenti) AS numero_minimo_studenti
FROM corso c JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
WHERE c.codicecorso=_codicecorso 
GROUP BY c.codicecorso
$BODY$;

ALTER FUNCTION public.calcola_presenze_minime_per_corso(integer)
    OWNER TO postgres;

-- FUNCTION: public.calcola_presenze_minime_per_lezione(integer)

-- DROP FUNCTION public.calcola_presenze_minime_per_lezione(integer);

CREATE OR REPLACE FUNCTION public.calcola_presenze_minime_per_lezione(
	_codicecorso integer)
    RETURNS TABLE(numerostudenti integer) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
SELECT min(nums.numero_studenti) AS numero_minimo_studenti
FROM corso c JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
WHERE c.codicecorso=_codicecorso 
GROUP BY c.codicecorso
$BODY$;

ALTER FUNCTION public.calcola_presenze_minime_per_lezione(integer)
    OWNER TO postgres;

-- FUNCTION: public.presenze_ad_un_corso(integer)

-- DROP FUNCTION public.presenze_ad_un_corso(integer);

CREATE OR REPLACE FUNCTION public.presenze_ad_un_corso(
	_codicecorso integer)
    RETURNS TABLE(codicestudente integer, presenze bigint) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
select lp.codicestudente,count(lp.codicestudente)as presenze
from corso as c join (select l.codicelezione,l.codicecorso,p.codicestudente
					  from lezione as l join partecipare as p
					  on l.codicelezione=p.codicelezione
					 ) as lp on lp.codicecorso=c.codicecorso
where c.codicecorso=_codicecorso
group by lp.codicestudente
$BODY$;

ALTER FUNCTION public.presenze_ad_un_corso(integer)
    OWNER TO postgres;

-- FUNCTION: public.ricerca_per_categoria(character varying)

-- DROP FUNCTION public.ricerca_per_categoria(character varying);

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

-- DROP FUNCTION public.ricerca_per_data(date);

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

-- DROP FUNCTION public.ricerca_per_nome(character varying);

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

-- DROP FUNCTION public.ricerca_per_parola(character varying);

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

-- FUNCTION: public.studenti_idonei(integer)

-- DROP FUNCTION public.studenti_idonei(integer);

CREATE OR REPLACE FUNCTION public.studenti_idonei(
	_codicecorso integer)
    RETURNS TABLE(codicestudente integer, cognome character varying, nome character varying) 
    LANGUAGE 'sql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$

select s.codicestudente,s.cognome,s.nome
from studente as s join (select * from presenze_ad_un_corso(_codicecorso)) as n
					 on s.codicestudente=n.codicestudente
group by s.codicestudente,n.presenze
having n.presenze>= (select c.numerolezioni
								from corso as c where c.codicecorso=_codicecorso)*80/100::float
								

$BODY$;

ALTER FUNCTION public.studenti_idonei(integer)
    OWNER TO postgres;
