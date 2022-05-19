-- Table: public.area_tematica

-- DROP TABLE IF EXISTS public.area_tematica;

CREATE TABLE IF NOT EXISTS public.area_tematica
(
    categoria character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT area_tematica_pkey PRIMARY KEY (categoria)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.area_tematica
    OWNER to postgres;
	
-- Table: public.corso

-- DROP TABLE IF EXISTS public.corso;

CREATE TABLE IF NOT EXISTS public.corso
(
    codicecorso integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descrizione character varying(200) COLLATE pg_catalog."default",
    numeromaxpartecipanti integer NOT NULL,
    numerolezioni integer NOT NULL,
    datainizio date NOT NULL,
    codiceresponsabile integer NOT NULL,
    CONSTRAINT corso_pkey PRIMARY KEY (codicecorso),
    CONSTRAINT nome_del_corso_ripetito UNIQUE (nome)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.corso
    OWNER to postgres;

-- Trigger: mio_trigger

-- DROP TRIGGER IF EXISTS mio_trigger ON public.corso;

CREATE TRIGGER mio_trigger
    AFTER INSERT
    ON public.corso
    FOR EACH ROW
    EXECUTE FUNCTION public.crea_lezione();
	
-- Table: public.docente

-- DROP TABLE IF EXISTS public.docente;

CREATE TABLE IF NOT EXISTS public.docente
(
    codicedocente integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(20) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(20) COLLATE pg_catalog."default" NOT NULL,
    luogonascita character varying(20) COLLATE pg_catalog."default" NOT NULL,
    datanascita datanascitavalida NOT NULL,
    codicefiscale character(16) COLLATE pg_catalog."default",
    CONSTRAINT docente_pkey PRIMARY KEY (codicedocente),
    CONSTRAINT codicefiscale_d_esistente UNIQUE (codicefiscale)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.docente
    OWNER to postgres;
	
-- Table: public.iscrivere

-- DROP TABLE IF EXISTS public.iscrivere;

CREATE TABLE IF NOT EXISTS public.iscrivere
(
    codicecorso integer NOT NULL,
    codicestudente integer NOT NULL,
    CONSTRAINT iscrizione_ripetuta UNIQUE (codicecorso, codicestudente),
    CONSTRAINT codicecorso_fkey FOREIGN KEY (codicecorso)
        REFERENCES public.corso (codicecorso) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT codicestudente_fkey FOREIGN KEY (codicestudente)
        REFERENCES public.studente (codicestudente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.iscrivere
    OWNER to postgres;
	
-- Table: public.lezione

-- DROP TABLE IF EXISTS public.lezione;

CREATE TABLE IF NOT EXISTS public.lezione
(
    codicelezione integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    titolo character varying(50) COLLATE pg_catalog."default",
    descrizione character varying(200) COLLATE pg_catalog."default",
    durata interval,
    dataorainizio timestamp without time zone NOT NULL,
    codicecorso integer NOT NULL,
    codicedocente integer NOT NULL,
    online boolean NOT NULL,
    aula character varying(20) COLLATE pg_catalog."default" NOT NULL,
    sede character varying(20) COLLATE pg_catalog."default" NOT NULL,
    piattaforma character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT lezione_pkey PRIMARY KEY (codicelezione),
    CONSTRAINT docente_gia_associato UNIQUE (codicelezione, codicedocente),
    CONSTRAINT codicecorso_fkey FOREIGN KEY (codicecorso)
        REFERENCES public.corso (codicecorso) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT codicedocente_fkey FOREIGN KEY (codicedocente)
        REFERENCES public.docente (codicedocente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.lezione
    OWNER to postgres;
	
-- Table: public.partecipare

-- DROP TABLE IF EXISTS public.partecipare;

CREATE TABLE IF NOT EXISTS public.partecipare
(
    codicestudente integer NOT NULL,
    codicelezione integer NOT NULL,
    CONSTRAINT partecipazione_ripetuta UNIQUE (codicestudente, codicelezione),
    CONSTRAINT codicelezione_fkey FOREIGN KEY (codicelezione)
        REFERENCES public.lezione (codicelezione) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT codicestudente_fkey FOREIGN KEY (codicestudente)
        REFERENCES public.studente (codicestudente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.partecipare
    OWNER to postgres;

-- Trigger: prova2

-- DROP TRIGGER IF EXISTS prova2 ON public.partecipare;

CREATE TRIGGER prova2
    BEFORE INSERT
    ON public.partecipare
    FOR EACH ROW
    EXECUTE FUNCTION public.prova();
	
-- Table: public.responsabile

-- DROP TABLE IF EXISTS public.responsabile;

CREATE TABLE IF NOT EXISTS public.responsabile
(
    codiceresponsabile integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(30) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(30) COLLATE pg_catalog."default" NOT NULL,
    luogonascita character varying(30) COLLATE pg_catalog."default" NOT NULL,
    datanascita datanascitavalida NOT NULL,
    codicefiscale character(16) COLLATE pg_catalog."default" NOT NULL,
    username character varying(16) COLLATE pg_catalog."default" NOT NULL,
    password character varying(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT responsabile_pkey PRIMARY KEY (codiceresponsabile),
    CONSTRAINT codicefiscale_r_esistente UNIQUE (codicefiscale)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.responsabile
    OWNER to postgres;
	
-- Table: public.studente

-- DROP TABLE IF EXISTS public.studente;

CREATE TABLE IF NOT EXISTS public.studente
(
    codicestudente integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(30) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(30) COLLATE pg_catalog."default" NOT NULL,
    luogonascita character varying(30) COLLATE pg_catalog."default" NOT NULL,
    datanascita datanascitavalida NOT NULL,
    codicefiscale character(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT studente_pkey PRIMARY KEY (codicestudente),
    CONSTRAINT codicefiscale_s_esistente UNIQUE (codicefiscale)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.studente
    OWNER to postgres;
	
-- Table: public.tematica_corso

-- DROP TABLE IF EXISTS public.tematica_corso;

CREATE TABLE IF NOT EXISTS public.tematica_corso
(
    categoria character varying(30) COLLATE pg_catalog."default" NOT NULL,
    codicecorso integer NOT NULL,
    CONSTRAINT area_tematica_gia_associata UNIQUE (categoria, codicecorso),
    CONSTRAINT categoria_gia_associata UNIQUE (categoria, codicecorso),
    CONSTRAINT categoria_fkey FOREIGN KEY (categoria)
        REFERENCES public.area_tematica (categoria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT codicecorso_fkey FOREIGN KEY (codicecorso)
        REFERENCES public.corso (codicecorso) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tematica_corso
    OWNER to postgres;