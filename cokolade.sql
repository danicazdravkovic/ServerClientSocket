/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cokolade` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `cokolade`;



DROP TABLE IF EXISTS `Administrator`;

CREATE TABLE `Administrator` (
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(20) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) VALUES 
(1,'Danica','Zdravkovic','dana','dana123'),
(2,'Ana','Mijovic','ana','ana');



DROP TABLE IF EXISTS `Kupac`;

CREATE TABLE `Kupac` (
  `KupacID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeKupca` VARCHAR(20) NOT NULL,
  `PrezimeKupca` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(20) NOT NULL,
  `BrojTelefona` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`KupacID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Kupac`(`KupacID`,`ImeKupca`,`PrezimeKupca`,`Email`,`BrojTelefona`) VALUES 
(1,'Ivona', 'Jovanovic', 'ivona@gmail.com', '0631231234'),
(2,'Milica', 'Neskovic', 'milica@gmail.com', '0654645434'),
(3,'Vesna', 'Gagic', 'vesna@gmail.com', '0641235153');


DROP TABLE IF EXISTS `Proizvodjac`;

CREATE TABLE `Proizvodjac` (
  `ProizvodjacID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivProizvodjaca` VARCHAR(50) NOT NULL,
  `Adresa` VARCHAR(70) NOT NULL,
  `BrojTelefona` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ProizvodjacID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Proizvodjac`(`ProizvodjacID`,`NazivProizvodjaca`,`Adresa`,`BrojTelefona`) VALUES 
(1,'Stark', 'Juzni Bulevar 55', '0631231234'),
(2,'Premier', 'Svetozara Markovica 18', '0654645434');


DROP TABLE IF EXISTS `VrstaCokolade`;

CREATE TABLE `VrstaCokolade` (
  `VrstaCokoladeID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivVrsteCokolade` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`VrstaCokoladeID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `VrstaCokolade`(`VrstaCokoladeID`,`NazivVrsteCokolade`) VALUES 
(1,'Mlecna cokolada'),
(2,'Crna cokolada'),
(3,'Bela cokolada'),
(4,'Belgijska cokolada');




DROP TABLE IF EXISTS `Cokolada`;

CREATE TABLE `Cokolada` (
  `CokoladaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivCokolade` VARCHAR(50) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  `CenaPoKG` DECIMAL(10,2) NOT NULL,
  `VrstaCokoladeID` BIGINT(10) UNSIGNED NOT NULL,
  `ProizvodjacID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`CokoladaID`),
  CONSTRAINT `fk_vrstaCokolade_id` FOREIGN KEY (`VrstaCokoladeID`) REFERENCES `VrstaCokolade` (`VrstaCokoladeID`),
  CONSTRAINT `fk_proizvodjac_id` FOREIGN KEY (`ProizvodjacID`) REFERENCES `Proizvodjac` (`ProizvodjacID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Cokolada`(`CokoladaID`,`NazivCokolade`,`Opis`,`CenaPoKG`,`VrstaCokoladeID`,`ProizvodjacID`) VALUES 
(1,'Najlepse Zelje Classic', 'Klasicni cokoladni snovi.', 1000, 1, 1),
(2,'Najlepse Zelje sa Keksom', 'Klasicni cokoladni snovi, ali sa keksom.', 1200, 1, 1),
(3,'Najlepse Zelje 75%', 'Crni cokoladni snovi.', 1600, 2, 1),
(4,'Tamna Cokolada Stevia', 'Cokolada sa stevijom.', 2100, 2, 2),
(5,'Avant Garde Blanc', 'Kvalitetna bela cokolada.', 2200, 3, 2),
(6,'Najlepse Zelje Bela', 'Beli cokoladni snovi.', 1300, 3, 1),
(7,'Premier Belgian', 'Kvalitetna belgijska cokolada.', 2500, 4, 2),
(8,'Stark Belgian', 'Belgijski cokoladni snovi.', 2100, 4, 1);


DROP TABLE IF EXISTS `Sastojak`;

CREATE TABLE `Sastojak` (
  `CokoladaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `RbSastojka` INT(7) NOT NULL,
  `NazivSastojka` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CokoladaID`,`RbSastojka`),
  CONSTRAINT `fk_cokoladica_id` FOREIGN KEY (`CokoladaID`) REFERENCES `Cokolada` (`CokoladaID`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Sastojak`(`CokoladaID`,`RbSastojka`,`NazivSastojka`) VALUES 
(1,1,'Kakao maslac'),
(1,2,'Kakao puter'),
(1,3,'Secer'),
(2,1,'Kakao maslac'),
(2,2,'Kakao puter'),
(2,3,'Secer'),
(3,1,'Kakao maslac'),
(3,2,'Kakao puter'),
(3,3,'Secer'),
(4,1,'Kakao maslac'),
(4,2,'Kakao puter'),
(4,3,'Secer'),
(5,1,'Kakao maslac'),
(5,2,'Kakao puter'),
(5,3,'Secer'),
(6,1,'Kakao maslac'),
(6,2,'Kakao puter'),
(6,3,'Secer'),
(7,1,'Kakao maslac'),
(7,2,'Kakao puter'),
(7,3,'Secer'),
(8,1,'Kakao maslac'),
(8,2,'Kakao puter'),
(8,3,'Secer');


DROP TABLE IF EXISTS `Racun`;

CREATE TABLE `Racun` (
  `RacunID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVreme` DATETIME NOT NULL,
  `UkupanIznos` DECIMAL(10,2) NOT NULL,
  `KupacID` BIGINT(10) UNSIGNED NOT NULL,
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`RacunID`),
  CONSTRAINT `fk_kupac_id` FOREIGN KEY (`KupacID`) REFERENCES `Kupac` (`KupacID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `Administrator` (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Racun`(`RacunID`,`DatumVreme`,`UkupanIznos`,`KupacID`,`AdministratorID`) VALUES 
(1,'2022-01-15 14:33:29',2200,1,1);


DROP TABLE IF EXISTS `StavkaRacuna`;

CREATE TABLE `StavkaRacuna` (
  `RacunID` BIGINT(10) UNSIGNED NOT NULL,
  `RbStavke` INT(7) NOT NULL,
  `KolicinaStavke` DECIMAL(10,2) NOT NULL,
  `CenaStavke` DECIMAL(10,2) NOT NULL,
  `CokoladaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`RacunID`,`RbStavke`),
  CONSTRAINT `fk_racun_id` FOREIGN KEY (`RacunID`) REFERENCES `Racun` (`RacunID`) ON DELETE CASCADE,
  CONSTRAINT `fk_cokol_id` FOREIGN KEY (`CokoladaID`) REFERENCES `Cokolada` (`CokoladaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `StavkaRacuna`(`RacunID`,`RbStavke`,`KolicinaStavke`,`CenaStavke`, `CokoladaID`) VALUES 
(1,1,1,1000,1),
(1,2,1,1200,2);





/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
