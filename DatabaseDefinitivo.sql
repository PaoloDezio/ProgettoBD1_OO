--CREAZIONE DELLE TABELLE

--Creazione tabella CORSO
CREATE TABLE CORSO(
	CodiceCorso INT PRIMARY KEY,
	Nome VARCHAR(50) NOT NULL,
	Descrizione VARCHAR(200),
	Capienza INT NOT NULL,
	NumLezioni INT NOT NULl,
	DataInizioCorso DATE,
	CodiceResponsabile INT,

--Imposto CodiceResponsabile come chiave esterna
FOREIGN KEY(CodiceResponsabile) REFERENCES RESPONSABILE(CodiceResponsabile)
);

--Creazione tabella AREA_TEMATICA
CREATE TABLE AREA_TEMATICA(
	Categoria VARCHAR(30) PRIMARY KEY);

--Creazione tabella TEMATICA_CORSO
CREATE TABLE TEMATICA_CORSO(
	Categoria VARCHAR(30) NOT NULL,
	CodiceCorso INT NOT NULL,
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(Categoria) REFERENCES AREA_TEMATICA(Categoria),
	
	--Implemento il vincolo: CategoriaRipetuta
	CONSTRAINT CategoriaRipetuta UNIQUE(Categoria,CodiceCorso));

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

--Creazione tabella RESPONSABILE
CREATE TABLE RESPONSABILE(
	CodiceResponsabile INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30) NOT NULL,
	DataNascita DATE NOT NULL,
	CF CHAR(16) NOT NULL,
	Username VARCHAR(16),
	Pwd VARCHAR(16));
	
--Creazione tabella STUDENTE
CREATE TABLE STUDENTE(
	CodiceStudente CHAR(10) PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE NOT NULL,
	CF CHAR(16) NOT NULL);

--Creazione tabella DOCENTE
CREATE TABLE DOCENTE(
	CodiceDocente INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita DATE,
	CF CHAR(16) NOT NULL);

--Creazione tabella PARTECIPARE
CREATE TABLE PARTECIPARE(
	CodiceStudente CHAR(10) NOT NULL,
	CodiceLezione INT NOT NULL,
	FOREIGN KEY(CodiceStudente) REFERENCES STUDENTE(CodiceStudente),
	FOREIGN KEY(CodiceLezione) REFERENCES LEZIONE(CodiceLezione),
	
	--Implemento il vincolo: PartecipazioneUnica
	CONSTRAINT PartecipazioneUnica UNIQUE (CodiceStudente, CodiceLezione));

--Creazione tabella ISCRIZIONE
CREATE TABLE ISCRIZIONE(
	CodiceCorso INT,
	CodiceStudente CHAR(10),
	FOREIGN KEY(CodiceCorso) REFERENCES CORSO(CodiceCorso),
	FOREIGN KEY(CodiceStudente) REFERENCES STUDENTE(CodiceStudente),
	
	--Implemento il vincolo: IscrizioneRipetuta
	CONSTRAINT IscrizioneRipetuta UNIQUE(CodiceCorso,CodiceStudente));

