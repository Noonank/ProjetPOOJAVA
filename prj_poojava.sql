-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 03 Juin 2020 à 22:05
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `prj_poojava`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE IF NOT EXISTS `cours` (
  `ID_cours` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_cours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`ID_cours`, `Nom`) VALUES
(1, 'Traitement du signal 2'),
(2, 'POO Java'),
(3, 'Anthropologie'),
(4, 'web dynamique'),
(5, 'probabilite et statistique'),
(6, 'analyse de fourier');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_utilisateur` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  KEY `ID_cours` (`ID_cours`),
  KEY `ID_utilisateur` (`ID_utilisateur`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_utilisateur`, `ID_cours`) VALUES
(2, 2),
(2, 4),
(16, 5),
(16, 6),
(17, 2),
(17, 4);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_utilisateur` int(11) NOT NULL,
  `Numéro` varchar(255) NOT NULL,
  `ID_groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_utilisateur`),
  KEY `ID_groupe` (`ID_groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_utilisateur`, `Numéro`, `ID_groupe`) VALUES
(1, '931800843', 1),
(5, '931702243', 1),
(6, '931702066', 6),
(7, '931702067', 6),
(8, '931702097', 5),
(9, '931702370', 2),
(10, '931702000', 2),
(11, '931702098', 5),
(12, '931702099', 4),
(13, '931702100', 4),
(14, '931702014', 3),
(15, '931702015\r\n', 3);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `ID_promotion` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_promotion` (`ID_promotion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `Nom`, `ID_promotion`) VALUES
(1, 'TD06', 2022),
(2, 'TD05', 2022),
(3, 'TD10', 2023),
(4, 'TD08', 2023),
(5, 'TD04', 2021),
(6, 'TD01', 2021);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2024 ;

--
-- Contenu de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `Nom`) VALUES
(2021, '2021\r\n'),
(2022, '2022'),
(2023, '2023\r\n');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacité` int(11) NOT NULL,
  `ID_site` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_site` (`ID_site`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`ID`, `Nom`, `Capacité`, `ID_site`) VALUES
(1, 'EM009', 120, 1),
(2, 'EM010', 120, 1),
(3, 'P440', 40, 2),
(4, 'P406', 40, 2),
(5, 'G002', 80, 3),
(6, 'G012', 40, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE IF NOT EXISTS `seance` (
  `ID_seance` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_debut` time NOT NULL,
  `Heure_fin` time NOT NULL,
  `Etat` int(11) NOT NULL,
  `ID_cours` int(11) NOT NULL,
  `ID_type` int(11) NOT NULL,
  PRIMARY KEY (`ID_seance`),
  KEY `ID_type` (`ID_type`),
  KEY `ID_cours` (`ID_cours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignant`
--

CREATE TABLE IF NOT EXISTS `seance_enseignant` (
  `ID_seance` int(11) NOT NULL,
  `ID_enseignant` int(11) NOT NULL,
  KEY `ID_seance` (`ID_seance`),
  KEY `ID_enseignant` (`ID_enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_seance` int(11) NOT NULL,
  `ID_groupe` int(11) NOT NULL,
  KEY `ID_groupe` (`ID_groupe`),
  KEY `ID_seance` (`ID_seance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salle`
--

CREATE TABLE IF NOT EXISTS `seance_salle` (
  `ID_seance` int(11) NOT NULL,
  `ID_salle` int(11) NOT NULL,
  KEY `ID_seance` (`ID_seance`),
  KEY `ID_salle` (`ID_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE IF NOT EXISTS `site` (
  `ID_site` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_site`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `site`
--

INSERT INTO `site` (`ID_site`, `Nom`) VALUES
(1, 'Eiffel1'),
(2, 'Eiffel2'),
(3, 'Eiffel4');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `Nom`) VALUES
(1, 'interactif'),
(2, 'magistral'),
(3, 'TP'),
(4, 'TD'),
(5, 'projet\r\n'),
(6, 'soutien\r\n');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prénom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  PRIMARY KEY (`ID_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_utilisateur`, `Email`, `Password`, `Nom`, `Prénom`, `Droit`) VALUES
(1, 'noor.kardache@edu.ece.fr', 'noor', 'Kardache', 'Noor', 4),
(2, 'jean-pierre.segado@ece.fr', 'jps', 'Segado', 'Jean-Pierre', 3),
(3, 'edt@ece.fr', 'edt', 'Planification', 'ECE', 1),
(4, 'fabienne.coudray@ece.fr', 'fc', 'Coudray', 'Fabienne', 2),
(5, 'tiffanie.jego-ragas@edu.ece.fr', 'tiff', 'Jego-Ragas', 'Tiffanie', 4),
(6, 'sarah.kardache@edu.ece.fr', 'sk', 'Kardache', 'Sarah', 4),
(7, 'estelle.drancy@edu.ece.fr', 'estelle', 'Drancy', 'Estelle', 4),
(8, 'yasmine.tahri@edu.ece.fr', 'yassou', 'Tahri', 'Yasmine', 4),
(9, 'simon.zhang@edu.ece.fra', 'simsim', 'Zhang', 'Simon', 4),
(10, 'claire.prevost@edu.ece.fr', 'ccc', 'Prevost\r\n', 'Claire', 4),
(11, 'jean-baptiste.guerin@edu.ece.fr', 'jbg\r\n', 'Guerin\r\n', 'Jean-Baptiste', 4),
(12, 'romain.barrere@edu.ece.fr', 'rb', 'Barrere\r\n', 'Romain', 4),
(13, 'oceane.jego-ragas@edu.ece.fr', 'ojr', 'Jego-Ragas', 'Oceane', 4),
(14, 'tom.sella@edu.ece.fr', 'tom', 'Sella', 'Tom', 4),
(15, 'anne-charlotte.vignon@edu.ece.fr', 'annec', 'Vignon', 'Anne-Charlotte', 4),
(16, 'ldelisle@inseec-edu.com', 'ld', 'Delisle', 'Laurent', 3),
(17, 'manolo-dulva.hina@ece.fr', 'manolo', 'Hina', 'Manolo-Dulva', 3);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `ID_utilisateur_enseignant` FOREIGN KEY (`ID_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `ID_groupe_etudiant` FOREIGN KEY (`ID_groupe`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `ID_utilisateur_etudiant` FOREIGN KEY (`ID_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `ID_promotion` FOREIGN KEY (`ID_promotion`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `seance_enseignant`
--
ALTER TABLE `seance_enseignant`
  ADD CONSTRAINT `ID_seance_enseignant_enseignant` FOREIGN KEY (`ID_enseignant`) REFERENCES `enseignant` (`ID_utilisateur`),
  ADD CONSTRAINT `ID_seance_enseignant_seance` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `ID_seance_groupe_groupe` FOREIGN KEY (`ID_groupe`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `ID_seance_groupe_seance` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);

--
-- Contraintes pour la table `seance_salle`
--
ALTER TABLE `seance_salle`
  ADD CONSTRAINT `ID_seance_salle_salle` FOREIGN KEY (`ID_salle`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `ID_seance_salle_seance` FOREIGN KEY (`ID_seance`) REFERENCES `seance` (`ID_seance`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
