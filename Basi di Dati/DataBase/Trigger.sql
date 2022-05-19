-- FUNCTION: public.controlla_iscrizioni()

-- DROP FUNCTION IF EXISTS public.controlla_iscrizioni();

CREATE OR REPLACE FUNCTION public.controlla_iscrizioni()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
	DECLARE
		new_record iscrivere%ROWTYPE;
	BEGIN
		-- Controllo numero di iscrizioni al corso
		IF ((SELECT COUNT(*) FROM Iscrivere I WHERE I.codicecorso = NEW.codicecorso) >= (SELECT C.numeromaxpartecipanti FROM Corso C WHERE C.codicecorso = NEW.codicecorso))
			THEN
			RAISE EXCEPTION 'Il corso ha superato il numero massimo di iscrizioni.';
		END IF;
		
		-- Popolazione del record di ritorno e ritorno al trigger.
		new_record.codicecorso = NEW.codicecorso;
		new_record.codicestudente = NEW.codicestudente;
		RETURN new_record;
	END;
$BODY$;

ALTER FUNCTION public.controlla_iscrizioni()
    OWNER TO postgres;
	
-- FUNCTION: public.crea_lezione()

-- DROP FUNCTION IF EXISTS public.crea_lezione();

CREATE OR REPLACE FUNCTION public.crea_lezione()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
declare
	_dataorainizio date = current_date+30;
	_codicecorso integer = (select max(codicecorso) from corso);
	result integer;
begin
insert into lezione(titolo,descrizione,durata,dataorainizio,codicecorso,codicedocente,online,aula,sede,piattaforma)
values ('Lezione','descrizione','02:00:00',_dataorainizio,_codicecorso,'1','true','aula','sede','piattaforma');
return result;
end;
$BODY$;

ALTER FUNCTION public.crea_lezione()
    OWNER TO postgres;
	
-- FUNCTION: public.prova()

-- DROP FUNCTION IF EXISTS public.prova();

CREATE OR REPLACE FUNCTION public.prova()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
begin
select new.dataorainizio;
end
$BODY$;

ALTER FUNCTION public.prova()
    OWNER TO postgres;
