-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 27 avr. 2021 à 19:28
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

CREATE TABLE `arbitre` (
  `idar` varchar(25) NOT NULL,
  `nomar` varchar(25) NOT NULL,
  `prenomar` varchar(25) NOT NULL,
  `dnar` date NOT NULL,
  `paysar` varchar(25) NOT NULL,
  `id_c` varchar(25) NOT NULL,
  `utili` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `arbitre`
--

INSERT INTO `arbitre` (`idar`, `nomar`, `prenomar`, `dnar`, `paysar`, `id_c`, `utili`) VALUES
('az', 'vcb', 'vcb', '2021-04-07', 'fdg', '125', 'ttttt@gmail.com'),
('az', 'fdg', 'sss', '2021-05-01', 'dfg', 'hgjh', 'ttttt@gmail.com'),
('sds', 'ss', 'ss', '2021-04-09', 'ss', '1257', 'ttttt@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `mdp` varchar(11) NOT NULL,
  `adr` varchar(25) NOT NULL,
  `dn` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`nom`, `prenom`, `email`, `mdp`, `adr`, `dn`) VALUES
('BEN MANSOUR', 'WISSEM', 'ggg@gmail.com', '45', 'city ', '2021-04-08'),
('BEN', 'ccccc', 'gggg@gmail.com', '1234', 'city', '2021-04-08'),
('fgjhfgj', 'ppp', 'hhhhhhhh@gmail.com', '159', 'borjh', '2021-04-10'),
('lll', 't88', 'ttttt@gmail.com', '99', 'london', '0005-05-04'),
('BEN MANSOUR', 'WISSEM', 'wissemben@gmail.com', '147', 'city ', '2021-04-20');

-- --------------------------------------------------------

--
-- Structure de la table `compt`
--

CREATE TABLE `compt` (
  `id` varchar(25) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `dec` varchar(20) NOT NULL,
  `nbe` int(2) NOT NULL,
  `cu` varchar(25) NOT NULL,
  `f` varchar(20) NOT NULL,
  `db` date NOT NULL,
  `df` date NOT NULL,
  `con` varchar(25) NOT NULL,
  `gen` varchar(25) NOT NULL,
  `cat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compt`
--

INSERT INTO `compt` (`id`, `nom`, `dec`, `nbe`, `cu`, `f`, `db`, `df`, `con`, `gen`, `cat`) VALUES
('12', 'aa', 'football', 2, 'gggg@gmail.com', 'championat', '2021-04-01', '2021-04-06', 'Amical', 'homme', 'Senior'),
('12', 'hhh', 'football', 99, 'hhhhhhhh@gmail.com', 'championat', '2021-04-09', '2021-04-07', 'Amical', 'homme', 'Senior'),
('12', 'gfj', 'basketball', 20, 'wissemben@gmail.com', 'championat', '2021-04-01', '2021-03-31', 'Amical', 'homme', 'Senior'),
('125', 'gfj', 'handball', 24, 'ttttt@gmail.com', 'championat', '2021-04-01', '2021-04-17', 'Official', 'homme', 'Senior'),
('125', 'fgsf', 'volyball', 5, 'wissemben@gmail.com', 'championat', '2021-04-08', '2021-04-14', 'Amical', 'homme', 'Junior'),
('1257', 'azr', 'football', 63, 'ttttt@gmail.com', 'championat', '2021-04-08', '2021-04-11', 'Amical', 'homme', 'Junior'),
('hgjh', 'aa', 'football', 99, 'hhhhhhhh@gmail.com', 'championat', '2021-04-02', '2021-04-07', 'Amical', 'homme', 'Senior'),
('hgjh', 'gfjhg', 'football', 45, 'ttttt@gmail.com', 'championat', '2021-03-31', '2021-04-08', 'Amical', 'homme', 'Senior');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id_e` varchar(25) NOT NULL,
  `nom_e` varchar(25) NOT NULL,
  `nomp_e` varchar(25) NOT NULL,
  `nbj` int(2) NOT NULL,
  `df` date NOT NULL,
  `nom_t` varchar(50) NOT NULL,
  `id_c` varchar(25) NOT NULL,
  `utili` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id_e`, `nom_e`, `nomp_e`, `nbj`, `df`, `nom_t`, `id_c`, `utili`) VALUES
('1525', 'fgf', 'gfg', 0, '2021-04-21', 'fgf', '12', 'hhhhhhhh@gmail.com'),
('1525', 'aaaa', 'qsf', 0, '2021-05-01', 'sdsfd', 'hgjh', 'hhhhhhhh@gmail.com'),
('1525', 'eeeeee', 'aaaa', 1, '2021-04-22', 'rades', '1257', 'ttttt@gmail.com'),
('1525', 'kk', 'ppl', 0, '2021-04-16', 'FGJDKGH', 'hgjh', 'ttttt@gmail.com'),
('1525m', 'DQTSGD', 'fhyfh', 0, '2021-04-09', 'FGJDKGH', 'hgjh', 'ttttt@gmail.com'),
('dfd', 'fd', 'dgdq', 0, '2021-04-29', 'df', '1257', 'ttttt@gmail.com'),
('dgg', 'rt', 'fhyfh', 0, '2021-04-24', 'tttttttttttttttttt', '125', 'ttttt@gmail.com'),
('eezr', 'er', 'zer', 0, '2021-04-08', 'erer', '125', 'ttttt@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `idj` varchar(10) NOT NULL,
  `nomj` varchar(30) NOT NULL,
  `prenomj` varchar(25) NOT NULL,
  `dnj` date NOT NULL,
  `pays` varchar(30) NOT NULL,
  `id_c` varchar(30) NOT NULL,
  `utili` varchar(20) NOT NULL,
  `stj` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `joueur`
--

INSERT INTO `joueur` (`idj`, `nomj`, `prenomj`, `dnj`, `pays`, `id_c`, `utili`, `stj`) VALUES
('eze', 'd', 'rt', '2021-04-29', 'fg', 'hgjh', 'hhhhhhhh@gmail.com', 'aaaa'),
('123456', 'd', 'fdwg', '2021-04-25', 'df', 'hgjh', 'ttttt@gmail.com', 'Libre'),
('aaa', 'eqre', 'ert', '2021-04-08', 'ttttttttt', '1257', 'ttttt@gmail.com', '1525'),
('aaaaaaa', 'a', 'a', '2021-04-16', 'aaaaaaaaaaaaaaaaaaaa', '1257', 'ttttt@gmail.com', 'Libre'),
('dfcdfd', 'fdgwf', 'fdwg', '2021-04-16', 'df', '125', 'ttttt@gmail.com', 'sss');

-- --------------------------------------------------------

--
-- Structure de la table `matcht`
--

CREATE TABLE `matcht` (
  `idm` varchar(10) NOT NULL,
  `jtm` varchar(20) NOT NULL,
  `eq1` varchar(25) NOT NULL,
  `eq2` varchar(25) NOT NULL,
  `tm` varchar(25) NOT NULL,
  `dm` date NOT NULL,
  `rm` varchar(25) NOT NULL,
  `arm` varchar(25) NOT NULL,
  `etat` varchar(25) NOT NULL,
  `id_c` varchar(25) NOT NULL,
  `utili` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `matcht`
--

INSERT INTO `matcht` (`idm`, `jtm`, `eq1`, `eq2`, `tm`, `dm`, `rm`, `arm`, `etat`, `id_c`, `utili`) VALUES
('', '', 'rt', 'rt', 'tttttttttttttttttt', '2021-04-30', '3-0', 'vcb vcb', 'joué', '125', 'ttttt@gmail.com'),
('az', 'ee', 'aaaa', 'fd', 'stade mosfa ben janet', '2021-05-01', 'ne pas joue encore', 'fggfffgf gfgf', 'non_joues', '1257', 'ttttt@gmail.com'),
('aze', 'ezee', 'aaaa', 'aaaa', 'stade mosfa ben janet', '2021-05-06', '3-0', 'fggfffgf gfgf', 'joué', '1257', 'ttttt@gmail.com'),
('azt', '3 journee', 'eeeeee', 'fd', 'df', '2021-04-17', '2-1', 'ss ss', 'joué', '1257', 'ttttt@gmail.com'),
('dd', 'ddf', 'rt', 'rt', 'tttttttttttttttttt', '2021-04-24', 'ne pas joue encore', 'vcb vcb', 'non_joues', '125', 'ttttt@gmail.com'),
('ff', 'ff', 'rt', 'er', 'tttttttttttttttttt', '2021-05-01', 'ne pas joue encore', 'vcb vcb', 'non_joues', '125', 'ttttt@gmail.com'),
('g', 'k', 'rt', 'rt', 'tttttttttttttttttt', '2021-04-16', 'ne pas joue encore', 'vcb vcb', 'non_joues', '125', 'ttttt@gmail.com'),
('o', 'o', 'er', 'rt', 'tttttttttttttttttt', '2021-04-09', 'ne pas joue encore', 'vcb vcb', 'non_joues', '125', 'ttttt@gmail.com'),
('ss', 'ss', 'rt', 'rt', 'tttttttttttttttttt', '2021-04-15', 'ne pas joue encore', 'vcb vcb', 'non_joues', '125', 'ttttt@gmail.com'),
('ttt', 'ttttt', 'aaaa', 'aaaa', 'stade mosfa ben janet', '2021-04-09', '2-0', 'fggfffgf gfgf', 'joué', '1257', 'ttttt@gmail.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `arbitre`
--
ALTER TABLE `arbitre`
  ADD PRIMARY KEY (`idar`,`id_c`,`utili`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`email`);

--
-- Index pour la table `compt`
--
ALTER TABLE `compt`
  ADD PRIMARY KEY (`id`,`cu`),
  ADD KEY `cu` (`cu`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`utili`,`id_e`,`id_c`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`utili`,`idj`,`id_c`);

--
-- Index pour la table `matcht`
--
ALTER TABLE `matcht`
  ADD PRIMARY KEY (`idm`,`id_c`,`utili`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compt`
--
ALTER TABLE `compt`
  ADD CONSTRAINT `compt_ibfk_1` FOREIGN KEY (`cu`) REFERENCES `client` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
