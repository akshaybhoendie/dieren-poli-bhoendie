-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.24 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for dieren_poli_bhoendie
CREATE DATABASE IF NOT EXISTS `dieren_poli_bhoendie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dieren_poli_bhoendie`;

-- Dumping structure for table dieren_poli_bhoendie.dienst
CREATE TABLE IF NOT EXISTS `dienst` (
                                        `id` bigint NOT NULL,
                                        `actief` bit(1) NOT NULL DEFAULT b'0',
    `datum` datetime DEFAULT NULL,
    `opmerking` varchar(255) DEFAULT NULL,
    `aangemaaktDoor` bigint DEFAULT NULL,
    `afgehandeldDoor` bigint DEFAULT NULL,
    `dienstType_id` bigint DEFAULT NULL,
    `lidmaatschapId` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKi06d9bksedm3i5i0bgwnfcq4c` (`aangemaaktDoor`),
    KEY `FK26pml43j1u2bb5nd8l8p1vv0d` (`afgehandeldDoor`),
    KEY `FKhjiml0f16avdddmknhi452m6a` (`dienstType_id`),
    KEY `FKtmkqscojak7dhw7a20aqv1vqn` (`lidmaatschapId`),
    CONSTRAINT `FK26pml43j1u2bb5nd8l8p1vv0d` FOREIGN KEY (`afgehandeldDoor`) REFERENCES `gebruiker` (`id`),
    CONSTRAINT `FKhjiml0f16avdddmknhi452m6a` FOREIGN KEY (`dienstType_id`) REFERENCES `diensttype` (`id`),
    CONSTRAINT `FKi06d9bksedm3i5i0bgwnfcq4c` FOREIGN KEY (`aangemaaktDoor`) REFERENCES `gebruiker` (`id`),
    CONSTRAINT `FKtmkqscojak7dhw7a20aqv1vqn` FOREIGN KEY (`lidmaatschapId`) REFERENCES `lidmaatschap` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.dienst: ~1 rows (approximately)
/*!40000 ALTER TABLE `dienst` DISABLE KEYS */;
INSERT INTO `dienst` (`id`, `actief`, `datum`, `opmerking`, `aangemaaktDoor`, `afgehandeldDoor`, `dienstType_id`, `lidmaatschapId`) VALUES
(1, b'1', '2021-03-24 15:47:07', 'Vis is ziek', 1, 1, 1, 1),
(2, b'1', '2022-03-24 16:27:05', 'Vis is gezond', 1, 1, 1, 1);
/*!40000 ALTER TABLE `dienst` ENABLE KEYS */;

-- Dumping structure for table dieren_poli_bhoendie.diensttype
CREATE TABLE IF NOT EXISTS `diensttype` (
                                            `id` bigint NOT NULL,
                                            `actief` bit(1) NOT NULL DEFAULT b'0',
    `code` varchar(255) DEFAULT NULL,
    `naam` varchar(255) DEFAULT NULL,
    `omschrijving` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.diensttype: ~1 rows (approximately)
/*!40000 ALTER TABLE `diensttype` DISABLE KEYS */;
INSERT INTO `diensttype` (`id`, `actief`, `code`, `naam`, `omschrijving`) VALUES
(1, b'1', 'CON', 'Consul', 'Standaard checkup');
/*!40000 ALTER TABLE `diensttype` ENABLE KEYS */;

-- Dumping structure for table dieren_poli_bhoendie.dier
CREATE TABLE IF NOT EXISTS `dier` (
                                      `id` bigint NOT NULL,
                                      `categorie` varchar(255) DEFAULT NULL,
    `geboordeDatum` date DEFAULT NULL,
    `gewicht` double DEFAULT NULL,
    `naam` varchar(255) DEFAULT NULL,
    `overleden` bit(1) NOT NULL DEFAULT b'0',
    `soort` varchar(255) DEFAULT NULL,
    `lidmaatschapId` bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK4uka4ory0be1hwu2bskdcdfne` (`lidmaatschapId`),
    CONSTRAINT `FK4uka4ory0be1hwu2bskdcdfne` FOREIGN KEY (`lidmaatschapId`) REFERENCES `lidmaatschap` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.dier: ~1 rows (approximately)
/*!40000 ALTER TABLE `dier` DISABLE KEYS */;
INSERT INTO `dier` (`id`, `categorie`, `geboordeDatum`, `gewicht`, `naam`, `overleden`, `soort`, `lidmaatschapId`) VALUES
(1, 'VIS', '2018-03-24', 8, 'Nemo', b'0', 'Clownvis', 1);
/*!40000 ALTER TABLE `dier` ENABLE KEYS */;

-- Dumping structure for table dieren_poli_bhoendie.gebruiker
CREATE TABLE IF NOT EXISTS `gebruiker` (
                                           `id` bigint NOT NULL,
                                           `achternaam` varchar(255) DEFAULT NULL,
    `actief` bit(1) NOT NULL DEFAULT b'0',
    `geboorteDatum` date DEFAULT NULL,
    `naam` varchar(255) DEFAULT NULL,
    `rolType` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.gebruiker: ~1 rows (approximately)
/*!40000 ALTER TABLE `gebruiker` DISABLE KEYS */;
INSERT INTO `gebruiker` (`id`, `achternaam`, `actief`, `geboorteDatum`, `naam`, `rolType`) VALUES
(1, 'Bhoendie', b'1', '1993-03-24', 'Akhsay', 'ARTS');
/*!40000 ALTER TABLE `gebruiker` ENABLE KEYS */;

-- Dumping structure for table dieren_poli_bhoendie.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.hibernate_sequence: ~5 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table dieren_poli_bhoendie.lidmaatschap
CREATE TABLE IF NOT EXISTS `lidmaatschap` (
                                              `id` bigint NOT NULL,
                                              `achternaam` varchar(255) DEFAULT NULL,
    `actief` bit(1) NOT NULL DEFAULT b'0',
    `geboorteDatum` date DEFAULT NULL,
    `inschrijfDatum` datetime DEFAULT NULL,
    `lidmaatschapNummer` bigint DEFAULT NULL,
    `voornaam` varchar(255) DEFAULT NULL,
    `creator_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKm6yob6xvtn4iaqvhfr0b2mv2d` (`creator_id`),
    CONSTRAINT `FKm6yob6xvtn4iaqvhfr0b2mv2d` FOREIGN KEY (`creator_id`) REFERENCES `gebruiker` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table dieren_poli_bhoendie.lidmaatschap: ~1 rows (approximately)
/*!40000 ALTER TABLE `lidmaatschap` DISABLE KEYS */;
INSERT INTO `lidmaatschap` (`id`, `achternaam`, `actief`, `geboorteDatum`, `inschrijfDatum`, `lidmaatschapNummer`, `voornaam`, `creator_id`) VALUES
(1, 'Klein', b'1', '1996-03-24', '2022-03-24 15:45:37', 456789879, 'Raisha', 1);
/*!40000 ALTER TABLE `lidmaatschap` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
