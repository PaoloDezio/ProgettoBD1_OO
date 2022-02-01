--CREAZIONE DELLE TABELLE

--Creazione tabella CORSO
CREATE TABLE CORSO(
	CodiceCorso INT PRIMARY KEY,
	Nome VARCHAR(15) NOT NULL,
	Descrizione VARCHAR(50),
	MaxPartecipanti INT NOT NULL,
	NumLezioni INT,
	DataInizio DATE,
);

--Creazione tabella AREA_TEMATICA
CREATE TABLE AREA_TEMATICA(
	CodiceCategoria INT PRIMARY KEY,
	Categoria VARCHAR(16) NOT NULL,
);

--Creazione tabella TEMATICA_CORSO
CREATE TABLE TEMATICA_CORSO(
	CodiceCategoria INT NOT NULL,
	CodiceCorso INT NOT NULL,
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceCategoria) REFERENCES AREA_TEMATICA(CodiceCategoria),
	
	--Implemento il vincolo: CategoriaRipetuta
	CONSTRAINT CategoriaRipetuta UNIQUE(CodiceCategoria,CodiceCorso)
);

--Creazione tabella RESPONSABILE
CREATE TABLE RESPONSABILE(
	CodiceResponsabile INT PRIMARY KEY,
	Nome VARCHAR(15) NOT NULL,
	Cognome VARCHAR(15) NOT NULL,
	LuogoNascita VARCHAR(15) NOT NULL,
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL,
	Username VARCHAR(16),
	Pwd VARCHAR(16)
);

--Creazione tabella STUDENTE
CREATE TABLE STUDENTE(
	Matricola CHAR(10) PRIMARY KEY,
	Nome VARCHAR(15) NOT NULL,
	Cognome VARCHAR(15) NOT NULL,
	LuogoNascita VARCHAR(15),
	DataNascita DATE NOT NULL,
	CodiceFiscale CHAR(16) NOT NULL
);

--Creazione tabella DOCENTE
CREATE TABLE DOCENTE(
	CodiceDocente INT PRIMARY KEY,
	Nome VARCHAR(15) NOT NULL,
	Cognome VARCHAR(15) NOT NULL,
	LuogoNascita VARCHAR(15),
	DataNascita DATE,
	CodiceFiscale CHAR(16) NOT NULL
);

--Creazione tabella LEZIONE
CREATE TABLE LEZIONE (
	CodiceLezione INT PRIMARY KEY,
	Titolo VARCHAR(16),
	Descrizione VARCHAR(32),
	Durata INTERVAL,
	DataOraInizio TIMESTAMP,
	CodiceCorso INT NOT NULL,
	CodiceDocente INT NOT NULL,
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceDocente) REFERENCES DOCENTE(CodiceDocente),
	--Implemento il vincolo: DocenteRipetuto
	CONSTRAINT DocenteRipetuto UNIQUE(CodiceCorso,CodiceDocente)
);

--Creazione tabella PARTECIPARE
CREATE TABLE PARTECIPARE(
	Matricola CHAR(10) NOT NULL,
	CodiceLezione INT NOT NULL,
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	FOREIGN KEY(CodiceLezione) REFERENCES LEZIONE(CodiceLezione),
	--Implemento il vincolo: MatricolaRipetuta
	CONSTRAINT MatricolaRipetuta UNIQUE (Matricola, CodiceLezione)
);

--Creazione tabella ISCRIZIONE
CREATE TABLE ISCRIZIONE(
	CodiceCorso INT,
	Matricola CHAR(10),
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(Matricola) REFERENCES STUDENTE(Matricola),
	--Implemento il vincolo: IscrizioneRipetuta
	CONSTRAINT IscrizioneRipetuta UNIQUE(CodiceCorso,Matricola)
);

--CREAZIONE DELLE PROCEDURE

--Creo la 
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




