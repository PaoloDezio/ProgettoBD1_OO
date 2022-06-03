-- PROCEDURE: public.crea_area_tematica(character varying)

-- DROP PROCEDURE IF EXISTS public.crea_area_tematica(character varying);

CREATE OR REPLACE PROCEDURE public.crea_area_tematica(
	IN _categoria character varying)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO AREA_TEMATICA (Categoria)
	VALUES (_Categoria);
	END;
$BODY$;
ALTER PROCEDURE public.crea_area_tematica(character varying)
    OWNER TO postgres;
	
	-- PROCEDURE: public.crea_corso(character varying, character varying, integer, integer, date, integer)

-- DROP PROCEDURE IF EXISTS public.crea_corso(character varying, character varying, integer, integer, date, integer);

CREATE OR REPLACE PROCEDURE public.crea_corso(
	IN _nome character varying,
	IN _descrizione character varying,
	IN _numeromaxpartecipanti integer,
	IN _numlezioni integer,
	IN _datainizio date,
	IN _codiceresponsabile integer)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO CORSO(Nome,Descrizione,numeromaxpartecipanti,NumeroLezioni,DataInizio,codiceresponsabile)
	VALUES (_Nome, _Descrizione, _numeromaxpartecipanti, _NumLezioni,_DataInizio,_codiceresponsabile);
	END;
$BODY$;
ALTER PROCEDURE public.crea_corso(character varying, character varying, integer, integer, date, integer)
    OWNER TO postgres;
	
-- PROCEDURE: public.crea_lezione(character varying, character varying, interval, timestamp without time zone, integer, integer, boolean, character varying, character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.crea_lezione(character varying, character varying, interval, timestamp without time zone, integer, integer, boolean, character varying, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.crea_lezione(
	IN _titolo character varying,
	IN _descrizione character varying,
	IN _durata interval,
	IN _dataorainizio timestamp without time zone,
	IN _codicecorso integer,
	IN _codicedocente integer,
	IN _online boolean,
	IN _aula character varying,
	IN _sede character varying,
	IN _piattaforma character varying)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO lezione (titolo,descrizione,durata,dataorainizio,codicecorso,online,aula,sede,piattaforma)
	VALUES (_titolo,_descrizione,durata,_dataorainizio,codicecorso,_online,_aula,_sede,_piattaforma);
	END;
$BODY$;
ALTER PROCEDURE public.crea_lezione(character varying, character varying, interval, timestamp without time zone, integer, integer, boolean, character varying, character varying, character varying)
    OWNER TO postgres;
	
	
-- PROCEDURE: public.iscrivi_studente(integer, integer)

-- DROP PROCEDURE IF EXISTS public.iscrivi_studente(integer, integer);

CREATE OR REPLACE PROCEDURE public.iscrivi_studente(
	IN _codicecorso integer,
	IN _codicestudente integer)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO iscrizione(codicecorso,codicestudente)
	VALUES (_codicecorso,_codicestudente);
	END;
$BODY$;
ALTER PROCEDURE public.iscrivi_studente(integer, integer)
    OWNER TO postgres;
	

-- PROCEDURE: public.registra_docente(character varying, character varying, character varying, date, character)

-- DROP PROCEDURE IF EXISTS public.registra_docente(character varying, character varying, character varying, date, character);

CREATE OR REPLACE PROCEDURE public.registra_docente(
	IN _nome character varying,
	IN _cognome character varying,
	IN _luogonascita character varying,
	IN _datanascita date,
	IN _codicefiscale character)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO docente (Nome,Cognome,LuogoNascita,DataNascita,Codicefiscale)
	VALUES (_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale);
	END;
$BODY$;
ALTER PROCEDURE public.registra_docente(character varying, character varying, character varying, date, character)
    OWNER TO postgres;

-- PROCEDURE: public.registra_responsabile(character varying, character varying, character varying, date, character, character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.registra_responsabile(character varying, character varying, character varying, date, character, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.registra_responsabile(
	IN _nome character varying,
	IN _cognome character varying,
	IN _luogonascita character varying,
	IN _datanascita date,
	IN _codicefiscale character,
	IN _username character varying,
	IN _pwd character varying)
LANGUAGE 'plpgsql'
AS $BODY$
	BEGIN
	INSERT INTO RESPONSABILE (Nome,Cognome,LuogoNascita,DataNascita,Codicefiscale,Username,password)
	VALUES (_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale,_Username,_Pwd);
	END;
$BODY$;
ALTER PROCEDURE public.registra_responsabile(character varying, character varying, character varying, date, character, character varying, character varying)
    OWNER TO postgres;
	
-- PROCEDURE: public.registra_studente(character varying, character varying, character varying, date, character)

-- DROP PROCEDURE IF EXISTS public.registra_studente(character varying, character varying, character varying, date, character);

CREATE OR REPLACE PROCEDURE public.registra_studente(
	IN _nome character varying,
	IN _cognome character varying,
	IN _luogonascita character varying,
	IN _datanascita date,
	IN _codicefiscale character)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
INSERT INTO STUDENTE(Nome,Cognome,LuogoNascita,DataNascita,Codicefiscale)
VALUES (_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale);
END;
$BODY$;
ALTER PROCEDURE public.registra_studente(character varying, character varying, character varying, date, character)
    OWNER TO postgres;
	
	
-- PROCEDURE: public.associa_categorie(integer, character varying)

-- DROP PROCEDURE IF EXISTS public.associa_categorie(integer, character varying);

CREATE OR REPLACE PROCEDURE public.associa_categorie(
	IN _codicecorso integer,
	IN _categorie character varying)
LANGUAGE 'plpgsql'
AS $BODY$
declare f varchar;
	BEGIN
	for f in (select UNNEST (STRING_TO_ARRAY(_categorie,',')))
	loop
	insert into tematica_corso (codicecorso, categoria)
	values(_codicecorso,f);
	end loop;
END;
$BODY$;
ALTER PROCEDURE public.associa_categorie(integer, character varying)
    OWNER TO postgres;