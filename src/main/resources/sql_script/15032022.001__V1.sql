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
    `lidmaatschap_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKi06d9bksedm3i5i0bgwnfcq4c` (`aangemaaktDoor`),
    KEY `FK26pml43j1u2bb5nd8l8p1vv0d` (`afgehandeldDoor`),
    KEY `FKhjiml0f16avdddmknhi452m6a` (`dienstType_id`),
    KEY `FK948ckiuis9xwurk5akuybbg9g` (`lidmaatschap_id`),
    CONSTRAINT `FK26pml43j1u2bb5nd8l8p1vv0d` FOREIGN KEY (`afgehandeldDoor`) REFERENCES `gebruiker` (`id`),
    CONSTRAINT `FK948ckiuis9xwurk5akuybbg9g` FOREIGN KEY (`lidmaatschap_id`) REFERENCES `lidmaatschap` (`id`),
    CONSTRAINT `FKhjiml0f16avdddmknhi452m6a` FOREIGN KEY (`dienstType_id`) REFERENCES `diensttype` (`id`),
    CONSTRAINT `FKi06d9bksedm3i5i0bgwnfcq4c` FOREIGN KEY (`aangemaaktDoor`) REFERENCES `gebruiker` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table dieren_poli_bhoendie.diensttype
CREATE TABLE IF NOT EXISTS `diensttype` (
                                            `id` bigint NOT NULL,
                                            `actief` bit(1) NOT NULL DEFAULT b'0',
    `code` varchar(255) DEFAULT NULL,
    `naam` varchar(255) DEFAULT NULL,
    `omschrijving` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table dieren_poli_bhoendie.dier
CREATE TABLE IF NOT EXISTS `dier` (
                                      `id` bigint NOT NULL,
                                      `categorie` varchar(255) DEFAULT NULL,
    `geboordeDatum` date DEFAULT NULL,
    `gewicht` double DEFAULT NULL,
    `naam` varchar(255) DEFAULT NULL,
    `overleden` bit(1) NOT NULL DEFAULT b'0',
    `soort` varchar(255) DEFAULT NULL,
    `lidmaatschap_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKd0jow7cb48vvuhh1y2k6goao1` (`lidmaatschap_id`),
    CONSTRAINT `FKd0jow7cb48vvuhh1y2k6goao1` FOREIGN KEY (`lidmaatschap_id`) REFERENCES `lidmaatschap` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

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

-- Data exporting was unselected.

-- Dumping structure for table dieren_poli_bhoendie.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table dieren_poli_bhoendie.lidmaatschap
CREATE TABLE IF NOT EXISTS `lidmaatschap` (
                                              `id` bigint NOT NULL,
                                              `achternaam` varchar(255) DEFAULT NULL,
    `actief` bit(1) NOT NULL DEFAULT b'0',
    `geboorteDatum` date DEFAULT NULL,
    `inschrijfDatum` datetime DEFAULT NULL,
    `lidmaatschapNummer` bigint DEFAULT NULL,
    `voornaam` varchar(255) DEFAULT NULL,
    `gebruiker_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKmmxp144co3riyr3foro4v3kw` (`gebruiker_id`),
    CONSTRAINT `FKmmxp144co3riyr3foro4v3kw` FOREIGN KEY (`gebruiker_id`) REFERENCES `gebruiker` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
