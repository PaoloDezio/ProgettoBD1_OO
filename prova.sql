--CREAZIONE DELLE TABELLE

--Creazione tabella CORSO
CREATE TABLE CORSO(
	CodiceCorso INT PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Descrizione VARCHAR(200),
	MaxPartecipanti INT NOT NULL,
	NumLezioni INT,
	DataInizio DATE
);

DROP TABLE CORSO CASCADE

--Creazione tabella AREA_TEMATICA
CREATE TABLE AREA_TEMATICA(
	CodiceCategoria INT PRIMARY KEY,
	Categoria VARCHAR(30) NOT NULL
);

DROP TABLE AREA_TEMATICA CASCADE

--Creazione tabella TEMATICA_CORSO
CREATE TABLE TEMATICA_CORSO(
	CodiceCategoria INT NOT NULL,
	CodiceCorso INT NOT NULL,
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceCategoria) REFERENCES AREA_TEMATICA(CodiceCategoria),
	
	--Implemento il vincolo: CategoriaRipetuta
	CONSTRAINT CategoriaRipetuta UNIQUE(CodiceCategoria,CodiceCorso)
);
DROP TABLE TEMATICA_CORSO CASCADE
--Creazione tabella RESPONSABILE
CREATE TABLE RESPONSABILE(
	CodiceResponsabile INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30) NOT NULL,
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL,
	Username VARCHAR(16),
	Pwd VARCHAR(16)
);
DROP TABLE RESPONSABILE CASCADE
--Creazione tabella STUDENTE
CREATE TABLE STUDENTE(
	Matricola CHAR(10) PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL
);
DROP TABLE STUDENTE CASCADE
--Creazione tabella DOCENTE
CREATE TABLE DOCENTE(
	CodiceDocente INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE,
	CodiceFiscale CHAR(16) NOT NULL
);
DROP TABLE DOCENTE CASCADE
--Creazione tabella LEZIONE
CREATE TABLE LEZIONE (
	CodiceLezione INT PRIMARY KEY,
	Titolo VARCHAR(50),
	Descrizione VARCHAR(200),
	Durata INTERVAL,
	DataOraInizio TIMESTAMP,
	CodiceCorso INT NOT NULL,
	CodiceDocente INT NOT NULL,
	Online BOOLEAN DEFAULT FALSE NOT NULL,
	Aula VARCHAR(20),
	Sede VARCHAR(20),
	Piattaforma VARCHAR(20),
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceDocente) REFERENCES DOCENTE(CodiceDocente),
	--Implemento il vincolo: DocenteRipetuto
	CONSTRAINT DocenteRipetuto UNIQUE(CodiceCorso,CodiceDocente)
);
DROP TABLE LEZIONE CASCADE
--Creazione tabella PARTECIPARE
CREATE TABLE PARTECIPARE(
	Matricola CHAR(10) NOT NULL,
	CodiceLezione INT NOT NULL,
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	FOREIGN KEY(CodiceLezione) REFERENCES LEZIONE(CodiceLezione),
	--Implemento il vincolo: MatricolaRipetuta
	CONSTRAINT MatricolaRipetuta UNIQUE (Matricola, CodiceLezione)
);
DROP TABLE PARTECIPARE CASCADE
--Creazione tabella ISCRIZIONE
CREATE TABLE ISCRIZIONE(
	CodiceCorso INT,
	Matricola CHAR(10),
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	--Implemento il vincolo: IscrizioneRipetuta
	CONSTRAINT IscrizioneRipetuta UNIQUE(CodiceCorso,Matricola)
);
DROP TABLE ISCRIZIONE CASCADE
--Popolazione delle tabelle
--Popolazione tabella CORSO
INSERT INTO CORSO(CodiceCorso, Nome, Descrizione, MaxPartecipanti, NumLezioni, DataInizio)
VALUES ('001','BASI DI DATI I','Corso di Basi di dati', '200','34',CURRENT_DATE);

INSERT INTO CORSO(CodiceCorso, Nome, Descrizione, MaxPartecipanti, NumLezioni, DataInizio)
VALUES ('002','OBJECT ORIENTATION','Corso di Object Orientation', '150','30',CURRENT_DATE);

INSERT INTO CORSO(CodiceCorso, Nome, Descrizione, MaxPartecipanti, NumLezioni, DataInizio)
VALUES ('003','ALGORITMI E STRUTTURE DATI','Corso di Algoritmi e stutture dati', '75','24',CURRENT_DATE+2);

INSERT INTO CORSO(CodiceCorso, Nome, Descrizione, MaxPartecipanti, NumLezioni, DataInizio)
VALUES ('004','ELEMENTI DI INFORMATICA TEORICA','Corso di Elementi di informatica teorica', '100','22',CURRENT_DATE+4);

--Popolazione tabella AREA_TEMATICA
INSERT INTO AREA_TEMATICA(CodiceCategoria, Categoria)
VALUES ('001','INFORMATICA');

INSERT INTO AREA_TEMATICA(CodiceCategoria, Categoria)
VALUES ('002','ELETTRONICA');

INSERT INTO AREA_TEMATICA(CodiceCategoria, Categoria)
VALUES ('003','LETTERATURA');

INSERT INTO AREA_TEMATICA(CodiceCategoria, Categoria)
VALUES ('004','MATEMATICA');

--Popolazione tabella TEMATICA_CORSO
INSERT INTO TEMATICA_CORSO(CodiceCategoria, CodiceCorso)
VALUES ('001','001');

INSERT INTO TEMATICA_CORSO(CodiceCategoria, CodiceCorso)
VALUES ('002','001');

INSERT INTO TEMATICA_CORSO(CodiceCategoria, CodiceCorso)
VALUES ('003','004');

INSERT INTO TEMATICA_CORSO(CodiceCategoria, CodiceCorso)
VALUES ('002','003');

--CREAZIONE DELLE PROCEDURE

--Creazione procedure per iscrivere uno studente ad un corso
CREATE OR REPLACE PROCEDURE ISCRIZIONECORSO(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'

--Creazione procedure che determina la partecipazione di uno studente ad una lezione
CREATE OR REPLACE PROCEDURE PARTECIPAZIONELEZIONE(_Matricola CHAR(10),_CodiceLezione INT)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO PARTECIPARE (Matricola, CodiceLezione)
	VALUES (_Matricola, _CodiceLezione);
	END;'

--Creazione procedure che permette di creare un corso
CREATE OR REPLACE PROCEDURE CREACORSO(_CodiceCorso INT,_Nome VARCHAR(50),_Descrizione VARCHAR(200),_MaxPartecipanti INT,_NumLezioni INT,_DataInizio DATE)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO CORSO(CodiceCorso,Nome,Descrizione,MaxPartecipanti,NumLezioni,DataInizio)
	VALUES (_CodiceCorso, _Nome, _Descrizione, _MaxPartecipanti, _NumLezioni,_DataInizio);
	END;'

--Creazione procedure che permette di creare una lezione
CREATE OR REPLACE PROCEDURE CREALEZIONE(_CodiceLezione INT,_Titolo VARCHAR(50),_Descrizione VARCHAR(200),_Durata INTERVAL,_DataOraInizio TIMESTAMP,_CodiceCorso INT,_CodiceDocente INT)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO LEZIONE (CodiceLezione,Titolo,Descrizione,Durata,DataOraInizio,CodiceCorso,CodiceDocente)
	VALUES (_CodiceLezione,_Titolo,_Descrizione,_Durata,_DataOraInizio,_CodiceCorso,_CodiceDocente);
	END;'

--
	CREATE OR REPLACE PROCEDURE REGISTRADOCENTE(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'
	
	CREATE OR REPLACE PROCEDURE ISCRIZIONECORSO(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'
	
	CREATE OR REPLACE PROCEDURE ISCRIZIONECORSO(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'
	
	CREATE OR REPLACE PROCEDURE ISCRIZIONECORSO(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'
	
	CREATE OR REPLACE PROCEDURE ISCRIZIONECORSO(_Corso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_Corso, _Matricola);
	END;'


