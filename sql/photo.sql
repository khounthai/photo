-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 04 juin 2019 à 19:51
-- Version du serveur :  10.1.40-MariaDB
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `photo`
--

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `nom`) VALUES
(1, 'anniversaire'),
(2, 'réunion de famille'),
(3, 'mariage'),
(4, 'aucun');

-- --------------------------------------------------------

--
-- Structure de la table `lien`
--

CREATE TABLE `lien` (
  `idmedia` int(11) NOT NULL,
  `idpersonne` int(11) NOT NULL,
  `idlieu` int(11) NOT NULL,
  `idevenement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lien`
--

INSERT INTO `lien` (`idmedia`, `idpersonne`, `idlieu`, `idevenement`) VALUES
(2, 2, 1, 4),
(3, 2, 1, 4),
(4, 2, 1, 4),
(5, 2, 1, 4),
(6, 2, 2, 4),
(7, 2, 2, 4),
(8, 2, 1, 4),
(9, 2, 1, 4),
(10, 2, 1, 4),
(11, 2, 1, 4),
(11, 4, 1, 4),
(12, 3, 2, 4),
(12, 5, 2, 4),
(13, 3, 2, 4),
(13, 5, 2, 4),
(15, 6, 3, 4),
(15, 13, 3, 4),
(16, 9, 4, 4),
(16, 10, 4, 4),
(17, 10, 4, 4),
(17, 12, 4, 4),
(17, 13, 4, 4),
(17, 17, 4, 4),
(18, 14, 4, 4),
(18, 18, 4, 4),
(19, 18, 2, 2),
(20, 12, 2, 2),
(20, 18, 2, 2),
(21, 12, 2, 2),
(21, 18, 2, 2),
(22, 14, 4, 4),
(23, 14, 1, 1),
(25, 4, 1, 1),
(25, 7, 1, 1),
(25, 11, 1, 1),
(26, 4, 1, 1),
(26, 15, 1, 1),
(27, 4, 1, 1),
(27, 7, 1, 1),
(27, 8, 1, 1),
(28, 18, 4, 2),
(29, 18, 4, 2),
(30, 18, 4, 2),
(31, 18, 4, 2),
(33, 6, 1, 4),
(33, 16, 1, 4),
(34, 16, 1, 4),
(35, 7, 1, 4),
(36, 4, 1, 4),
(37, 4, 1, 1),
(37, 7, 1, 1),
(37, 8, 1, 1),
(37, 12, 1, 1),
(37, 14, 1, 1),
(37, 15, 1, 1),
(38, 4, 1, 1),
(38, 7, 1, 1),
(38, 8, 1, 1),
(38, 14, 1, 1),
(39, 8, 1, 1),
(40, 4, 1, 1),
(40, 7, 1, 1),
(40, 11, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE `lieu` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id`, `nom`) VALUES
(1, 'reims'),
(2, 'st martin de crau'),
(3, 'pont du gard'),
(4, 'inconnu');

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `chemin` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `commentaire` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `media`
--

INSERT INTO `media` (`id`, `chemin`, `commentaire`) VALUES
(2, 'images/image1.jpg', 'minette'),
(3, 'images/image2.jpg', 'minette'),
(4, 'images/img026.jpg', 'minette'),
(5, 'images/img027.jpg', 'minette'),
(6, 'images/img028.jpg', 'minette et cochon d\'inde'),
(7, 'images/img029.jpg', 'minette et cochon d\'inde'),
(8, 'images/img031.jpg', 'minette sur le lit'),
(9, 'images/img032.jpg', 'minette sur le lit'),
(10, 'images/img033.jpg', 'minette sur le lit'),
(11, 'images/img034.jpg', 'Tarek et minette'),
(12, 'images/img035.jpg', 'Victor et minou'),
(13, 'images/img036.jpg', 'Victor et minou'),
(15, 'images/img037.jpg', 'pont du guard'),
(16, 'images/img038.jpg', 'des glaces'),
(17, 'images/img039.jpg', 'papy'),
(18, 'images/img040.jpg', 'barbeQ'),
(19, 'images/img041.jpg', 'reunion de famille'),
(20, 'images/img042.jpg', 'reunion de famille'),
(21, 'images/img043.jpg', 'reunion de famille'),
(22, 'images/img044.jpg', 'reunion de famille'),
(23, 'images/img045.jpg', 'anniversaire Tarek'),
(25, 'images/img046.jpg', 'anniversaire Tarek'),
(26, 'images/img047.jpg', 'anniversaire Tarek'),
(27, 'images/img048.jpg', 'anniversaire Tarek'),
(28, 'images/img049.jpg', 'reunion de famille'),
(29, 'images/img050.jpg', 'r?unionreunion de famille'),
(30, 'images/img051.jpg', 'r?unionreunion de famille'),
(31, 'images/img052.jpg', 'r?unionreunion de famille'),
(33, 'images/img053.jpg', 'mamen et pa, reims en hivers'),
(34, 'images/img054.jpg', 'pa, reims en hivers'),
(35, 'images/img055.jpg', 'Marie duwyn'),
(36, 'images/img056.jpg', 'Tarek'),
(37, 'images/img057.jpg', 'anniversaire Tarek'),
(38, 'images/img058.jpg', 'anniversaire Tarek'),
(39, 'images/img059.jpg', 'anniversaire Tarek'),
(40, 'images/img060.jpg', 'anniversaire Tarek');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `prenom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `prenom`, `nom`) VALUES
(2, 'minette', 'houang'),
(3, 'minou', 'houang'),
(4, 'tarek', 'driss'),
(5, 'victor', 'coumou'),
(6, 'maman', 'houang'),
(7, 'marie', 'duwyn'),
(8, 'antoine', 'duwyn'),
(9, 'kiem', 'baccam'),
(10, 'ta', 'baccam'),
(11, 'appolo', 'houang'),
(12, 'anoury', 'houang'),
(13, 'angkhala', 'houang'),
(14, 'inconnu', 'inconnu'),
(15, 'raouda', 'driss'),
(16, 'pa', 'houang'),
(17, 'papy', 'cam'),
(18, 'groupe', ''),
(19, 'khountha?', 'houang');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `lien`
--
ALTER TABLE `lien`
  ADD PRIMARY KEY (`idmedia`,`idpersonne`,`idlieu`);

--
-- Index pour la table `lieu`
--
ALTER TABLE `lieu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `lieu`
--
ALTER TABLE `lieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
