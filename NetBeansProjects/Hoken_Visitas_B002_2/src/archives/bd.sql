-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Mar-2018 às 13:21
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `visitas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tablevisita`
--

CREATE TABLE `tablevisita` (
  `codigoVisita` int(11) NOT NULL,
  `nome` longtext NOT NULL,
  `endereco` longtext NOT NULL,
  `complemento` longtext,
  `bairro` longtext NOT NULL,
  `cep` varchar(20) NOT NULL,
  `cidade` longtext NOT NULL,
  `estado` varchar(100) NOT NULL,
  `telefoneFixo` varchar(20) DEFAULT NULL,
  `telefoneCelular` varchar(20) DEFAULT NULL,
  `telefoneRecado` varchar(20) DEFAULT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `diaSemana` varchar(45) NOT NULL,
  `indicacao` longtext,
  `vendedor1` longtext NOT NULL,
  `vendedor2` longtext,
  `vendeu` tinyint(4) DEFAULT NULL,
  `cancelada` tinyint(4) DEFAULT NULL,
  `observacoes` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `nome` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `codigoVendedor` int(11) NOT NULL,
  `nomeVendedor` varchar(300) NOT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tablevisita`
--
ALTER TABLE `tablevisita`
  ADD PRIMARY KEY (`codigoVisita`),
  ADD UNIQUE KEY `codigoVisita_UNIQUE` (`codigoVisita`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nome`,`senha`);

--
-- Indexes for table `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`codigoVendedor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tablevisita`
--
ALTER TABLE `tablevisita`
  MODIFY `codigoVisita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `codigoVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
