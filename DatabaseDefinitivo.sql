--CREAZIONE DELLE TABELLE

--Creazione tabella AREA_TEMATICA
CREATE TABLE AREA_TEMATICA(
	Categoria VARCHAR(30) PRIMARY KEY);

--Creazione tabella RESPONSABILE
CREATE TABLE RESPONSABILE(
	CodiceResponsabile INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30) NOT NULL,
	DataNascita NascitaLecita NOT NULL,
	CF CHAR(16) NOT NULL,
	Username VARCHAR(16),
	Pwd VARCHAR(16));

--Creazione tabella STUDENTE
CREATE TABLE STUDENTE(
	CodiceStudente CHAR(10) PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita NascitaLecita NOT NULL,
	CF CHAR(16) NOT NULL);

--Creazione tabella DOCENTE
CREATE TABLE DOCENTE(
	CodiceDocente INT PRIMARY KEY,
	Nome VARCHAR(20) NOT NULL,
	Cognome VARCHAR(20) NOT NULL,
	LuogoNascita VARCHAR(30),
	DataNascita  NascitaLecita NOT NULL,
	CF CHAR(16) NOT NULL);

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
	CONSTRAINT DocenteRipetuto UNIQUE(CodiceLezione,CodiceDocente),
	--Implemento il vincolo: LezioneOnline
	CONSTRAINT LezioneOnline CHECK (Piattaforma IS NULL OR Online=TRUE));

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


--ALTRI VINCOLI
--Creo il vincolo: NascitaLecita
CREATE DOMAIN NascitaLecita AS DATE
	CHECK (VALUE >'1960-01-01');
	
	
	
--PROVE	
CREATE OR REPLACE TRIGGER PartecipazioneLegittima
	BEFORE INSERT ON PARTECIPARE
	FOR EACH ROW
	EXECUTE 


--DROP DI TUTTE LE TABELLE
DROP TABLE ISCRIZIONE CASCADE;
DROP TABLE CORSO CASCADE;
DROP TABLE LEZIONE CASCADE;
DROP TABLE STUDENTE CASCADE;
DROP TABLE AREA_TEMATICA CASCADE;
DROP TABLE TEMATICA_CORSO CASCADE;
DROP TABLE RESPONSABILE CASCADE;
DROP TABLE DOCENTE CASCADE;
DROP TABLE PARTECIPARE CASCADE;

--DROP DEI VINCOLI
DROP DOMAIN NascitaLecita;

--POPOLO LE TABELLE
--POPOLO LA TABELLA AREA_TEMATICA
INSERT INTO AREA_TEMATICA
VALUES('Geografia');
INSERT INTO AREA_TEMATICA
VALUES('Italiano');
INSERT INTO AREA_TEMATICA
VALUES('Inglese');
INSERT INTO AREA_TEMATICA
VALUES('Informatica');
INSERT INTO AREA_TEMATICA
VALUES('Matematica');
INSERT INTO AREA_TEMATICA
VALUES('Giurisprudenza');
INSERT INTO AREA_TEMATICA
VALUES('Fisica');
INSERT INTO AREA_TEMATICA
VALUES('Biologia');
INSERT INTO AREA_TEMATICA
VALUES('Chimica');
INSERT INTO AREA_TEMATICA
VALUES('Psicologia');
INSERT INTO AREA_TEMATICA
VALUES('Design');
INSERT INTO AREA_TEMATICA
VALUES('Architettura');

--POPOLO LA TABELLA RESPONSABILE
INSERT INTO RESPONSABILE
VALUES(1,'Mario','Rossi','Napoli','1984-12-1', 'RSSMRA84T10F839P');
INSERT INTO RESPONSABILE
VALUES(2,'Caterina','Castaldo','Milano','1970-1-2', 'CSTCRN70A42F205G');
INSERT INTO RESPONSABILE
VALUES(3,'Marcello','Castelli','Napoli','1982-6-14', 'CSTMCL82H14F839F');
INSERT INTO RESPONSABILE
VALUES(4,'Chiara','De Luca','Maddaloni','1990-3-24', 'DLCCHR90C64E791A');
INSERT INTO RESPONSABILE
VALUES(5,'Federica','Rossi','Caserta','1970-10-10', 'RSSFRC70R50B963P');

--POPOLO LA TABELLA STUDENTE
INSERT INTO STUDENTE
VALUES(1,'Paolo','Dezio','Maddaloni','1998-06-24','DZEPLA98H24E791R');
INSERT INTO STUDENTE
VALUES(2,'Aldo','Dezio','Maddaloni','1997-07-12','DZELDA97L12E791X');
INSERT INTO STUDENTE
VALUES(3,'Matteo','Castaldo','Napoli','1990-08-10','CSTMTT90M10F839P');
INSERT INTO STUDENTE
VALUES(4,'Giovanni','Esposito','Bologna','1995-03-7','SPSGNN95C07A944E');
INSERT INTO STUDENTE
VALUES(5,'Rossella','Manna','Napoli','2001-2-3','MNNRLS01B43F839W');
INSERT INTO STUDENTE
VALUES(6,'Francesco','Matteotti','Cesena','1998-06-24','MTTFNC98H24C573I');
INSERT INTO STUDENTE
VALUES(7,'Matteo','Mennillo','Maddaloni','2001-03-26','MNNMTT01C26E791U');

--POPOLO LA TABELLA DOCENTE
INSERT INTO DOCENTE
VALUES(1,'Sabina','Martusciello','Napoli','1965-2-15','MRTSBN65B55F839K');
INSERT INTO DOCENTE
VALUES(2,'Luigi','Maffei','Roma','1975-10-27', 'MFFLGU75R27H501V');
INSERT INTO DOCENTE
VALUES(3,'Pasquale','Argenziano','Firenze','1992-11-11','RGNPQL92S11D612W');
INSERT INTO DOCENTE
VALUES(4,'Gaetano','Angelotti','Napoli','1966-12-25', 'NGLGTN60T25F839Z');
INSERT INTO DOCENTE
VALUES(5,'Valentina','Stella','Torino','1980-09-17', 'STLVNT80P57L219V');

--POPOLO LA TABELLA CORSO
INSERT INTO CORSO
VALUES(1,'Analisi Matematica 1','Corso di Analisi Matematica 1',30,24,CURRENT_DATE,1);
INSERT INTO CORSO
VALUES(2,'Programmazione','Corso di Programmazione',50,24,CURRENT_DATE+1,2);
INSERT INTO CORSO
VALUES(3,'Basi di dati','Corso di Basi di dati',45,36,CURRENT_DATE+4,2);
INSERT INTO CORSO
VALUES(4,'Latino 1','Corso di Latino 1',30,24,CURRENT_DATE+2,4);
INSERT INTO CORSO
VALUES(5,'Storia del Design' ,'Corso di Storia del Design',60,24,CURRENT_DATE+3,3);
INSERT INTO CORSO
VALUES(6,'Chimica 1','Corso di Chimica 1',50,36,CURRENT_DATE,4);
INSERT INTO CORSO
VALUES(7,'Analisi Matematica 2','Corso di Analisi Matematica 2',30,33,CURRENT_DATE+2,5);

--POPOLO LA TABELLA TEMATICA_CORSO
INSERT INTO TEMATICA_CORSO
VALUES('Matematica',1);
INSERT INTO TEMATICA_CORSO
VALUES('Informatica',2);
INSERT INTO TEMATICA_CORSO
VALUES('Informatica',3);
INSERT INTO TEMATICA_CORSO
VALUES('Italiano',4);
INSERT INTO TEMATICA_CORSO
VALUES('Design',5);
INSERT INTO TEMATICA_CORSO
VALUES('Chimica',6);
INSERT INTO TEMATICA_CORSO
VALUES('Matematica',7);

--POPOLO LA TABELLA LEZIONE
INSERT INTO LEZIONE
VALUES(1,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,1,1,FALSE,'1','PIAZZALE TECCHIO');
INSERT INTO LEZIONE
VALUES(2,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,1,1,TRUE,'1','PIAZZALE TECCHIO');
INSERT INTO LEZIONE
VALUES(3,'Lezione 1', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,2,1,TRUE,'2','PIAZZALE TECCHIO');
INSERT INTO LEZIONE
VALUES(4,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,2,1,FALSE,'2','PIAZZALE TECCHIO');
INSERT INTO LEZIONE
VALUES(5,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,3,2,TRUE,'3','MONTE SANT ANGELO');
INSERT INTO LEZIONE
VALUES(6,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,3,3,FALSE,'3','MONTE SANT ANGELO');
INSERT INTO LEZIONE
VALUES(7,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,4,3,FALSE,'4','MONTE SANT ANGELO');
INSERT INTO LEZIONE
VALUES(8,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,4,4,FALSE,'4','MONTE SANT ANGELO');
INSERT INTO LEZIONE
VALUES(9,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,5,5,TRUE,'5','AGNANO');
INSERT INTO LEZIONE
VALUES(10,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,5,5,TRUE,'5','AGNANO');
INSERT INTO LEZIONE
VALUES(11,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,6,2,FALSE,'6','AGNANO');
INSERT INTO LEZIONE
VALUES(12,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,6,1,TRUE,'6','AGNANO');
INSERT INTO LEZIONE
VALUES(13,'Lezione 1', 'Descrizione prima lezione', '2 hours', CURRENT_TIMESTAMP,7,3,TRUE,'7','PIAZZALE TECCHIO');
INSERT INTO LEZIONE
VALUES(14,'Lezione 2', 'Descrizione seconda lezione', '2 hours', CURRENT_TIMESTAMP,7,3,TRUE,'7','AGNANO');

--POPOLO LA TABELLA PARTECIPARE
INSERT INTO PARTECIPARE
VALUES(1,1);
INSERT INTO PARTECIPARE
VALUES(1,2);
INSERT INTO PARTECIPARE
VALUES(2,3);
INSERT INTO PARTECIPARE
VALUES(4,10);
INSERT INTO PARTECIPARE
VALUES(7,12);
INSERT INTO PARTECIPARE
VALUES(7,14);
INSERT INTO PARTECIPARE
VALUES(4,2);
INSERT INTO PARTECIPARE
VALUES(3,1);
INSERT INTO PARTECIPARE
VALUES(7,4);
INSERT INTO PARTECIPARE
VALUES(1,5);
INSERT INTO PARTECIPARE
VALUES(1,6);

--POPOLO LA TABELLA ISCRIZIONE
INSERT INTO ISCRIZIONE
VALUES(1,1);
INSERT INTO ISCRIZIONE
VALUES(1,2);
INSERT INTO ISCRIZIONE
VALUES(1,3);
INSERT INTO ISCRIZIONE
VALUES(2,4);
INSERT INTO ISCRIZIONE
VALUES(2,1);
INSERT INTO ISCRIZIONE
VALUES(3,7);
INSERT INTO ISCRIZIONE
VALUES(3,6);
INSERT INTO ISCRIZIONE
VALUES(4,1);
INSERT INTO ISCRIZIONE
VALUES(5,3);
INSERT INTO ISCRIZIONE
VALUES(5,6);
INSERT INTO ISCRIZIONE
VALUES(6,1);
INSERT INTO ISCRIZIONE
VALUES(6,4);
INSERT INTO ISCRIZIONE
VALUES(7,5);

--prova1
CREATE OR REPLACE PROCEDURE ELIMINA_CORSO(_CodiceCorso INT)
	LANGUAGE 'plpgsql' AS '
	BEGIN
	DELETE FROM CORSO
	WHERE CodiceCorso=_CodiceCorso;
	END;';
