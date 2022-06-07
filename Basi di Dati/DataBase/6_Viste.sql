CREATE OR REPLACE VIEW public.num_studenti_per_lezione
 AS
 SELECT l.codicecorso,
    l.codicelezione,
    count(p.codicestudente) AS numero_studenti
   FROM lezione l
     JOIN partecipare p ON l.codicelezione = p.codicelezione
  GROUP BY l.codicelezione
  ORDER BY l.codicecorso, l.codicelezione;

ALTER TABLE public.num_studenti_per_lezione
    OWNER TO postgres;
	
	
-- View: public.studenti_per_corso

-- DROP VIEW public.studenti_per_corso;

CREATE OR REPLACE VIEW public.studenti_per_corso
 AS
 SELECT c.codicecorso,
    count(lp.codicestudente) AS numero_partecipanti
   FROM corso c
     JOIN ( SELECT l.codicecorso,
            p.codicestudente
           FROM lezione l
             JOIN partecipare p ON l.codicelezione = p.codicelezione) lp ON c.codicecorso = lp.codicecorso
  GROUP BY c.codicecorso;

ALTER TABLE public.studenti_per_corso
    OWNER TO postgres;

-- View: public.numero_lezioni_per_corso

-- DROP VIEW public.numero_lezioni_per_corso;

CREATE OR REPLACE VIEW public.numero_lezioni_per_corso
 AS
 SELECT l.codicecorso,
    count(l.codicelezione) AS numero_lezioni
   FROM lezione l
  GROUP BY l.codicecorso;

ALTER TABLE public.numero_lezioni_per_corso
    OWNER TO postgres;

-- View: public.lezione_con_presenze_massime

-- DROP VIEW public.lezione_con_presenze_massime;

CREATE OR REPLACE VIEW public.lezione_con_presenze_massime
 AS
 SELECT c.codicecorso,
    max(nums.numero_studenti) AS numero_massimo_studenti
   FROM corso c
     JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
  GROUP BY c.codicecorso;

ALTER TABLE public.lezione_con_presenze_massime
    OWNER TO postgres;

-- View: public.lezione_con_presenze_minime

-- DROP VIEW public.lezione_con_presenze_minime;

CREATE OR REPLACE VIEW public.lezione_con_presenze_minime
 AS
 SELECT c.codicecorso,
    min(nums.numero_studenti) AS numero_minimo_studenti
   FROM corso c
     JOIN num_studenti_per_lezione nums ON c.codicecorso = nums.codicecorso
  GROUP BY c.codicecorso;

ALTER TABLE public.lezione_con_presenze_minime
    OWNER TO postgres;
-- View: public.media_studenti

-- DROP VIEW public.media_studenti;

CREATE OR REPLACE VIEW public.media_studenti
 AS
 SELECT l.codicecorso,
    s.numero_partecipanti::double precision / l.numero_lezioni::double precision AS media
   FROM studenti_per_corso s
     JOIN numero_lezioni_per_corso l ON s.codicecorso = l.codicecorso
  GROUP BY l.codicecorso, s.numero_partecipanti, l.numero_lezioni;

ALTER TABLE public.media_studenti
    OWNER TO postgres;

-- View: public.num_studenti_per_lezione

-- DROP VIEW public.num_studenti_per_lezione;


	
-- View: public.numero_iscritti

-- DROP VIEW public.numero_iscritti;

CREATE OR REPLACE VIEW public.numero_iscritti
 AS
 SELECT i.codicecorso,
    count(i.codicestudente) AS numero_iscritti
   FROM iscrivere i
  GROUP BY i.codicecorso
  ORDER BY i.codicecorso;

ALTER TABLE public.numero_iscritti
    OWNER TO postgres;





