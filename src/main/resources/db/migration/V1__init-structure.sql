-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 03 jan. 2022 à 20:06
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet-service`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie_entity`
--

CREATE TABLE `categorie_entity` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `salaire_par_heure` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client_entity`
--

CREATE TABLE `client_entity` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `employe_entity`
--

CREATE TABLE `employe_entity` (
  `id` bigint(20) NOT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `projet_entity`
--

CREATE TABLE `projet_entity` (
  `id` bigint(20) NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `projet_entity_projet_members`
--

CREATE TABLE `projet_entity_projet_members` (
  `projet_entity_id` bigint(20) NOT NULL,
  `projet_members_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `projet_member_entity`
--

CREATE TABLE `projet_member_entity` (
  `id` bigint(20) NOT NULL,
  `nbr_heures` int(11) NOT NULL,
  `employe_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie_entity`
--
ALTER TABLE `categorie_entity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client_entity`
--
ALTER TABLE `client_entity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employe_entity`
--
ALTER TABLE `employe_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1a38wm1ntujphaq1qc0f42sow` (`categorie_id`);

--
-- Index pour la table `projet_entity`
--
ALTER TABLE `projet_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3nxktbgvad5dfmqmxxvnsok6` (`client_id`);

--
-- Index pour la table `projet_entity_projet_members`
--
ALTER TABLE `projet_entity_projet_members`
  ADD KEY `FKdp3yam4axje9g55ui2qhc7x18` (`projet_members_id`),
  ADD KEY `FKrfgmjgq1ky5pj373j8n3lu4vs` (`projet_entity_id`);

--
-- Index pour la table `projet_member_entity`
--
ALTER TABLE `projet_member_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK537pttq993we6f04rgv49wqk2` (`employe_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `employe_entity`
--
ALTER TABLE `employe_entity`
  ADD CONSTRAINT `FK1a38wm1ntujphaq1qc0f42sow` FOREIGN KEY (`categorie_id`) REFERENCES `categorie_entity` (`id`);

--
-- Contraintes pour la table `projet_entity`
--
ALTER TABLE `projet_entity`
  ADD CONSTRAINT `FK3nxktbgvad5dfmqmxxvnsok6` FOREIGN KEY (`client_id`) REFERENCES `client_entity` (`id`);

--
-- Contraintes pour la table `projet_entity_projet_members`
--
ALTER TABLE `projet_entity_projet_members`
  ADD CONSTRAINT `FKdp3yam4axje9g55ui2qhc7x18` FOREIGN KEY (`projet_members_id`) REFERENCES `projet_member_entity` (`id`),
  ADD CONSTRAINT `FKrfgmjgq1ky5pj373j8n3lu4vs` FOREIGN KEY (`projet_entity_id`) REFERENCES `projet_entity` (`id`);

--
-- Contraintes pour la table `projet_member_entity`
--
ALTER TABLE `projet_member_entity`
  ADD CONSTRAINT `FK537pttq993we6f04rgv49wqk2` FOREIGN KEY (`employe_id`) REFERENCES `employe_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
