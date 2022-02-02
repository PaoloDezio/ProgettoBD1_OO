--CREAZIONE DELLE TABELLE

--Creazione tabella CORSO
CREATE TABLE CORSO(
	CodiceCorso INT PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Descrizione VARCHAR(200),
	MaxPartecipanti INT NOT NULL,
	NumLezioni INT,
	DataInizio DATE);

--Creazione tabella AREA_TEMATICA
CREATE TABLE AREA_TEMATICA(
	CodiceCategoria INT PRIMARY KEY,
	Categoria VARCHAR(30) NOT NULL);

--Creazione tabella TEMATICA_CORSO
CREATE TABLE TEMATICA_CORSO(
	CodiceCategoria INT NOT NULL,
	CodiceCorso INT NOT NULL,
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceCategoria) REFERENCES AREA_TEMATICA(CodiceCategoria),
	
	--Implemento il vincolo: CategoriaRipetuta
	CONSTRAINT CategoriaRipetuta UNIQUE(CodiceCategoria,CodiceCorso));

--Creazione tabella RESPONSABILE
CREATE TABLE RESPONSABILE(
	CodiceResponsabile INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30) NOT NULL,
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL,
	Username VARCHAR(16),
	Pwd VARCHAR(16));
	
--Creazione tabella STUDENTE
CREATE TABLE STUDENTE(
	Matricola CHAR(10) PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL);

--Creazione tabella DOCENTE
CREATE TABLE DOCENTE(
	CodiceDocente INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE,
	CodiceFiscale CHAR(16) NOT NULL);

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
	CONSTRAINT DocenteRipetuto UNIQUE(CodiceCorso,CodiceDocente));

--Creazione tabella PARTECIPARE
CREATE TABLE PARTECIPARE(
	Matricola CHAR(10) NOT NULL,
	CodiceLezione INT NOT NULL,
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	FOREIGN KEY(CodiceLezione) REFERENCES LEZIONE(CodiceLezione),
	
	--Implemento il vincolo: MatricolaRipetuta
	CONSTRAINT MatricolaRipetuta UNIQUE (Matricola, CodiceLezione));

--Creazione tabella ISCRIZIONE
CREATE TABLE ISCRIZIONE(
	CodiceCorso INT,
	Matricola CHAR(10),
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	
	--Implemento il vincolo: IscrizioneRipetuta
	CONSTRAINT IscrizioneRipetuta UNIQUE(CodiceCorso,Matricola));

--POPOLAZIONE DELLE TABELLE

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
CREATE OR REPLACE PROCEDURE ISCRIZIONE_CORSO(_CodiceCorso INT,_Matricola CHAR(10))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO ISCRIZIONE (CodiceCorso, Matricola)
	VALUES (_CodiceCorso, _Matricola);
	END;';

--Creazione procedure che determina la partecipazione di uno studente ad una lezione
CREATE OR REPLACE PROCEDURE PARTECIPAZIONE_LEZIONE(_Matricola CHAR(10),_CodiceLezione INT)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO PARTECIPARE (Matricola, CodiceLezione)
	VALUES (_Matricola, _CodiceLezione);
	END;';

--Creazione procedure che permette di creare un corso
CREATE OR REPLACE PROCEDURE CREA_CORSO(_CodiceCorso INT,_Nome VARCHAR(50),_Descrizione VARCHAR(200),_MaxPartecipanti INT,_NumLezioni INT,_DataInizio DATE)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO CORSO(CodiceCorso,Nome,Descrizione,MaxPartecipanti,NumLezioni,DataInizio)
	VALUES (_CodiceCorso, _Nome, _Descrizione, _MaxPartecipanti, _NumLezioni,_DataInizio);
	END;';

--Creazione procedure che permette di creare una lezione
CREATE OR REPLACE PROCEDURE CREA_LEZIONE(_CodiceLezione INT,_Titolo VARCHAR(50),_Descrizione VARCHAR(200),_Durata INTERVAL,_DataOraInizio TIMESTAMP,_CodiceCorso INT,_CodiceDocente INT,_Online BOOLEAN,_Aula VARCHAR(20),_Sede VARCHAR(20),_Piattaforma VARCHAR(20))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO LEZIONE (CodiceLezione,Titolo,Descrizione,Durata,DataOraInizio,CodiceCorso,CodiceDocente,Online,Aula,Sede,Piattaforma)
	VALUES (_CodiceLezione,_Titolo,_Descrizione,_Durata,_DataOraInizio,_CodiceCorso,_CodiceDocente,_Online,_Aula,_Sede,_Piattaforma);
	END;';

--Creazione procedure per registrare uno docente
	CREATE OR REPLACE PROCEDURE REGISTRA_DOCENTE(_CodiceDocente INT,_Nome VARCHAR(20),_Cognome VARCHAR(20),_LuogoNascita VARCHAR(30),_DataNascita DATE,_CodiceFiscale CHAR(16))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO DOCENTE (CodiceDocente,Nome,Cognome,LuogoNascita,DataNascita,CodiceFiscale)
	VALUES (_CodiceDocente,_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale);
	END;';

--Creazione procedure per registrare uno studente
	CREATE OR REPLACE PROCEDURE REGISTRA_STUDENTE(_Matricola CHAR(10),_Nome VARCHAR(20),_Cognome VARCHAR(20),_LuogoNascita VARCHAR(30),_DataNascita DATE,_CodiceFiscale CHAR(16))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO STUDENTE(Matricola,Nome,Cognome,LuogoNascita,DataNascita,CodiceFiscale)
	VALUES (_Matricola,_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale);
	END;';

--Creazione procedure per registrare un reponsabile
	CREATE OR REPLACE PROCEDURE REGISTRA_RESPONSABILE(_CodiceResponsabile INT,_Nome VARCHAR(20),_Cognome VARCHAR(20),_LuogoNascita VARCHAR(30),_DataNascita DATE,_CodiceFiscale CHAR(16),_Username VARCHAR(16),_Pwd VARCHAR(16))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO RESPONSABILE (CodiceResponsabile,Nome,Cognome,LuogoNascita,DataNascita,CodiceFiscale,Username,Pwd)
	VALUES (_CodiceResponsabile,_Nome,_Cognome,_LuogoNascita,_DataNascita,_CodiceFiscale,_Username,_Pwd);
	END;';

--Creazione procedure per definire un'area tematica
	CREATE OR REPLACE PROCEDURE CREA_AREA_TEMATICA(_CodiceCategoria INT,_Categoria VARCHAR(30))
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO AREA_TEMATICA (CodiceCategoria, Categoria)
	VALUES (_CodiceCategoria,_Categoria);
	END;';

--Creazione procedure per associare un'area tematica ad un corso
	CREATE OR REPLACE PROCEDURE ASSOCIA_TEMATICA_CORSO(_CodiceCategoria INT,_CodiceCorso INT)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	INSERT INTO TEMATICA_CORSO (CodiceCategoria,CodiceCorso)
	VALUES (_CodiceCategoria,_CodiceCorso);
	END;';


