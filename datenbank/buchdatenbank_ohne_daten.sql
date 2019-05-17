-- --------------------------------------------------------
-- Host:                         10.81.10.204
-- Server Version:               10.1.23-MariaDB-9+deb9u1 - Raspbian 9.0
-- Server Betriebssystem:        debian-linux-gnueabihf
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Exportiere Datenbank Struktur für Buchdatenbank
DROP DATABASE IF EXISTS `Buchdatenbank`;
CREATE DATABASE IF NOT EXISTS `Buchdatenbank` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Buchdatenbank`;

-- Exportiere Struktur von Tabelle Buchdatenbank.Adresse
DROP TABLE IF EXISTS `Adresse`;
CREATE TABLE IF NOT EXISTS `Adresse` (
  `AdresseID` int(11) NOT NULL AUTO_INCREMENT,
  `Strasse` varchar(255) DEFAULT NULL,
  `PLZ` varchar(8) DEFAULT NULL,
  `Stadt` varchar(255) DEFAULT NULL,
  `LandID` int(11) NOT NULL,
  PRIMARY KEY (`AdresseID`),
  KEY `LandID` (`LandID`),
  CONSTRAINT `Adresse_ibfk_1` FOREIGN KEY (`LandID`) REFERENCES `Land` (`LandID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Ausleihvorgang
DROP TABLE IF EXISTS `Ausleihvorgang`;
CREATE TABLE IF NOT EXISTS `Ausleihvorgang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Entleihdatum` datetime NOT NULL,
  `Rückgabe_fällig` datetime NOT NULL,
  `Rückgabedatum` datetime DEFAULT NULL,
  `Entleihort_id` int(11) NOT NULL,
  `Benutzer_id` int(11) NOT NULL,
  `Exemplar_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Entleihort_id` (`Entleihort_id`),
  KEY `Benutzer_id` (`Benutzer_id`),
  KEY `Ausleihvorgang_ibfk_3` (`Exemplar_id`),
  CONSTRAINT `Ausleihvorgang_ibfk_1` FOREIGN KEY (`Entleihort_id`) REFERENCES `Standort` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `Ausleihvorgang_ibfk_2` FOREIGN KEY (`Benutzer_id`) REFERENCES `Benutzer` (`BenutzerID`) ON UPDATE CASCADE,
  CONSTRAINT `Ausleihvorgang_ibfk_3` FOREIGN KEY (`Exemplar_id`) REFERENCES `Buchexemplar` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Autor
DROP TABLE IF EXISTS `Autor`;
CREATE TABLE IF NOT EXISTS `Autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `webseite` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Benutzer
DROP TABLE IF EXISTS `Benutzer`;
CREATE TABLE IF NOT EXISTS `Benutzer` (
  `BenutzerID` int(11) NOT NULL AUTO_INCREMENT,
  `Vorname` varchar(255) DEFAULT NULL,
  `Nachname` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Klasse` varchar(255) DEFAULT NULL,
  `Rolle` varchar(255) DEFAULT NULL,
  `Rechte` varchar(255) DEFAULT NULL,
  `AdresseID` int(11) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BenutzerID`),
  KEY `AdresseID` (`AdresseID`),
  CONSTRAINT `Benutzer_ibfk_1` FOREIGN KEY (`AdresseID`) REFERENCES `Adresse` (`AdresseID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Buch
DROP TABLE IF EXISTS `Buch`;
CREATE TABLE IF NOT EXISTS `Buch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Eigentuemer` text NOT NULL,
  `Datenträger` text NOT NULL,
  `Titel` text NOT NULL,
  `ISBN` text NOT NULL,
  `Verlagbestellnr` int(11) NOT NULL,
  `Autorid` int(11) NOT NULL,
  `Verlagid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Autorid` (`Autorid`),
  KEY `Verlagid` (`Verlagid`),
  CONSTRAINT `Buch_ibfk_1` FOREIGN KEY (`Autorid`) REFERENCES `Autor` (`id`),
  CONSTRAINT `Buch_ibfk_2` FOREIGN KEY (`Verlagid`) REFERENCES `Verlag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Buchexemplar
DROP TABLE IF EXISTS `Buchexemplar`;
CREATE TABLE IF NOT EXISTS `Buchexemplar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Auflage` int(11) DEFAULT NULL,
  `Buch_id` int(11) NOT NULL,
  `Standort_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Buch_id` (`Buch_id`),
  KEY `Standort_id` (`Standort_id`),
  CONSTRAINT `Buchexemplar_ibfk_1` FOREIGN KEY (`Buch_id`) REFERENCES `Buch` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `Buchexemplar_ibfk_2` FOREIGN KEY (`Standort_id`) REFERENCES `Standort` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Land
DROP TABLE IF EXISTS `Land`;
CREATE TABLE IF NOT EXISTS `Land` (
  `LandID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LandID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Standort
DROP TABLE IF EXISTS `Standort`;
CREATE TABLE IF NOT EXISTS `Standort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fach` text NOT NULL,
  `regalnr` int(11) NOT NULL,
  `fachbereich` text NOT NULL,
  `raumnr` text NOT NULL,
  `verantwortlicher` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von Tabelle Buchdatenbank.Verlag
DROP TABLE IF EXISTS `Verlag`;
CREATE TABLE IF NOT EXISTS `Verlag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `webseite` text NOT NULL,
  `hotline` text NOT NULL,
  `email` text NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Daten Export vom Benutzer nicht ausgewählt
-- Exportiere Struktur von View Buchdatenbank.´GetBuchInformations´
DROP VIEW IF EXISTS `´GetBuchInformations´`;
-- Erstelle temporäre Tabelle um View Abhängigkeiten zuvorzukommen
CREATE TABLE `´GetBuchInformations´` (
	`Buchtitel` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`ISBN` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`Datenträger` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`Eigentuemer` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`Verlagbestellnr` INT(11) NOT NULL,
	`verlagname` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`autorname` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`buchanzahl` INT(11) NULL,
	`buchanzahlverfügbar` INT(11) NULL
) ENGINE=MyISAM;

-- Exportiere Struktur von Prozedur Buchdatenbank.BorrowBook
DROP PROCEDURE IF EXISTS `BorrowBook`;
DELIMITER //
CREATE DEFINER=`root`@`%` PROCEDURE `BorrowBook`(IN userID INT, IN exemplarID INT, IN bKurzAusleihe BOOL, OUT nResult INT)
proc_label:BEGIN
	
	-- kein Ausleihen wenn noch überfällige Bücher offen
	IF (HasOverdueBooks(userID)) THEN
		SET nResult = 0;
		LEAVE proc_label;
	END IF;
	
	-- prüfen, ob gewünschtes Buchexemplar noch verfügbar ist
	IF (BookIsAvailable(exemplarID)) THEN
		SET nResult = 1;
		LEAVE proc_label;
	END IF;
	
	INSERT INTO Ausleihvorgang (Entleihdatum, Rückgabe_fällig, Entleihort_id, Benutzer_id, Exemplar_id)
		VALUES
		(
			CURRENT_TIMESTAMP(),
			DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 3 WEEK),
			(SELECT Standort_id FROM Buchexemplar WHERE id=exemplarID),
			userID,
			exemplarID
		)
	;	
	
	SET nResult = 2;
	
END//
DELIMITER ;

-- Exportiere Struktur von Funktion Buchdatenbank.BookIsAvailable
DROP FUNCTION IF EXISTS `BookIsAvailable`;
DELIMITER //
CREATE DEFINER=`root`@`%` FUNCTION `BookIsAvailable`(exemplarID INT) RETURNS tinyint(1)
BEGIN
	IF((SELECT COUNT(*) FROM Ausleihvorgang
		WHERE Ausleihvorgang.Rückgabedatum = NULL
			&& Ausleihvorgang.Exemplar_id = exemplarID
	) > 0) THEN
		RETURN 0;
	ELSE
		RETURN 1;
	END IF;
	
END//
DELIMITER ;

-- Exportiere Struktur von Funktion Buchdatenbank.CountAllCopiesOfBook
DROP FUNCTION IF EXISTS `CountAllCopiesOfBook`;
DELIMITER //
CREATE DEFINER=`root`@`%` FUNCTION `CountAllCopiesOfBook`(bookID INT) RETURNS int(11)
BEGIN
	RETURN (SELECT COUNT(*) FROM Buchexemplar
		WHERE Buchexemplar.Buch_id = bookID
	);
END//
DELIMITER ;

-- Exportiere Struktur von Funktion Buchdatenbank.CountAvailableCopiesOfBook
DROP FUNCTION IF EXISTS `CountAvailableCopiesOfBook`;
DELIMITER //
CREATE DEFINER=`root`@`%` FUNCTION `CountAvailableCopiesOfBook`(bookID INT) RETURNS int(11)
BEGIN
	RETURN (SELECT COUNT(*) FROM Buchexemplar
		INNER JOIN Ausleihvorgang
			ON Ausleihvorgang.Exemplar_id = Buchexemplar.id
		WHERE Buchexemplar.Buch_id = bookID
			&& BookIsAvailable(Buchexemplar.id)
	);
END//
DELIMITER ;

-- Exportiere Struktur von Funktion Buchdatenbank.HasOverdueBooks
DROP FUNCTION IF EXISTS `HasOverdueBooks`;
DELIMITER //
CREATE DEFINER=`root`@`%` FUNCTION `HasOverdueBooks`(userID INT) RETURNS tinyint(1)
BEGIN
	DECLARE nOverdueBooks INT;

	SELECT COUNT(*) FROM Ausleihvorgang
		WHERE Ausleihvorgang.Rückgabedatum = NULL
			&&	Ausleihvorgang.Rückgabe_fällig < CURDATE()
			&& Ausleihvorgang.Benutzer_id = userID
	INTO nOverdueBooks;
	
	IF(nOverdueBooks > 0) THEN
		RETURN 1;
	ELSE
		RETURN 0;
	END IF;
END//
DELIMITER ;

-- Exportiere Struktur von View Buchdatenbank.´GetBuchInformations´
DROP VIEW IF EXISTS `´GetBuchInformations´`;
-- Entferne temporäre Tabelle und erstelle die eigentliche View
DROP TABLE IF EXISTS `´GetBuchInformations´`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `´GetBuchInformations´` AS select `Buch`.`Titel` AS `Buchtitel`,`Buch`.`ISBN` AS `ISBN`,`Buch`.`Datenträger` AS `Datenträger`,`Buch`.`Eigentuemer` AS `Eigentuemer`,`Buch`.`Verlagbestellnr` AS `Verlagbestellnr`,`Verlag`.`name` AS `verlagname`,`Autor`.`name` AS `autorname`,`CountAllCopiesOfBook`(`Buch`.`id`) AS `buchanzahl`,`CountAvailableCopiesOfBook`(`Buch`.`id`) AS `buchanzahlverfügbar` from ((((`Buch` join `Buchexemplar`) join `Autor`) join `Verlag`) join `Ausleihvorgang`) where ((`Buch`.`id` = `Buchexemplar`.`Buch_id`) and (`Buch`.`Verlagid` = `Verlag`.`id`) and (`Buch`.`Autorid` = `Autor`.`id`)) group by `Buch`.`id`;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
